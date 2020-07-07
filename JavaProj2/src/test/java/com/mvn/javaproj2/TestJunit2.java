package com.mvn.javaproj2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;
						// TestCase 상속 : countTestCases 테스트 번수 / get,setName 테스트 이름
public class TestJunit2 extends TestCase{
	
	@Before
	public void before() {
		System.out.println("[before()]");
	}
	
	@After 
	public void after() {
		System.out.println("[after()]");
	}
	
	// static : 인스턴스 생성 전에 무엇인가 실행하겠다....
	@BeforeClass
	public static void beforeClass() {
		System.out.println("<<beforeClaee()>>");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("<<afterClaee()>>");
	}

	@Test
	public void testA() {
		System.out.println("textA()");
		System.out.println("No. of Test Case = " + this.countTestCases());
		setName("A테스트 입니다.");
		System.out.println("Test Case Name = " + this.getName());
	}
	@Test
	public void testB() {
		System.out.println("textB()");
		System.out.println("No. of Test Case = " + this.countTestCases());
		System.out.println("Test Case Name = " + this.getName());
	}
	@Test
	public void testC() {
		System.out.println("textC()");
		System.out.println("No. of Test Case = " + this.countTestCases());
		System.out.println("Test Case Name = " + this.getName());
	}
	@Test
	public void testD() {
		System.out.println("textD()");
		System.out.println("No. of Test Case = " + this.countTestCases());
		System.out.println("Test Case Name = " + this.getName());
	}

}
