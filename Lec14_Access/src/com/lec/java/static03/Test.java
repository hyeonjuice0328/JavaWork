package com.lec.java.static03;

public class Test {
	private int num;

	static int count = 0;
	// Singleton 패턴
	//기본생성자
	private Test() {
		count++;
		System.out.println(count + "번째 인스턴스 생성");
	}

	private static Test instance = null;
	//static 이고 자기자신 타입 변수
	public static Test getInstance() {
		if(instance == null) {
			instance = new Test(); //인스턴스 생성 
		}
		return instance;
	}
	
	
	//getter setter
	public int getNum() {return num;}

	public void setNum(int num) {this.num = num;}
	
	
}
