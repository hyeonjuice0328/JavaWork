package com.lec.spring.aop02;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.lec.beans.Logger;

// Aspect : Advisor 들을 모아놓은 객체 
// Advisor : Advice + Pointcut
// Advice : 공통 기능 (메소드)

// annotation 사용하여 이 클래스가 Aspect 역할의 클래스임을 명시 
// Spring container 에 들어가 있어야 실행이 된다. 
@Aspect
public class LogAspect {
	
	@Pointcut("within(com.lec.spring.aop02.*)")
	public void pc1() {} // 메소드 정의지만 이름으로 지정됨.
	
	@Pointcut("within(com.lec.spring.aop02.*)")
	public void pc2() {}
	
	// Advisor
	//@Before("within(com.lec.spring.aop02.*)") // pointcut
	@Before("pc1()")
	// @Before : 호출되기 전에 호출
	
	// 메소드 생성 - Advice
	public void beforeAdvice() {
		System.out.print("[Before]");
		new Logger().logIn(); // 공통 코드 삽입 - Advice!
	}
	
//	@After("within(com.lec.spring.aop02.*)")
//	@After("execution(* com.lec.spring.aop02.MyService22.*(..))")
//	@After("pc2()")
	@After("execution(* com.lec.spring.aop02.*2.*(..))") // *2:2로 끝나는 클래스 , *:메소드모두
	public void afterAdvice() {
		System.out.print("[After]");
		new Logger().logOut();
	}
	
	// around type 의 advice : 메소드 실행을 제어하는 가장 강력한 코드 
	// 직접 해당 메소드를 호출하고 결과나 예외처리 가능.
	@Around("within(com.lec.spring.aop02.*)")				// catch 안하고 여기서 처리
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		// joinPoint 메소드 이름 
		String signatureStr = joinPoint.getSignature().toShortString();
	
		// joinPoint 메소드 수행 전 
		System.out.println("[Around]" + signatureStr + "시작");
		long st = System.currentTimeMillis(); // 시작 시간 기록 - 경과시간측정가능
		
		try {
			// joinPoint 메소드 수행 // 오브젝트 타입 리턴, joinPoint 실행하는 문장 
			Object obj = joinPoint.proceed();
			return obj;
		} finally {
			// joinPoint 메소드 수행 후
			long et = System.currentTimeMillis(); // 종료 시간 기록- 경과시간측정가능
			System.out.println("[Around]" + signatureStr + "종료, 경과시간 " + (et-st));
		}
		
	}
}
