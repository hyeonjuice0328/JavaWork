package com.lec.java.crawl03;

import org.jsoup.Jsoup;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl03Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Daum 실시간 검색어");
		
		//TODO
		//www.daum.net
		//15개
		
		//Daum 실시간 검색어 가져오기 
		String url; //크롤링 할 주소 url
		Response response; // response 받을 response객체 
		Document doc;
		Element element;
		Elements elements;
		
		url = "https://www.daum.net";
		response = Jsoup.connect(url).execute(); //connection 실행, response객체 리턴
		
//		System.out.println(response.statusCode()); // 200 성공
//		System.out.println(response.statusMessage()); // OK
		
		doc = response.parse(); // document object까지 끄집어 냈다. 
		
		Elements favor_elements = doc.select("div.slide_favorsch ul.list_favorsch li a");
		System.out.println(favor_elements.size() + " 개");
//		System.out.println(elements.size() + " 개");
		
		for(Element e : favor_elements) {
			System.out.println(e.text().trim());
			System.out.println(e.attr("href").trim());
		}
		
		
		
		
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main

} //  end class
