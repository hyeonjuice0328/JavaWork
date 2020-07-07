package com.mvn.junittest30;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class AppTest3 {

	private String expected;
	private String result;
	
	
	@Parameters
	public static Collection<String[]> getTestParameters() {
		return Arrays.asList(new String[][] {
			{"01012341234","010-1234-1234"},
			{"01012341234","010-1234-1234"},
			{"01012341234","010-1234-1234"}
		});
	}
	// 기본생성자
	public AppTest3(String expected, String result) {
		super();
		this.expected = expected;
		this.result = result;
	}

	// 실습3
	@Test
	public void test3() {
		App app = new App();
		//생성자
		assertEquals(expected, app.toNumber(result));
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("@BeforeClass");
	}

}
