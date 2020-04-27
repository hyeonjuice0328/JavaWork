package com.lec.java.wrapper01;

/* Wrapper 클래스: 기본 자료형(primitive type)의 데이터를 감싸는 클래스
 * 기본 자료형: boolean, char, byte, short, int, long, float, double
 * Wrapper: Boolean, Character, Byte, Short, Integer, Long, Float, Double
 * 
 * Wrapper 클래스는 immutable 하다! --> 불변의 ! 변하지 않는! 값이 변하지 않는다! 
 */

public class Wrapper01Main {

	public static void main(String[] args) {
		System.out.println("Wrapper 클래스");
		System.out.println("wrapper 클래스에 값을 저장하는 방법");
		System.out.println();

		Integer i1 = 100; // reference <= primitive ????
		i1 = i1 + 200;    // reference 에 산술연산
		System.out.println("i1 = " + i1); // 결과값 : 300
		// Wrapper 클래스는 마치 primitive 타입처럼 동작한다.
		System.out.println();
		
		/*Wrapper class 생성 방법 */
		
		// 1. 생성자 이용
		Integer num1 = new Integer(123);
		System.out.println("[1] new 사용");
		System.out.println("num1 = " + num1);
		
		// 2. wrapper 클래스의 static 메소드인 valueOf() 메소드를 사용
		System.out.println("[2] valueOf() 사용");
		Integer num2 = Integer.valueOf(123);
		System.out.println("num2 = " + num2);
		 
		//산술연산은 가능한데 == 할수 없고 equals() 는 또 사용이 가능하다...????
		if(num1 == num2) {
			System.out.println("== 같다");
		} else {
			System.out.println("== 다르다"); // 다르다! 
		}
		
		if(num1.equals(num2)) {
			System.out.println("equals() 같다"); // 같다
		} else {
			System.out.println("equals() 다르다");
		}
		
		
		// 3. new Integer() VS Integer.valueOf()
		Integer num3 = new Integer(123);	 // new는 새로운 인스턴스 생성
		Integer num4 = Integer.valueOf(123); // 
		// valueOf()는 생성한 Object를 cache 해둔다. 
		// 동일 literal 로 valueOf() 생성하면 , 기존의 생성된 Object 를 리턴한다! 메모리 절약을 위해!!  
		
		
		
		// new로 생성한 것들의 비교
		if(num1 == num3) {
			System.out.println("생성자 같은 참조");
		} else {
			System.out.println("생성자 다른 참조");
		}
		
		//valueOf() 로 생성한 것들의 비교
		if(num2 == num4) {
			System.out.println("생성자 같은 참조");
		} else {
			System.out.println("생성자 다른 참조");
		}
		
		// 4. literal 상수로 생성
		System.out.println();
		Integer num5 = 123;
		// Integer.valuOf(123)과 동일한 코드가 동작됨! (Auto-Boxing)
		if(num4 == num5) {
			System.out.println("Integer.valuOf() 동일");
		}else {
			System.out.println("Integer.valuOf() 다른");
		}
		
		// 5. valueOf(문자열) 가능!
		Integer num6 = Integer.valueOf("123");
		// "123" >> Integer로 바뀐 후 valueof 실행
		System.out.println(num6);
		
		if(num6 == num5) {
			System.out.println("같은참조"); // 같다 !! 
		} else {
			System.out.println("다른참조"); 
		}
		
		// 6. 산술 연산 가능
		num6 *= 2;  //새로운 Wrapper 생김 (Wrapper class == immutable) 
		System.out.println(num6);

		if(num6 == num5) {
			System.out.println("같은참조");
		} else {
			System.out.println("다른참조"); // 다르다!!
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
















