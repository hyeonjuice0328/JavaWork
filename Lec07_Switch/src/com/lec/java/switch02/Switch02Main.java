package com.lec.java.switch02;

public class Switch02Main {

	public static void main(String[] args) {
		System.out.println("switch 연습");

		// 도전
		// switch ~ case 조건문을 사용해서
		// 짝수 이면 --> "짝수입니다"  출력
		// 홀수 이면 --> "홀수입니다"  출력
		
		int num = 99;
		
		/* 내가 먼저 실습한 부분 
		switch(num) {
		case 1:
			System.out.println("짝수입니다.");
			break;
		case 2:
			System.out.println("홀수입니다.");
			break;
		}
		*/
		//switch( ) 안에 들어갈 수 있는 것은 int값 또는 int로 자동형변환 되는 것들(byte, short, char)만 가능 
		switch(num%2) {
		case 0:
			System.out.println("짝수입니다.");
			break;
		case 1:
			System.out.println("홀수입니다.");
			break;
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









