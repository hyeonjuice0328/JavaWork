package com.lec.java.array10;

/* Enhanced for (향상된 for) 문
 	
 	for (배열타입 변수 : 배열이름) { ... }
 	
 */
public class Array10Main {

	public static void main(String[] args) {
		System.out.println("Enhanced for (향상된 for) 문");
		System.out.println("일반 for문 사용");
		int[] arr = { 11, 22, 33, 44, 55 };
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " ");
		} // end for
		System.out.println();

		System.out.println("enhanced-for문 사용");
		for (int x : arr) {
			System.out.println(x);
		} // end for

		System.out.println();
		System.out.println("2차원 배열에서 enhanced-for문 사용");
		int[][] arr2 = { { 1, 2 }, { 3, 4, 5, 6 }, { 7, 8, 9 } }; // end 2차배열(legged array)
		for (int[] row : arr2) {
			for (int e : row) {
				System.out.print(e + " ");
			} // end for(e)
			System.out.println();
		} // end for(row)

	} // end main()

} // end class Array10Main
