package com.lec.java.lambda03;

/*
	 세가지 방법으로 자유자재로 구현할수 있어야 합니다.
	 방법 1) 클래스 implements 인터페이스 + 오버라이딩.
	 방법 2) 익명클래스
	 방법 3) 람다 표현식 lambda expression
*/
public class Lambda03Main {

	public static void main(String[] args) {
		System.out.println("익명 클래스, 람다 표현식 연습");
		
//		 방법 1) 클래스 implements 인터페이스 + 오버라이딩.
		//덧셈연산
		Addarable myadd = new Addarable();
		double result = myadd.operate(1.1, 2);
		System.out.println("result : " + result);
		
//		 방법 2) 익명클래스
		//뺼셈연산
		Operable oper = new Operable() {
			
			@Override
			public double operate(double x, double y) {
				return x - y;
			}
		};
		System.out.println("result : " + (oper.operate(2.1, 1)));
		
//		 방법 3) 람다 표현식 lambda expression
		//제곱연산
		Operable lambda = (x , y) ->  Math.pow(x, y);
		System.out.println("result : " + lambda.operate(3, 4));
		
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
} // end class

//public은 항상 자기 파일명과 동일해야한다.
interface Operable {
	public abstract double operate(double x, double y);
}

class Addarable implements Operable{

	@Override
	public double operate(double x, double y) {
		return x + y;
	}
	
}