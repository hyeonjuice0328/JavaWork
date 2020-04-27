package com.lec.java.thread01;

/*	쓰레드 Thread
 *  동일 프로세스 내에 '독립'적인 다중 수행하는 프로그램 단위
 *  병행성 증진(동시진행). 처리율 향상, 응답속도 향상 목적
 * 
 *  자바에서 쓰레드를 만들어서 사용하는 방법1:
 *   1. Thread 클래스를 상속받는 클래스를 정의
 *   2. 정의한 클래스에서 run() 메소드를 override - 쓰레드에서 할 일을 구현
 *   3. Thread 클래스의 인스턴스를 생성
 *   4. 생성된 인스턴스에서 start() 메소드를 호출
 */

public class Thread01Main {

	public static void main(String[] args) {
		System.out.println("쓰레드 생성 1");
		
		// 3. Thread 클래스의 인스턴스를 생성
		Thread th1 = new MyThread("Hello Java");
		Thread th2 = new MyThread("안녕하세요");

		// 4. 생성된 인스턴스에서 start() 메소드로 run()을 호출
		th1.start();
		th2.start();
		// Thread 클래스의 start() 메소드를 호출하면,
		// 내부적으로 run() 메소드가 호출됨
		// start() 메소드가 호출되어야 OS에 의해서 쓰레드로 동작을 하게 됨, JVM (X)
		
		// run() 메소드를 직접 호출하는 경우는 쓰레드로 동작하는 것이 아니라,
		// 단순히 run() 메소드만 실행이 되는 것임.
		
		// 이때 발생하는 호출스택 관계도는 '자바의 정석' p626 그림 참조.   p628,629 예제
		
		System.out.println("=======================");
		System.out.println("여기는 언제 출력될까요?");
		System.out.println("=======================");
		
		
		// 하나의 쓰레드는 start() 가 딱 한번만 호출될수 있다.
		// 만약 아래와 같이 다시 start() 하면 IllegalThreadStateException 발생
//		th1.start();
		
		// 아래와 같이 새로 생성해서 사용하면 가능
		th1 = new MyThread("JAVA JAVA");
		th1.start();
	
	} // end main()

} // end class


// 1. Thread 클래스를 상속받는 클래스를 정의
class MyThread extends Thread{

	private String msg;
	private int count;
	
//	기본생성자 생성
	public MyThread() {}
	public MyThread(String msg) {
		this.msg = msg;
		this.count = count; 
	}
	
	// 2. 정의한 클래스에서 run() 메소드를 override
	// 쓰레드에서 할 일을 구현
	@Override // run() 은 Thread 에 있던 메소드 
	public void run() {
		for (int i = 0; i < 100; i++) { //새로 생길 쓰레드에서 할 일을 구현
			System.out.println(getName() + " " + count + " : " + msg);
			count++; //getName() 은 Thread 에 있던 메소드 
		}
		super.run();
	}
	
} // end class MyThread

