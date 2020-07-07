package com.mvn.javaproj2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
/**
 * JUnit 파라미터화 테스트(Parameterized Test)
 * 
 * 동일한 테스트를 @Parameters 컬렉션의 원소 개수만큼 반복 실행
 * Parameterized 클래스는 JUnit이 제공하는 많은 테스트 러너중 하나
 */

@RunWith(value = Parameterized.class)
public class TestParameter {
	
	private int expected;
	private int valueOne;
	private int valueTwo;
	
	@Parameters
	public static Collection<Integer[]> getTestParameters() {
		return Arrays.asList(new Integer[][] {
			// expercted값,valueone값, valuetwo값
			{2, 1, 1},
			{3, 2, 1},
			{4, 3, 1},
			{5, 2, 3},
			{3, 1, 1}
		});
	}

	public TestParameter(int expected, int valueOne, int valueTwo) {
		super();
		System.out.println("testparameter 생성 ()");
		this.expected = expected;
		this.valueOne = valueOne;
		this.valueTwo = valueTwo;
	}



	@Test
	public void sum() {
		Calculator cal = new Calculator(); // 생성자
		assertEquals(expected, cal.add(valueOne, valueTwo));
		System.out.println("test 통과 : " + expected + "," + valueOne + "," + valueTwo);
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("@BeforeClass");
	}

}
