package com.lec.java.inherit03;

/* java.lang.Object
 * 	자바의 모든 클래스는 명시를 따로 하지 않아도 java.lang.Object로부터 상속 받는다.
 *  java.lang.Object 클래스는 모든 클래스의 부모클래스이다.
 *  Object 클래스에 있는 메소드를 다른 클래스에서도 사용 가능
 */
public class Inherit03Main {

	public static void main(String[] args) {
		System.out.println("상속 연습");
		System.out.println("java.lang.Object");
		
		System.out.println();
		Person p1 = new Person();
		p1.name = "김자바";
		p1.whoAmI();
	
		
		System.out.println();
		BusinessPerson b1 = new BusinessPerson();
		b1.name = "박자바";
		b1.company = "이클립스";
		b1.showInfo();
		
		System.out.println();
		System.out.println(b1);
//				(= 결과가 같다)
		System.out.println(b1.toString());
		
		
		System.out.println("\n프로그램 종료");
	} // end main()
} // end class









