package com.lec.java.variable02;

//자바의 기본 자료형(primitive data type)
//정수 타입: byte(1바이트), short(2바이트), int(4바이트), long(8바이트)
//실수 타입: float(4바이트), double(8바이트)
//문자 타입: char(2바이트)
//논리 타입: boolean
// 순서 외우기 + 용량 외우기 

public class Variable02Main {

	public static void main(String[] args) {
		System.out.println("정수타입 변수들");
		// 1byte - 8bit 256가지 표현 가능 0~256(x) -128~127(o)
		
		System.out.println("byte type : " + Byte.MIN_VALUE 
				+ " ~ " + Byte.MAX_VALUE);
		byte num1 = -128;
		byte num2 = 0;
		byte num3 = 127;
//		byte num4 = 128; -> 에러 : byte 에 저장할 수 있는 크기를 넘었음
//		                 Type mismatch: cannot convert from int to byte.
		
		System.out.println("short type : " + Short.MIN_VALUE + " ~ "
				+ Short.MAX_VALUE);
		short num5 = -12345;
		short num6 = 12345;
//		short num7 = 32768; -> 에러 : short 에 저장할 수 있는 크기를 넘었음
//						Type mismatch: cannot convert from int to short
		
		System.out.println("int type : " + Integer.MIN_VALUE + " ~ "
				+ Integer.MAX_VALUE);
		//integer-32비트
		System.out.println("long type : " + Long.MIN_VALUE + " ~ "
				+ Long.MAX_VALUE);
//		int num9 = 9876543210; 
//				-> 에러 : The literal 9876543210 of type int is out of range 
//		long num10 = 9876543210;
//		        -> 에러 : The literal 9876543210 of type int is out of range 		
		// literal : 코드상에 직접 입력한 값들 
		// 정수 리터럴은 -> int 로 형변환 하려 한다. 정수타입4가지 중 대표 
		// 실수 리터럴은 -> double 로 형변환 하려 한다. 실수타입2가지 중 대표 
		// "~" 리터럴은 -> 문자열(String)으로 형변환 하려한다. 
		
		// long형 리터럴 끝에 L이 없으면 Java는 int로 인식하려 한다. 그러면 에러 생김.
		long num11 = 9876543210L;
		long num12 = 12; //12는 4byte(integer형)
		long num13 = 12L; // 12는 8byte(long형)
		int num14 = 12;
		//int num15 = 12L; //long 타입은 int에 대입 불가 
		
		//값의 경계선 
		byte num15 = Byte.MAX_VALUE; // 127
		byte num16 = (byte)(num15 + 1);
		System.out.println("num16 = " + num16);
		System.out.println("num15 = " + num15);
		//정수타입 4가지 에서만 나오는 현상 Java에서는 값이 순환 한다. 
		
		//정수 표기법 (진법별로 리터럴표기)
		int number1 = 11; //10진수(Decimal)
		int number2 = 0xB; //16진수(Hexadecimal), 0x로 시작
		int number3 = 013; // 8진수(Octal) 0으로 시작 
		int number4 = 0b1011; // 2진수(Binary) 0b로 시작 
		
	    System.out.println("number1 : " + number1);
	    System.out.println("number2 : " + number2);
	    System.out.println("number3 : " + number3);
	    System.out.println("number4 : " + number4);
	    
	    // String.format() 을 사용하여 원하는 포맷(진법)으로 출력가능
	    System.out.println("number1 : " + String.format("%x",number1)); 
	    //number1 을 16진법으로 출력
	    System.out.println("number1 : " + String.format("%o", number1));
	    //number1 을 8진법으로 출력
	    
	    //Integer.toXXX(n) 을 사용하여 원하는 포맷의 문자열로 변환 가능 
	    System.out.println("number1 : " + Integer.toHexString(number1));
	    //number1을 16진수 문자열로 변환
	    System.out.println("number1 : " + Integer.toOctalString(number1));
	    //number1을 8진수 문자열로 변환
	    System.out.println("number1 : " + Integer.toBinaryString(number1));
	    //number1을 2진수 문자열로 변환

	    

	} // end main()

} // end class






