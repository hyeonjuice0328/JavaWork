package com.lec.java.oop04;
/*
 클래스: 멤버 변수 (+ 생성자) + 메소드 => 데이터 타입
 추상 클래스(abstract class): 
    추상 메소드를 가지고 있는 클래스
    클래스 선언할 때 abstract 키워드를 반드시 써 줘야 함
    추상 클래스는 인스턴스를 생성할 수 없다. (new 불가능)
 
 추상 메소드(abstract method):
   원형(prototype)만 선언돼 있고, 메소드 본체가 정의되지 않은 메소드
   메소드 본체가 없기 때문에 {}부분이 없다.
   메소드 원형 끝에 ;으로 끝냄.
   메소드 이름 앞에 abstract 키워드를 반드시 써 줘야 함

 추상 클래스를 사용하는 목적은
   추상 클래스를 상속 받는 자식 클래스에 반드시 구현해야 할 메소드가 있을 경우,
   그 메소드를 추상메소드로 만들어서 반드시 override하도록 하는데 목적이 있다.
*/

public class Abstract01Main {

	public static void main(String[] args) {
		System.out.println("추상 클래스(abstract class)");
		
		// 추상클래스는 인스턴스 생성 불가 ! 
//		TestAbstract test1 = new TestAbstract(); ---> 에러 추상 클래스는 new 할 수 없음

		TestClass test2 = new TestClass();
		test2.test = 100;
		test2.testMethod();
		
		//다형성
		TestAbstract test3 = new TestClass(); // TestAbstract() 가 TestClass의 부모 타입 
		test3.testMethod();
		
		System.out.println("\n 프로그램 종료");
	} // end main()

} // end class

abstract class TestAbstract { //추상 메소드를 하나라도 가지고 있는 클래스는 무조건 추상클래스 여야 한다. 인스턴스 못만든다. 
	int test;
	
	public int getTest() {return this.test;}
	
	//추상 메소드 - 본체가 없는 메소드 
	public abstract int testMethod();
}

class TestClass extends TestAbstract{

	@Override
	public int testMethod() { //부모쪽에 있던 추상메소드를 상속 받아서 자식클래스에서 구현해야한다. 
							  //즉, 추상 메소드의 본체( { ... } ) 를 만들어 주어야 한다. 
		return 0;
	}
}
//추상 메소드 
abstract class TestClass2 extends TestAbstract {
	int number; // 만약 자기자신도 부모가 가지고 있었던 추상메소드를 구현하기 싫으면 그대로 추상메소드로 남으면 된다. 
}
 
