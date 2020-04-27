package com.lec.java.dowhile;

/*
	do {
		...
		...
	}while(조건식) 문인 경우에는,
	
	일단은 {...} 안에 있는 실행문들을 곧바로 한번은 실행을 하고 나서
	조건식을 검사하게 된다. 그리고 조건식이 true 이면 다시 실행 false 면 빠져나간다. 

*/

public class While04Main {

	public static void main(String[] args) {
		System.out.println("do~while문 연습");
		
		int n = 0;
		while(n > 0) {
			System.out.println("카운트다운: " + n);
			n--;
		} //한번도 실행이 되지 않는다.  
		
		System.out.println("-----------------------");
		n = 0;
		do {
			System.out.println("카운트다운: " + n);
			n--;
		} while(n > 0); //한번은 무조건 실행이 되기 때문에 한번 실행된다. 
		
		// 구구단 9단을 do ~ while로 출력
		
		n = 1;
		do {
			System.out.println("9 X " + n + " = " + (9 * n));
			n++;
		} while(n <= 9);
		
		
	} // end main()

} // end class While04Main









