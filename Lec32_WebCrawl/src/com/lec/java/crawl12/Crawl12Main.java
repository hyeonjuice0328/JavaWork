package com.lec.java.crawl12;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

/*
 * Jsoup 를 사용한 XML Parsing
 * 
 */

public class Crawl12Main {

	public static final String REQ_SERVICE = "CardSubwayStationNew"; // 서비스 이름
	public static final String API_KEY = "7848716d426a6a7539307444475842"; // 내 키값
	
	public static void main(String[] args) throws IOException {
		System.out.println("서울시 지하철호선별 역별 승하차 인원 정보");
		String url = buildUrlAddress("xml", 1, 5, "20200329");
		
		//Jsoup으로 XML 파싱 할 때는 xml parser 사용
		Document doc = Jsoup.connect(url).parser(Parser.xmlParser()).get();
		Elements elements = doc.select("row"); // return type -> Elements
		for(Element e : elements) {
			String LINE_NUM = e.selectFirst("LINE_NUM").text().trim();
			String SUB_STA_NM = e.select("SUB_STA_NM").text().trim();
			String RIDE_PASGR_NUM = e.select("RIDE_PASGR_NUM").text().trim();
			String ALIGHT_PASGR_NUM = e.select("ALIGHT_PASGR_NUM").text().trim();
		
			System.out.printf("%5s : %8s역 [승차:%6s 하차:%6s]\n", LINE_NUM, SUB_STA_NM, RIDE_PASGR_NUM,
					ALIGHT_PASGR_NUM);
		}
		
	} // end main
	
	public static String buildUrlAddress(String reqType, int startIndex, int endIndex, String date) {

		String url_address = String.format("http://openapi.seoul.go.kr:8088/%s/%s/CardSubwayStatsNew/%d/%d/%s", API_KEY,
				reqType, startIndex, endIndex, date);

		return url_address;
	} // end buildUrlAddress()
	

} // end class
