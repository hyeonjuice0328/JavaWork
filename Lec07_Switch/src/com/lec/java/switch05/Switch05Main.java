package com.lec.java.switch05;

public class Switch05Main {

	// enum 타입 정의하는 방법:
	// enum 이름 {}
	// enum 타입 정의 메소드 안에서는 할 수 없다.
	// enumeration - 나열하다 라는 뜻을 가지고 있다. 
	
	//main 바깥쪽
	//Days라는 enum 타입 선언
	enum Days {SUN, MON, TUE, WED, THU, FRI, SAT}
	

	public static void main(String[] args) {
		System.out.println("enum 타입을 switch에서 사용하기");
		
		Days day1; //Days라는 타입의 변수 day1안에 들어가는 값은 위에 선언한 값들 중에 선택이 가능하다.
		day1 = Days.THU;
		Days day2 = Days.MON;
		
		switch(day1) {
		case SUN : 
			System.out.println("일요일입니다.");
			break;
		case MON : 
			System.out.println("월요일입니다.");
			break;
		case TUE : 
			System.out.println("화요일입니다.");
			break;
		case WED : 
			System.out.println("수요일입니다.");
			break;
		case THU : 
			System.out.println("목요일입니다.");
			break;
		case FRI : 
			System.out.println("금요일입니다.");
			break;
		case SAT : 
			System.out.println("토요일입니다.");
			break;
		}
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class










