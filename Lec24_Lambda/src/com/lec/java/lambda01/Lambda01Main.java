package com.lec.java.lambda01;

/* 람다 표현식: lambda-expression
 	Java8 부터 도입:
		(매개변수 리스트) -> 리턴값
		(매개변수 리스트) -> {...}  수행코드

	추상메소드가 하나인 인터페이스 구현, 즉 익명클래스사용 더 간략화한 표현식
 */
public class Lambda01Main {

	public static void main(String[] args) {
		System.out.println("인터페이스, 익명 클래스, 람다 표현식");
		
		System.out.println();
		System.out.println("[1] 인터페이스를 구현하는 클래스");
		Addable myAdder = new AdderImple();
		double result = myAdder.add(1.11, 2.22);
		System.out.println("result : " + result);
		//class 이름 만들기 귀찮은 단점... 		
		System.out.println();
		System.out.println("[2] 익명 클래스 사용");
		//익명클래스 만들기 
		Addable myAddable2 = new Addable() {
			
			@Override//구현할 추상 메소드 
			public double add(double x, double y) {
				return x+y; // add정의
			} 
		};
		result = myAddable2.add(1.11, 2.22);
		System.out.println("result : " + result);
		
		System.out.println();
		System.out.println("[3] 람다 표현식(lambda expression) 사용");
		//추상메소드를 표현하고 정의한것 람다 표현식 , 추상메소드에 있는 매개변수의 갯수만 중요하다. 
		//추상메소드가 리턴하는 값이나 수행구문을 -> 의 오른편에 구현해주면 된다! 
		Addable myAdder3 = (x , y) -> x + y;
		result = myAdder3.add(1.11, 2.22);
		System.out.println("result : " + result);
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
} // end class

//인터페이스 정의
interface Addable {
	public abstract double add(double x, double y);
	//두개의 더블타입을 받아서 무언가를 실행하고 double 타입 으로 리턴
}

//인터페이스를 구현하는 클래스를 정의
class AdderImple implements Addable {
	@Override // 추상 메소드 만들기 
	public double add(double x, double y) {
		return x + y; // x+y를 리턴시키도록 한다. 
	}
}











