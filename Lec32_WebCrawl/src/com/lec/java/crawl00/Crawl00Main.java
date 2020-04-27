package com.lec.java.crawl00;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl00Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Jsoup");

		Element element;
		Elements elements;

		File f = new File("data/hello.html");
		Document doc = Jsoup.parse(f, "UTF-8");
		// 파일 > Document로 변환 (DOM구조 변환)

//		System.out.println(doc.outerHtml()); > doc.outerHtml() : 간단하게 내용 보는 용으로 사용 

		// Document 나 Element 객체에서 쓸수 있는 메소드는
		// select(), selectFirst() 메소드로 특정 element(들)을 추출

		element = doc.selectFirst("div");
//		System.out.println(element.outerHtml()); // >>첫번째 div를 출력

		elements = doc.select("div");
		System.out.println(elements.size() + " 개");

		// Elements 의 get(n) -> n번째 Element 리턴
//		element = elements.get(1);
//		System.out.println(element.outerHtml());
		System.out.println();
		System.out.println("[Element들을 다 뽑고 싶은 경우]");
		System.out.println();
//		for (int i = 0; i < elements.size(); i++) {
//			element = elements.get(i);
//			System.out.println(element.outerHtml());
//			System.out.println();
//		}
		// Enhanced for 문으로..
//		for(Element e : elements) {
//			System.out.println(e.outerHtml());
//			System.out.println();
//		}

		element = doc.selectFirst("div#addr"); // doc 에서 찾는 것
//		System.out.println(element.outerHtml());

		elements = element.select("ul.favorite a"); // element에서 찾는 것 리턴타입 elements
		System.out.println(elements.size() + " 개");
		// text랑 link주소 꺼내보기

		for (Element e : elements) {
//			System.out.println(e.outerHtml());
			System.out.println(e.text().trim());
			// 안에 있는 것 꺼집어 나오는게 text() 이고 이를 사용하면서 trim 같이 사용해주자
			System.out.println(e.attr("href").trim());
			// attr("href")

			System.out.println();
			System.out.println("[ImageLink URL 뽑기]");
			for (Element img : doc.select("img")) {
				System.out.println(img.attr("src").trim());
			}

		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
