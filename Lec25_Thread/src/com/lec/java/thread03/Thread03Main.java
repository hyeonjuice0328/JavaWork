package com.lec.java.thread03;

/* 쓰레드와 익명클래스
 */
public class Thread03Main {

	public static void main(String[] args) {
		System.out.println("쓰레드와 익명 클래스");

		// 이미 정의된 MyRunnable 클래스의 인스턴스 사용
		new Thread(new MyRunnable()).start();

		// 익명 클래스를 사용해서 Runnable 인스턴스를 생성
		new Thread(new Runnable() {
		
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("3 X " + i + " = " + (3 * i));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("4 X " + i + " = " + (4 * i));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // main Thread 가 가장 먼저 끝난다. 
		}
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class Thread03Main

class MyRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("2 X " + i + " = " + (2 * i));
			// 하나 출력할 때마다 딜레이
			try {
				Thread.sleep(100); // 0.1초씩 딜레이
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

} // end class MyRunnable
