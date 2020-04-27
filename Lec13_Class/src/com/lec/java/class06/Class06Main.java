package com.lec.java.class06;

import java.util.Scanner;

public class Class06Main {

	public static void main(String[] args) {
		System.out.println("클래스 연습 : 성적처리");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("학생의 이름을 입력하세요.");
		String name = sc.next();
		System.out.println("학생의 국어점수를 입력하세요.");
		int kor = sc.nextInt();
		System.out.println("학생의 수학점수를 입력하세요.");
		int math = sc.nextInt();
		System.out.println("학생의 영어점수를 입력하세요.");
		int eng = sc.nextInt();
		
		Score score1 = new Score(name, kor, math, eng);
		
		score1.displayInfo();
		int total = score1.calcTotal();
		double avg = score1.calcAvg();
		System.out.println("총점은 : " + total);
		System.out.printf("평균은 : %.1f",avg);
		
		sc.close();

	} // end main()

} // end class Clas06Main










