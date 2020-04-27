package com.lec.java.exception08;

import java.util.Scanner;

public class Exception08Main {

	static Scanner sc = new Scanner(System.in);
	
	// TODO : AgeInputException 을 throws 하는 메소드 정의
	public static int inputAge() throws AgeInputException {
		System.out.println("나이 입력:");
		int age = sc.nextInt();

		// TODO : AgeInputException 을 throw 하기
		if(age < 0 || age > 100) {
			AgeInputException e = new AgeInputException(age + " 값은 유효하지 않습니다.");
		
			throw e;
		}
		
		return age;
		
	} // end inputAge()
	
	
	public static void main(String[] args) {
		System.out.println("예외 클래스 만들기 2");
		System.out.println();
	
		// TODO
		int i = 0;
		while(true) {
			try {
//			System.out.println("나이 입력 : ");
			int age = inputAge();
			System.out.println("입력한 나이는 : " + age);
			} catch (AgeInputException e) {
				System.out.println(e.getMessage());
				System.out.println("다시 입력하세요.");
				e.printStackTrace();
			}
	
			System.out.println("프로그램 종료...");
			
		}
		
		
	} // end main()

} // end class Exception08Main












