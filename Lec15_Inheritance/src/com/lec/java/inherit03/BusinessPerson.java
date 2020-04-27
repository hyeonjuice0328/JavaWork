package com.lec.java.inherit03;

//자바는 하나의 부모에게만 상속받을 수 있다. 단일 상속! 
//c++ 은 다중상속!! 

public class BusinessPerson extends Person {
	
	String company;
	
	public void showInfo() {
		whoAmI(); // 호출
		System.out.println("회사는 " + company + " 입니다.");
	}
	
}
