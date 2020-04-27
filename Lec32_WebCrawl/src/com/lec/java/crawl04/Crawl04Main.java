package com.lec.java.crawl04;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl04Main {

	public static void main(String[] args) throws IOException {
		System.out.println("네이버 연관 검색어");
		
		String url;
		Document doc; 
		Response response;
		Elements elements;
		
		String searchKeyword;

		Scanner sc = new Scanner(System.in);
		System.out.println("검색어를 입력하세요: ");
		searchKeyword = sc.nextLine();
		sc.close();
		
		String encoded = URLEncoder.encode(searchKeyword, "utf-8"); // naver page가 utf-8을 지원하기 때문에 사용 
		url = "https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=" + encoded; // = 이후의 문자들을 변경할 예정
		
		System.out.println(url); //생성된 url 확인
		
		doc = Jsoup.connect(url).execute().parse();
		
		elements = doc.select("ul._related_keyword_ul li a");
		System.out.println(elements.size() + " 개");
		
		for(Element element : elements) {
			System.out.println(element.text().trim());
		}
				
		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class
