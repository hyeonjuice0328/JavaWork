package com.lec.java.array04;

import java.util.Scanner;

/* 연습
 * 길이 5개 int 형 배열을 선언하고
 * 사용자로부터 5개 정수를 입력받아 초기화 한뒤 
 * 
 * 총점, 평균, 최대값, 최소값  출력해보기
 */
public class Array04Main {

	public static void main(String[] args) {
		System.out.println("배열 연습");

		int[] art = new int[5];
		int sum = 0;

		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < art.length; i++) {
			System.out.println("점수입력 : ");
			art[i] = sc.nextInt();
			sum += art[i];

		}
		sc.close();

		System.out.println("총점: " + sum);
		System.out.println("평균: " + (double) sum / art.length);

		System.out.println();
		int max = art[0];
		for (int i = 1; i < art.length; i++) {
			if(art[i] > max) {
				max = art[i];
			}
		}
		System.out.println("최댓값 : " + max);
		
		System.out.println();
		int min = art[0];
		for (int i = 1; i < art.length; i++) {
			if(art[i] < min) {
				min = art[i];
			}//end if
			
//			min = (art[i] < min) ? art[i] : min;  > if문 대치 가능 
			
		}//end for 
		System.out.println("최소값 : " + min);
		
	} // end main()

} // end class Array04Main
