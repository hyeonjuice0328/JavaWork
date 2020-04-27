package com.lec.java.exception07;

// 우리가 만드는 예외 클래스
// Exception 또는 RuntimeException 클래스를 상속 받아서 만듬

// TODO : Exception 을 상속받아 예외 클래스 정의하기
public class ScoreException extends Exception {

	// 생성자
	public ScoreException() {
		super("점수 입력 오류"); // Exception class 상속
//		(Exception class중에 메세지는 받는 생성자가 존재해서 "점수입력오류" 기입해도 에러 안난다. 
//		Exception(String message) 생성자 호출
	}
	
	public ScoreException(String msg) {
		super(msg);
	}
	
} // end class ScoreException




