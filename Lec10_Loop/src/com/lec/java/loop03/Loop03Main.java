package com.lec.java.loop03;

public class Loop03Main {

	public static void main(String[] args) {
		System.out.println("중첩 for 문 nested for");

		// 구구단 출력 : 중첩 for 사용
		for(int dan = 2; dan <= 9; dan++) {
			
			System.out.println(dan + "단");
			for(int n = 1; n <= 9; n++) {
				System.out.println(dan + " X " + n + " = " + (dan * n));
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("중첩 while문 사용");
		// 구구단 출력 : 중첩 while 문 사용
		int wdan = 2;
		while(wdan <= 9) {
			System.out.println("구구단" + wdan + "단");
			int wn = 1;
			while(wn <=9) {
				System.out.println(wdan + " X " + wn + " = " + (wdan * wn));
				wn++;
			}
			System.out.println();
			wdan++;
			
		}
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


















