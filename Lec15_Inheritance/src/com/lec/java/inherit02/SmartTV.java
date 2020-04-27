package com.lec.java.inherit02;

// BasicTv로부터 상속받은 SmartTV입니다.
public class SmartTV extends BasicTV {
	String ip;
	
	public void displayInfo() {
		super.displayInfo();
		System.out.println("IP: " + ip);
	}

}
