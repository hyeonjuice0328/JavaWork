package com.lec.java.crawl07;

public class InfoBook {

	private String bookTitle; // 책 제목
	private double price; // 책 가격
	private String url; // 상세 페이지 url
	private String imgUrl; // 썸네일 url

	
	//기본생성자
	public InfoBook() {	}

	//메개변수 받는 생성자
	public InfoBook(String bookTitle, double price, String url, String imgUrl) {
		super();
		this.bookTitle = bookTitle;
		this.price = price;
		this.url = url;
		this.imgUrl = imgUrl;
	}

	//getter&setter
	public String getBookTitle() {return bookTitle;}
	public void setBookTitle(String bookTitle) {this.bookTitle = bookTitle;}
	public double getPricel() {return price;}
	public void setPricel(double pricel) {this.price = pricel;}
	public String getUrl() {return url;}
	public void setUrl(String url) {this.url = url;}
	public String getImgUrl() {return imgUrl;}
	public void setImgUrl(String imgUrl) {this.imgUrl = imgUrl;}
	
	//toString 
	@Override
	public String toString() {
		return bookTitle + ":" + price + "원, URL: " + url + ", img: " + imgUrl;
	}
	
}
