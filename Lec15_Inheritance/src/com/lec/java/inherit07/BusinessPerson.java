package com.lec.java.inherit07;

public class BusinessPerson extends Person {
	
	private String company;

	//getter setter
	public String getCompany() {return company;}
	public void setCompany(String company) {this.company = company;}
	
	@Override //annotation : 애노테이션
	public void showInfo() {
		super.showInfo();
		System.out.println("회사: " + company);
	}
	
//	@Override
//	public void whoAreYou() {
//		// TODO Auto-generated method stub
//		super.whoAreYou();
//	}
	
	@Override // toString 은 이 객체를 문자열로 표현하고싶을 때 사용 
	// private 이라 접근이 안되는 것들을 접급하기 위해 getter&setter 사용
	public String toString() {
		return "BusinessPerson: " + getName() + " " + company;
	}
	
	
	
	
	//메소드 재정의 Overriding
//	public void showInfo() { //부모와 시그니처가 똑같다! 
//		super.showInfo(); // 부모클래스에 일부분은 사용하겠습니다. 
//		System.out.println("회사: " + company);
//	}
	

}
