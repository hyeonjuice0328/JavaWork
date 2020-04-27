package com.lec.java.for02;

public class For02Main {

	public static void main(String[] args) {
		System.out.println("For문 - 구구단 출력");
		
		int i, j;
		//구구단2단
		for( i = 1; i <= 9; i++) {
			System.out.println(" 2 X " + i + " = " + (2 * i));
		}
		//구구단4단
		System.out.println();
		for( i = 1; i <= 9; i++) {
			System.out.println(" 4 X " + i + " = " + (4 * i));
		}
		// 2 x 2 = 4
		// 3 x 3 = 9
		//  ...
		// 9 x 9 = 81
		System.out.println();
		for( i = 2, i = 2 ; i <= 9 ; i++ ) {
			System.out.println(i +" X " + i + " = " + (i * i));
		}

		
	} // end main()

} // end class For02Main












