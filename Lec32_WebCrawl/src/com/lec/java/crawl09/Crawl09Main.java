package com.lec.java.crawl09;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl09Main {

	// 연습
	// 네이버 '검색어' 
	// 블로그 
	//   - post title
	//   - post url
	//   - blog title	
	
	public static void main(String[] args) throws IOException {
		System.out.println("Naver 페이징 : Pagination");

		crawlNaverBlog("파이썬", 2);
		
		System.out.println("\n프로그램 종료");
	} //  end main

	public static void crawlNaverBlog(String search, int page) throws IOException {
		
		if(search == null || search.trim().length() == 0 || page < 1) return;
		
		// 목록에서 크롤링 할 내용
		//post title
		//post link url
		//blog title
		
		String url;
		Document doc;
		Response response;
		Elements elements;
		Elements rowElements;
		
		System.out.println(page + " 페이지 입니다.");
		System.out.println("--------------------------------------------------");
		
		url = String.format("https://search.naver.com/search.naver?date_from=&date_option=0&date_to=&dup"
				+ "_remove=1&nso=&post_blogurl=&post_blogurl_without=&query=%s&srchby=all&st=sim&where=post&start=%d",
				URLEncoder.encode(search,"utf-8"),page);
//		System.out.println(url);//확인용
		doc = Jsoup.connect(url).execute().parse();
		
		elements = doc.select("#elThumbnailResultArea li.sh_blog_top");
//		System.out.println(elements.size() + " 개"); //확인용
		
		for(Element e : elements) {
			String postTitle = e.selectFirst("a.sh_blog_title").text().trim();
			String blogTitle = e.selectFirst("span.inline a").text().trim();
			String postUrl = e.selectFirst("a.sh_blog_title").attr("href").trim();
			
			System.out.println(postTitle + " : " + blogTitle + " : " + postUrl);
		}
		
	}
	
} // end class

