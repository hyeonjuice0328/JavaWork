package com.lec.java.operator07;

/* 게으른 계산(Lazy Evaluation)
 * SCE: Short-Circuit Evaluation
 *
 * A && B를 계산할 때
 *	A가 거짓이면, B의 결과에 상관 없이 결과가 항상 거짓이 되기 때문에
 *	B는 연산이 이루어지지 않는다.
 *
 * A || B를 계산할 때
 * 	A가 참이면, B의 결과에 상관 없이 결과가 항상 참이 되기 때문에
 * 	B는 연산이 이루어지지 않는다.
 */
public class Operator07Main {

	public static void main(String[] args) {
		System.out.println("게으른 계산(Lazy Evaluation)");
		System.out.println("SCE: Short-Circuit Evaluation");
		
		int num1 = 0, num2 = 0;
		boolean b;
		
		b = ( (num1 += 10) < 0 ) && ( (num2 += 10) > 0 );
		// &&에서 왼쪽부분부터 실행되고 왼쪽 부분이 이미 false이기 때문에 오른쪽은 계산하지 않는다. 
		System.out.println("b : " + b);
		System.out.println("num1 : " + num1); // > num1 : 10
		System.out.println("num2 : " + num2); // > num2 : 0 
	
		//실무에서는 위와 같은 코드는 작성하지 말자 ! 
		//이렇게 확실하게 작정하자! 
		num1 += 10;
		num2 += 10;
		b = (num1 < 0) && (num1 > 0); 
		

		System.out.println("\n 프로그램 종료");
	} // end main ()

} // end class



