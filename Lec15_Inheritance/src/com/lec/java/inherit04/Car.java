package com.lec.java.inherit04;

public class Car extends Vehicle {

	int oil;
	
	//생성자1
	public Car() {
		// 부모클래스의 기본!!생성자 호출 ---> Vehicle()
		// super 생성자가 없으면 부모의 기본생성자(default)를 호출하게 동작한다. 
		System.out.println("Car() 생성");
		
	}
	//생성자2
	public Car(int oil) {
		//super()는 반드시 생성자 코드의 "첫번째" 문장에 위치하도록 해야한다. 
		super(); // 부모의 기본생성자를 호출하세요. 
		this.oil = oil;
		System.out.println("Car(int) 생성 : oil = " + oil);
	}
	//생성자3
	public Car(int speed, int oil) {
		//speed와 oil을 초기화 할 것이다. 
		super(speed); // super(int) < --- 부모 생성자 호출 
		this.oil = oil;
		System.out.println("Car(int, int) 생성 : speed = " + speed 
				+ " oil = " + oil);
	}
	
	public Car(double value) {
		// this 와 super 는 양립할 수 없다. 
		this(555, (int)value); //자기 생성자 호출  - 생성자 위임
		System.out.println("Car(double) 생성 : value = " + value);
	}
}
