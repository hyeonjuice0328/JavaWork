package com.lec.java.constant;

/*
 * 상수 : final
 * 변수 선언 앞에 final 키워드를 사용하면
 * '상수 (constant)' 가 되어.
 * 한번 값을 대입하면 변경할수 없게 된다.
 * 
 * 관례적으로 상수값을 담는 상수명은 대문자로 작성
 */

public class ConstantMain {

	public static void main(String[] args) {
		int myage = 35;
		myage = 40;
		myage = 23;
		
		final int MYAGE = 24;
//		MYAGE = 21; -> The final local variable MYAGE cannot be assigned. It must be blank and not using a compound assignment

		final short GRADE;
		GRADE = 100; // 초기화
		
	}

}
