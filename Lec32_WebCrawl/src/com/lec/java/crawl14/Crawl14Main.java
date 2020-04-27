package com.lec.java.crawl14;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;

/* XML, Json 파싱1
 * 
 * ■서울시 지하철호선별 역별 승하차 인원 정보 
 * http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12914&srvType=A&serviceKind=1&currentPageNo=1
 * 
 * 샘플url
 * XML 버젼
 * http://openapi.seoul.go.kr:8088/7848716d426a6a7539307444475842/xml/CardSubwayStatsNew/1/5/20181001
 * 예) http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/CardSubwayStatsNew/1/5/20181001
 *   
 * JSON 버젼
 * http://openapi.seoul.go.kr:8088/7848716d426a6a7539307444475842/json/CardSubwayStatsNew/1/5/20181001
 * 예) http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/CardSubwayStatsNew/1/5/20181001 
 * */

public class Crawl14Main {

	public static void main(String[] args) throws IOException {
		System.out.println("jackson-databind 연습 : URL -> json -> Java");
		
		ObjectMapper mapper = new ObjectMapper();
		
		URL url = new URL("http://openapi.seoul.go.kr:8088/7848716d426a6a7539307444475842/json/CardSubwayStatsNew/1/5/20181001");
		Subway subway = mapper.readValue(url, Subway.class);
		
		System.out.println(subway.getCardSubwayStatsNew().getList_total_count());
		for(SubRow e : subway.getCardSubwayStatsNew().getRow()) {
			System.out.printf("%5s : %8s역 [승차:%6d 하차:%6d]\n", 
		
					e.getLineNum(),    
					e.getStationName(),     
					e.getRidePassenger(),          
					e.getAlightPassenger());            
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

@JsonIgnoreProperties(ignoreUnknown = true)
class Subway{ // JSON 파일에서 CardSubwayStatsNew 를 가져기 위한 클래스 
	public Stats CardSubwayStatsNew; // Why ? 이것만 public? private하면 null을 return

	public Stats getCardSubwayStatsNew() {
		return CardSubwayStatsNew;
	}

	public void setCardSubwayStatsNew(Stats cardSubwayStatsNew) {
		this.CardSubwayStatsNew = cardSubwayStatsNew;
	}
} // end Subway

@JsonIgnoreProperties(ignoreUnknown = true)
//annotation.JsonIgnoreProperties 사용해서 
class Stats { // list_total_count랑 row 를 가져 오기 위한 클래스 
	
	private int list_total_count;

	private List<SubRow> row;
	
	
	
	public int getList_total_count() {
		return list_total_count;
	}

	public void setList_total_count(int list_total_count) {
		this.list_total_count = list_total_count;
	}

	public List<SubRow> getRow() {
		return row;
	}

	public void setRow(List<SubRow> row) {
		this.row = row;
	}
	
	
} // end Stats

//(JSON 파일에 필드명과 매핑되는 Java 객체의 변수명은 똑같아야 하지만 굳이 달리 하고 싶다면 )
//@JsonProperty 를 사용하면 된다.
@JsonIgnoreProperties(ignoreUnknown = true) // 필드명 중 일부만 데려오기 때문에 사용
class SubRow { //JSON 파일에서 row 를 가져 오기 위한 클래스 
	
	//필요한 목록들만 변수로 선언 
	@JsonProperty("LINE_NUM") // JSON의 LINE_NUM을 lineNum으로 매칭
	private String lineNum;

	@JsonProperty("SUB_STA_NM")
	private String stationName;
	
	@JsonProperty("RIDE_PASGR_NUM")
	private int ridePassenger;

	@JsonProperty("ALIGHT_PASGR_NUM")
	private int alightPassenger;

	//기본생성자
	public SubRow() {
		super();
	}

	//매개변수 생성자
	public SubRow(String lineNum, String stationName, int ridePassenger, int alightPassenger) {
		super();
		this.lineNum = lineNum;
		this.stationName = stationName;
		this.ridePassenger = ridePassenger;
		this.alightPassenger = alightPassenger;
	}

	//getter & setter
	public String getLineNum() {
		return lineNum;
	}

	public void setLineNum(String lineNum) {
		this.lineNum = lineNum;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public int getRidePassenger() {
		return ridePassenger;
	}

	public void setRidePassenger(int ridePassenger) {
		this.ridePassenger = ridePassenger;
	}

	public int getAlightPassenger() {
		return alightPassenger;
	}

	public void setAlightPassenger(int alightPassenger) {
		this.alightPassenger = alightPassenger;
	}


	
} // end SubRow


// Retrofit
// Volley
