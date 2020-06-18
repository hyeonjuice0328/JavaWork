package com.lec.spring.di03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.Score;

public class DIMain03 {

	public static void main(String[] args) {
		System.out.println("Main시작");
		
		//ApplicationContext (컨테이너) 생성, (bean 도 자동생성)
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:scoreCtx.xml");
		System.out.println("컨테이너 생성\n");
		
		Score score = null;
		score = ctx.getBean("myScore1", Score.class);
		System.out.println(score);
		
		// 두번째 매게변수가 없는 경우 오브젝트 타입을 리턴 .. 따라서 형변환을 해주어 해결해주어도 된다. 
		score = (Score)ctx.getBean("myScore2");
		System.out.println(score);
		
		score = ctx.getBean("myScore3", Score.class);
		System.out.println(score);

		score = ctx.getBean("myScore4", Score.class);
		System.out.println(score);

		score = ctx.getBean("myScore5", Score.class);
		System.out.println(score);

		score = ctx.getBean("myScore6", Score.class);
		System.out.println(score);
		
		score = ctx.getBean("myScore7", Score.class);
		System.out.println(score);

		score = ctx.getBean("myScore8", Score.class);
		System.out.println(score);
		
		System.out.println("생성된 빈의 개수: " + ctx.getBeanDefinitionCount());
		for(int i = 1; i <= ctx.getBeanDefinitionCount(); i++) {
			// object type return => println 은 string 으로 반환 이미 override 되어 있음 toString()
			System.out.println(ctx.getBean("myScore" + i));
		}
		
		ctx.close();
		System.out.println("Main종료");
	}

}
