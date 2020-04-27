package com.lec.java.static01;

import java.util.Scanner;

// 클래스에 선언된 멤버 변수/멤버 메소드는
// static 여부에 따라 아래와 같이 불려진다

// 인스턴스 변수: 
//   static 이 안붙은 변수
//   인스턴스를 생성한 다음에(new 생성자(); 호출된 다음에)
//   사용할 수 있는 변수
// 인스턴스 메소드:
//   static 이 안 붙은 메소드
//   인스턴스를 생성한 다음에(new 생성자(); 호출된 다음에)
//   사용할 수 있는 메소드

// 클래스 변수(static 변수):
//   클래스의 멤버 변수들 중에서,
//   인스턴스를 생성하지 않아도 사용할 수 있는 변수
// 클래스 메소드(static 메소드):
//   인스턴스를 생성하지 않아도 사용할 수 있는 메소드


public class Static01Main {

	public static void test() {
		System.out.println("Hello static!");
	}
	
	public void test2() {
		System.out.println("Hello non-static!");
	}
	
	public static void main(String[] args) {
		System.out.println("인스턴스 변수/메소드 vs 클래스 변수/메소드");
		
		test();
		//호출하고 있는 건 main > main은 static 이다 > static은 static이 아닌 것을 사용할 수 없다.★★
		//test2();  에러 메세지 : Cannot make a static reference to the non-static method 
		
		//인스턴스 생성 이후에는 사용 가능 
		Static01Main tc = new Static01Main(); //인스턴스 tc
	
		tc.test2(); // 만들어진 인스턴스 tc 를 이용해서 사용가능 
		
	} // end main()

} // end class Static01Main











