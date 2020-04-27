package com.lec.java.if04;

/*  삼항 연산자 (ternary operator)
 * 	 (조건식) ? 선택1 : 선택2
 * 	 (조건식)이 true 이면 선택1이 선택되고,
 *   (조건식)이 false 이면 선택2가 선택됨.
 */
public class If04Main {

	public static void main(String[] args) {
		System.out.println("if 문과 삼항 연산자");
		
		//두 숫자 중 더 큰 숫자 구분하기 
		int num1 = 100;
		int num2 = 123;
		int big;
		//기존의 if~else문 사용방식 
/*		if(num1 > num2) {
			big = num1;
		} else {
			big = num2;
		} 
		System.out.println("더 큰수: " + big);
*/
		//삼항연산자 
		//코드가 간단한 것들은 조건문 보다는 삼항연산자로 해결한다. 
		big = num1 > num2 ? num1 : num2;
		System.out.println("더 큰수: " + big);
		
		System.out.println();
		//삼항연산자 응용
		//두 수의 차(difference) 차이값은 항상 양수 
		int num3 = 10;
		int num4 = 20;
		int diff; // 차이값을 담을 변수 
		/*
		if(num3 > num4) {
			diff = num3 - num4;
		} else {
			diff = num4 - num3;
		}
		System.out.println("두 수의 차: " +  diff);
		*/
		diff = (num3>num4) ? (num3-num4) : (num4-num3);
		
		System.out.println("두 수의 차: " +  diff);
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class










