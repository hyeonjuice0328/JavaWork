package com.mvn.javaproj2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	// 각각의 메소드는 기본적으로 독립적이고 개별적으로 작동하는 것이 원칙이다. 
	// 그래서 메소드 작성 순서대로 실행되지 않는다. 
	
	// 각 테스트 전/후에 공통으로 수행해야 할 코드가 필요하다면
	// @Before 와 @After 를 사용하자 
	
	// JUnit 은 멤버필드 방식을 비추 한다 > 왜냐하면 테스트 결과가 다른 테스트 결과에 영향을 줄 수 있기 때문.
//	private Calculator cal = new Calculator(); >> 비추비추
	
	private Calculator cal;
	 
	@Before	// 테스트 전에 실행할 메소드 만들기
	public void setUp() {
		System.out.println("[테스트 전]");
		cal = new Calculator(); // 인스턴스 실행
	}
	@After // 테스트 진행 후에 실행할 메소드 만들기
	public void shutDown() {
		System.out.println("[테스트 후]");
	}
	
	@Test
	public void testAdd() {
		// add() 가 실행되는지 콘솔에서 확인해보자 
		System.out.println("testAdd()");
		int result = cal.add(10, 20);
		assertEquals(30, result);
	}
	@Test
	public void testASub() {
		// add() 가 실행되는지 콘솔에서 확인해보자 
		System.out.println("testSub()");
		int result = cal.sub(10, 20);
		assertEquals(-10, result);
	}
	@Test
	public void testMul() {
		// add() 가 실행되는지 콘솔에서 확인해보자 
		System.out.println("testMul()");
		int result = cal.mul(10, 20);
		assertEquals(200, result);
	}
	@Test
	public void testDiv() {
		// add() 가 실행되는지 콘솔에서 확인해보자 
		System.out.println("testDiv()");
		int result = cal.div(10, 20);
		assertEquals(0, result);
	}
}
