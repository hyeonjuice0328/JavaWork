package com.lec.java.array01;

/* 배열(Array)
 		동일 타입의 여러개의 데이터를 담는 집합자료형
 	
 	배열 선언
 		자료타입[] 변수이름; // ex. int[] arr;
 		
 	배열 원소 (element)
 		배열에 담긴 각각의 데이터
 		
 	배열의 길이 (length)
 		배열 원소의 개수, 즉 배열에 담긴 데이터의 개수 
 		
 	배열 인덱스 (첨자, index)
 		배열의 인덱스는 0부터 시작해서, (배열의 길이 - 1)까지가 됨
 		배열인덱스를 사용하여 배열원소에 접근하여 사용
 	
 	배열을 new로 생성한뒤에는 자동초기화 가 됨.
		숫자타입들은 --> 0으로
		boolean타입은 --> false 로
		객체타입(Object) 타입은 --> null 로.
 	
 	★ 배열변수의 타입, 배열원소의 타입 확실히 구분하자
 	★ JVM 메모리 상에 생기는 구조 이해 필수 
 */
public class Array01Main {

	public static void main(String[] args) {
		System.out.println("배열(Array)");

		int korean1 = 99;
		int korean2 = 88;
		int korean3 = 77;
		// ...
		// 다량의 데이터를 위해서 매번 변수 작성하는건 불가능..

		// 배열의 선언과 초기화
		int[] korean = new int[3];
		// integer 형의 배열 korean 선언 = 초기화;
		// 3개의 int 데이터를 담는 배열로 초기화

		korean[0] = 90; // 90이라는 수를 korean이라는 첫번째!!배열원소에 넣겠습니다.
		// [0] < 인덱스 시작은 0부터
		korean[1] = 80;
		korean[2] = 70;

		System.out.println("국어0 :" + korean[0]);
		System.out.println("국어1 :" + korean[1]);
		System.out.println("국어2 :" + korean[2]);

//		korean[3] = 60; 에러 발생 : ArrayIndexOutOfBoundsException

		// korean타입은 ? --- int[]타입(인티저형배열타입)
		// korean[0]안에 있는 원소의 타입은? --- int 타입

		System.out.println();
		System.out.println("for문 사용하여 배열 출력");
		for (int n = 0; n < 3; n++) {
			System.out.println("korean[" + n + "] = " + korean[n]);
		}
		System.out.println();
		// int 타입 english 라는 이름의 5개 데이터를 담는 배열 선언 및 초기화
		int[] english = new int[5];
		// 에러 아님 ! .. 결과 0 new로 생성하면 자동초기화
		System.out.println(english[1]);

		for (int i = 0; i < english.length; i++) {
			english[i] = i * 10;
		}

		for (int i = 0; i < english.length; i++) {
			System.out.println("영어" + i + ":" + english[i]);
		}

	} // end main()

} // end class Array01Main
