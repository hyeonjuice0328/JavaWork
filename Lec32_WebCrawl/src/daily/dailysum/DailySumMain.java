package daily.dailysum;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * 연습 : 자치구단위 서울 생활인구 일별 집계표
 * ■자치구단위 서울 생활인구 일별 집계표
 * 	http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-15379&srvType=S&serviceKind=1&currentPageNo=1
 * 	http://openapi.seoul.go.kr:8088/(인증키)/(요청파일타입)/SPOP_DAILYSUM_JACHI/(요청시작INDEX)/(요청종료INDEX)/(기준일ID)/(시군구코드)
 * 
 * 샘플url
 * 	XML 버젼
 * 	http://openapi.seoul.go.kr:8088/7848716d426a6a7539307444475842/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * 	JSON 버젼
 * 	http://openapi.seoul.go.kr:8088/7848716d426a6a7539307444475842/json/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/	
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * ※ 한번에 1000개 까지의 데이터만 볼수 있슴
 * 
 */

/*  입력예]
 *  날짜입력: 20190101
 *  시작Index : 1
 *  끝Index: 5
 *  
 *  [XML]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490
 *   
 *  [JSON]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490 
 * 
 */

// ★ 주목 ★
// XML 은 Jsoup 를 활용하여 파싱하세요
// JSON 은  jackson 을 활용하여 파싱하세요

public class DailySumMain {

	public static final String REQ_SERVICE = "SPOP_DAILYSUM_JACHI";// 서비스 이름
	public static final String API_KEY = "7848716d426a6a7539307444475842"; // 내 키값

	public static void main(String[] args) throws IOException {

		// 변수 선언
		int startIndex;
		int endIndex;
		String date;
		int code; // 시군구코드

		// 크롤링할 내용
		// 기준일 ID - STDR_DE_ID
		// 구ID - SIGNGU_CODE_SE
		// 총생활일구수 - TOT_LVPOP_CO
		// 일최대이동인구수 - DAIL_MXMM_MVMN_LVPOP_CO
		URL url;
		String url_address;
		Document doc;
		Response response;
		Element element;
		Elements elements;

		startIndex = 1;
		endIndex = 5;
		date = "20190101";

		// XML파싱 (Jsoup활용)

		//xml parser 사용
		url_address = buildAddress("xml", 1, 5, "20190101");
		doc = Jsoup.connect(url_address).parser(Parser.xmlParser()).get();
//		System.out.println(url_address); //확인용
		elements = doc.select("row");
		
		System.out.println("날짜                    구ID        총생활인구수                일최대이동인구수");
		System.out.println("-------------------------------------------------------");
		
		for(Element e : elements) {
			String STDR_DE_ID = e.selectFirst("STDR_DE_ID").text().trim();
			String SIGNGU_CODE_SE = e.selectFirst("SIGNGU_CODE_SE").text().trim();
			String TOT_LVPOP_CO = e.selectFirst("TOT_LVPOP_CO").text().trim();
			String DAIL_MXMM_MVMN_LVPOP_CO = e.selectFirst("DAIL_MXMM_MVMN_LVPOP_CO").text().trim();
			
			System.out.printf("%8s %7s %16s %15s\n",STDR_DE_ID,SIGNGU_CODE_SE,TOT_LVPOP_CO,
					DAIL_MXMM_MVMN_LVPOP_CO);
		}
		
		System.out.println();
		// JSON 파싱 (jackson-databind)사용
		
		ObjectMapper mapper = new ObjectMapper();
		url = new URL( "http://openapi.seoul.go.kr:8088/7848716d426a6a7539307444475842/json/SPOP_DAILYSUM_JACHI/1/5/20190101");
		Spop spop = mapper.readValue(url, Spop.class);
		
		//System.out.println(spop.getSPOP_DAILYSUM_JACHI().getList_total_count());
		System.out.println("날짜                    구ID        총생활인구수                일최대이동인구수");
		System.out.println("-------------------------------------------------------");
		for(Subrow e : spop.getSPOP_DAILYSUM_JACHI().getRow()) {
			System.out.printf("%8s %7s %16s %15s\n",
					e.getStID(),
					e.getGuId(),
					e.getTotalPop(),
					e.getDailyPop());
		}
		
	} // end main

	public static String buildAddress(String reqType, int startIndex, int endIndex, String date) {

		String url_address = String.format("http://openapi.seoul.go.kr:8088/%s/%s/SPOP_DAILYSUM_JACHI/%d/%d/%s", API_KEY,
				reqType, startIndex, endIndex, date);

		
		return url_address;

	} // end buildAddress()

} // end class

@JsonIgnoreProperties(ignoreUnknown = true)
class Spop{
	public Subspop SPOP_DAILYSUM_JACHI;

	public Subspop getSPOP_DAILYSUM_JACHI() {
		return SPOP_DAILYSUM_JACHI;
	}

	public void setSPOP_DAILYSUM_JACHI(Subspop sPOP_DAILYSUM_JACHI) {
		SPOP_DAILYSUM_JACHI = sPOP_DAILYSUM_JACHI;
	}

} // end Spop

@JsonIgnoreProperties(ignoreUnknown = true)
class Subspop {
	
	private int list_total_count;
	private List<Subrow> row;
	
	
	public int getList_total_count() {
		return list_total_count;
	}
	public void setList_total_count(int list_total_count) {
		this.list_total_count = list_total_count;
	}
	public List<Subrow> getRow() {
		return row;
	}
	public void setRow(List<Subrow> row) {
		this.row = row;
	}
	
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Subrow {
	
	// 기준일 ID - STDR_DE_ID
	// 구ID - SIGNGU_CODE_SE
	// 총생활일구수 - TOT_LVPOP_CO
	// 일최대이동인구수 - DAIL_MXMM_MVMN_LVPOP_CO
	
	//@JsonProperty를 이용한 Rename
	@JsonProperty("STDR_DE_ID")
	private String StID;
	
	@JsonProperty("SIGNGU_CODE_SE")
	private String GuId;
	
	@JsonProperty("TOT_LVPOP_CO")
	private String TotalPop;
	
	@JsonProperty("DAIL_MXMM_MVMN_LVPOP_CO")
	private String DailyPop;

	//기본생성자
	public Subrow() {
		super();
	}

	//매개변수가 있는 생성자
	public Subrow(String stID, String guId, String totalPop, String dailyPop) {
		super();
		StID = stID;
		GuId = guId;
		TotalPop = totalPop;
		DailyPop = dailyPop;
	}

	//getter&setter
	public String getStID() {
		return StID;
	}

	public void setStID(String stID) {
		StID = stID;
	}

	public String getGuId() {
		return GuId;
	}

	public void setGuId(String guId) {
		GuId = guId;
	}

	public String getTotalPop() {
		return TotalPop;
	}

	public void setTotalPop(String totalPop) {
		TotalPop = totalPop;
	}

	public String getDailyPop() {
		return DailyPop;
	}

	public void setDailyPop(String dailyPop) {
		DailyPop = dailyPop;
	}
	
	
}