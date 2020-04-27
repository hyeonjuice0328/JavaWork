package com.lec.java.inner01;

/*
 Inner Class(내부 클래스)
 1. Member inner class(멤버 내부 클래스): 다른 클래스 내부에서 선언된 클래스
 2. Static inner class(static 내부 클래스): 다른 클래스의 내부에서 static으로 선언된 클래스
 3. Local class(지역 클래스)
   1) Local inner class(지역 내부 클래스): 메소드 내부에서 선언된 클래스
   2) Anonymous inner class(익명 내부 클래스): 이름이 없는 local class
*/

public class Inner01Main {

	public static void main(String[] args) {
		System.out.println("Member Inner Class(멤버 내부 클래스)");

		//외부 클래스의 인스턴스 생성
		TestOuter out = new TestOuter(100);
		
		// 멤버 내부 클래스의 인스턴스 생성
		// 멤버 내부 클래스의 이름: [외부클래스 이름].[멤버 내부클래스 이름]
		// [외부클래스 이름].[내부클래스 이름] 참조변수 =
		//      [외부클래스 인스턴스].new 내부클래스 생성자();

		//Innerclass이름 만들기 타입:TestOuter.TestInner
		TestOuter.TestInner in = out.new TestInner(111);
		in.printOuterValue();
		in.printInnerValue();
		
		System.out.println();
		//하나의 외부 클래스 인스턴스를 이용하여 
		//멤버 내부 클래스의 인스턴스는 여러개 생성이 가능하다. 
		TestOuter.TestInner in2 = out.new TestInner(123);
		in2.printOuterValue();
		in2.printInnerValue();
		
		//새로운 외부 클래스 인스턴스 생성 
		TestOuter out2 = new TestOuter(1000);
		//out2 외부 클래스 인스턴스 생성
		TestOuter.TestInner in4 = out2.new TestInner(12);
		TestOuter.TestInner in5 = out2.new TestInner(13);
		//out2로부터 in4, in5라는 이름으로 내부클래스 객체 만드세요.
		System.out.println("내부클래스 객체 in4");
		in4.printInnerValue();
		in4.printOuterValue();
		System.out.println();
		System.out.println("내부클래스 객체 in5");
		in5.printInnerValue();
		in5.printOuterValue();
		
		System.out.println();
		//
		TestOuter.TestInner in7 = new TestOuter(30).new TestInner(330);
		in7.printInnerValue();
		in7.printOuterValue();
		
		
		
	} // end main()

} // end class Inner01Main

