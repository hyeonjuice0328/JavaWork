package com.lec.java.for04;

public class For04Main {

	public static void main(String[] args) {
		System.out.println("for문 연습");
		// 1 ~ 100 수 중에서 2와7의 공배수 출력
		//2와 7의 공배수 : 2의 배수 && 7의 배수 
		
		for(int i = 1; i <= 100; i++) {
			if(i % 2 == 0 && i % 7 == 0) {
				System.out.println(i);
			}
		}
		
		//1~10까지의 합을 계산
		System.out.println("1부터 10까지의 합");
		int sum = 0; //합계를 저장할 변수 
		for(int i = 1; i <= 10; i++) {
			sum += i; //누적합산
		}
		System.out.println("합산 : " + sum);
		
		
		
	} // end main ()

} // end class For04Main










