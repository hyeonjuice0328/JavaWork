package com.lec.java.crawl07;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * '검색어' 입력받아서 
 * 국내도서 카테고리에 첫페이지 20개 item 크롤링
 * 		책이름/책가격/상세페이지 url/썸네일 url
 * 
 * yes24.com 검색페이지는 euc-kr 로 URL 인코딩 되어 있다.
 *     한글 1글자당 2byte로 인코딩
 */

/*
 * '검색어' 입력받아서 
 * 첫페이지의 '국내도서' 첫페이지 20개 아이템 크롤링
 *    책이름 / 책가격 / 상세페이지 url  / 썸네일 url
 *    
 * yes24.com 검색페이지는  euc-kr 로 URL 인코딩 되어 있다.
 *    한글 1글자당 2byte 인코딩   
 *    
 */
public class Crawl07Main {

	private static final String PATH = "books";
	
	public static void main(String[] args) throws IOException {
		System.out.println("인터파크 도서 검색결과 페이지");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색어를 입력하세요: ");
		String search = sc.nextLine(); 
		sc.close();
		
		Crawl07Main app = new Crawl07Main();
		ArrayList<InfoBook> list = app.crawlInterpark(search);
		
		// 썸네일 이미지 다운로드 받아서
		// thumb001.jpg ~ thumb020.jpg ...
		
		int fileIndex = 1;
		for(InfoBook e : list) {
			System.out.println(e);  // 크롤링 정보 출력
			
			// 썸네일 이미지 다운로드
			String fileName = String.format(PATH + File.separator + "thumb%03d.jpg", fileIndex);
			URL imgUrl = new URL(e.getImgUrl());
			
			BufferedImage imgData = ImageIO.read(imgUrl);
			File file = new File(fileName);
			ImageIO.write(imgData, "jpg", file);			
			
			System.out.println(fileName + " 이 저장되었습니다");
			fileIndex++;
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

	
	private ArrayList<InfoBook> crawlInterpark(String search) throws IOException {
		ArrayList<InfoBook> list = new ArrayList<InfoBook>();
		
		String url;
		Document doc;
		Response response;
		Elements elements;
		Elements rowElements;
		
		// TODO
		// http://book.interpark.com/
		// 검색 url : http://bsearch.interpark.com/dsearch/book.jsp?sch=all&sc.shopNo=&bookblockname=s_main&booklinkname=s_main&bid1=search_auto&bid2=product&bid3=000&bid4=001&query=%C0%DA%B9%D9
		
		url = "http://bsearch.interpark.com/dsearch/book.jsp?sch=all&sc.shopNo=&bookblockname=s_main&booklinkname=s_main&bid1=search_auto&bid2=product&bid3=000&bid4=001&query=" + URLEncoder.encode(search, "euc-kr");
		System.out.println(url); // 확인 --> ok
		
		doc = Jsoup.connect(url).execute().parse();
		
		rowElements = doc.select("#bookresult > form");
		
		System.out.println(rowElements.size() + "개");
		
		for(Element e : rowElements) {
	
			Element imginfo = e.selectFirst("div.bookImg > div.imgWrap > div.bimgWrap > a > img");
			String imgUrl = imginfo.attr("src").trim();
			System.out.println(imgUrl);
			
			String bookTitle = e.select("div.info > p.tit > b > a").text().trim();
			String linkUrl = "https://book.interpark.com" + imginfo.attr("href").trim();
			
			System.out.print(bookTitle + " : " + linkUrl);

			double price = Double.parseDouble(
					e.selectFirst("div.price > p.FnowCoupon > span.nowMoney").text().trim().split("원")[0].replace(",",""));
	
			list.add(new InfoBook(bookTitle, 0 , linkUrl, imgUrl));
		}
		
		
		
		
		
		
		
		return list;
	}
	
	
	
} // end class