package com.lec.java.access02;

public class Test02 {

	private int privateNum; // 자기자신
	int defaultNum; // 자기자신과 같은 패키지에 있는 클래스에서도 사용가능
	protected int protectedNum; // 자기자신 같은 클래스 상속받은 클래스
	public int publicNum; // 어디서나 사용 가능 
	
	private void privateMethod() {}
	void defualtMethod() {}
	protected void protectedMethod() {}
	public void publicMethod() {}
	
	
}
