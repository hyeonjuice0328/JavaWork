package com.mvn.javaproj2;

import static org.junit.Assert.*;

import org.junit.Test;


// Junit 으로 테스트 동작을 시키는 경우 메소드는 모두 public 으로.. 

public class AppTest {
	
	private App app = new App();
	
	@Test
	public void test1() {
		// Junit 방식이 아닙니다.
//		if("welcome".equals(app.getWelcome())) {
//			System.out.println(true);
//		} else
//			System.out.println(false);
		
		// assertXXX() 메소드 사용
		assertEquals("welcome", app.getWelcome());
		assertEquals("hello", app.getHello());
		assertEquals("bye", app.getBye());
	}
	
	@Test
	public void test2() {
		
		assertEquals("Bye", app.getBye());
	}
	
	@Test
	public void test3() {
		
		assertEquals("hello", app.getHello());
	}
}
