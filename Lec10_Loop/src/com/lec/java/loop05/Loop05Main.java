package com.lec.java.loop05;

public class Loop05Main {

	public static void main(String[] args) {
		System.out.println("순환문 연습 - 언제 100을 넘나?");
		// 1 + (-2) + 3 + (-4) + ...+ (n) >= 100 ?
		// 언제(n) 합이 100을 넘나?  그 합은?
/*		System.out.println();
		int n ;
		int sum;
		for(int i = 1;i > 0 ;i++) {
			for(int j = -2;j < 0; j -= 2) {
				if(i+j >= 100) {
					System.out.println();
				}
			}
		}*/
		
		
		System.out.println();
		System.out.println("순환문 연습 - 두 주사위 눈의 합");
		// 두 주사위 눈의 합 = 6
		// (1, 5), (2, 4), (3, 3), (4, 2), (5, 1)
		// x + y = 6를 만족하는 x, y 쌍을 찾으면 됨.
		for(int x = 1;x <=6; x++) {
			for(int y = 1;x <=6; y++) {
				if(x + y == 6) {
					System.out.println("(" + x + "," + y + ")");
			}//end if
		}//end for(y)
		}//end for(x)
		
		

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
















