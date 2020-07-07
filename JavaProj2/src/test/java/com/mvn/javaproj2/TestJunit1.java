package com.mvn.javaproj2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
/*
	1 void assertEquals(boolean expected, boolean actual)
	2 void assertFalse(boolean condition)    // false 인지 체크
	3 void assertNotNull(Object object)   // Object 가 null 이 아닌지 체크
	4 void assertNull(Object object)   // Object 가 null 인지 체크
	5 void assertTrue(boolean condition)  // true 인지 체크
	6 void fail()   // 무조건 fail
*/


public class TestJunit1 {

	@Test
	public void test() {
		int num = 5;
		String temp = null;
		String str = "안녕하세요";
		
		assertEquals("안녕하세요", str);
		assertFalse(num > 6);
		
//		assertNotNull(temp); // notnull 이면 통과
		assertNull(temp);
		
		System.out.println(12.3 / 4.1);
		
//		assertEquals(3.0, 12.3 / 4.1); //  FAIL
		// 실수에서는 오차 범위가 있기 때문에 어느 정도의 오차에서는 pass 하겠다 아니다 (델타값)
									// 3번째 값은 델타값
		assertEquals(3.0, 12.3 / 4.1, 0.00001); // PASS
		
	}

}
