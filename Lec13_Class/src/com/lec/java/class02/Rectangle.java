package com.lec.java.class02;

public class Rectangle {
	// 상태 (속성) - 멤버변수
	// 가로, 세로
	double width;
	double height;
	// 생성자
	// 1. default 생성자
	public Rectangle() {
		System.out.println("Rectangle() 생성");
		width = 100;
		height = 100; //디폴트 값 지정 가능 
		System.out.println("가로 : " + width);
		System.out.println("세로 : " + height);
	}
	// 2. 매개변수 가진 생성자
	public Rectangle(double w, double h) {
		System.out.println("Rectangle(w,h)생성");
		width = w;
		height = h;
		System.out.println("가로 : " + width);
		System.out.println("세로 : " + height);
	}
	// 기능 (동작) - 멤버메소드
	public double calcPerimeter() {
		return (width + height) * 2 ;
	}
	public double calcArea() {
		return width * height;
	}
	
}
