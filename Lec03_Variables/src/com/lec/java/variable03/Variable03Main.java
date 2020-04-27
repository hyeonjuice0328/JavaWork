package com.lec.java.variable03;

//실수형 자료 타입: float(4바이트), double(8바이트)
//정수형 자료 타입의 기본형은 int
//실수형 자료 타입의 기본형은 double

public class Variable03Main {

	public static void main(String[] args) {
		System.out.println("변수 - 실수타입");                 

		//초기화: 변수에 값을 최초로 대입하는 것 
		double number1 = 3.141592;
		//float number2 = 3.14; 기본적으로 실수 리터럴은 double로 인식
		//float <- double 대입 불가
		
		//float 리터럴
		float number3 = 3.14f;
		
		// 실수 타입 최소, 최대값 (적절한 선에서 타협한다. 정확한 값을 기대할 수 없다.) 
		System.out.println("float : " +  Float.MIN_VALUE +
				" ~ " + Float.MAX_VALUE);
		//지수 표기법으로 나온다. 
		//결과값: 1.4E-45 (=> 1.4*10에-45승) ~ 3.4028235E38 (=> 3.4028235*10에38승)
		System.out.println("double : " +  Double.MIN_VALUE +
				" ~ " + Double.MAX_VALUE);
		
		float number4 = 1.23456789f;
		double number5 = 1.23456789;
		System.out.println("number4 : " + number4); //결과값: 1.2345679
		System.out.println("number5 : " + number5); //결과값: 1.23456789
		//float와 double은 저장할 수 있는 값의 크기만이 아니라 소수점 이하 정밀도(precision)의 차이가 있다. 
		//float는 소수점 6개까지 double은 소수점 13개 까지 정확하다고 볼 수 있다. 
		
		//실수 표기법
		double number6 = 123; //정수타입int가 double으로 변환 된다. 123->123.0 
		double number7 = 1.23e2; // 지수 표기법(exponential notation) 
		System.out.println("number6 : " + number6);
		System.out.println("number7 : " + number7);
		
		double number8 = 0.0001213;
		double number9 = 1.213E-4;
		System.out.println("number8 : " + number8);
		System.out.println("number9 : " + number9);
		
		
		
		
	}

}
