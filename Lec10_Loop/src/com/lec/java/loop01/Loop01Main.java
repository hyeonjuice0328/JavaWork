package com.lec.java.loop01;

/* break;
 * 순환문(for, while, do~while) 안에서 break를 만나면
 * break를 감싸는 가장 가까운 순환문 종료
 */
public class Loop01Main {

	public static void main(String[] args) {
		System.out.println("Break");
		
		int num = 1;
		while(num <= 10) {
			System.out.println(num);
			
			if(num == 3) break;
			
			num++;
		}
		
		
		
		System.out.println();
		// 2와 7의 최소공배수를 출력
		// 최소공배수: 공배수 중에서 가장 작은 수

		System.out.println();
		System.out.println("무한 루프와 break;");
		int a = 2, b = 7; 
		int start = (a > b) ? a : b;
		
		while(true) { //true : 무한반복
			if(start % a == 0 && start % b == 0) { // a와 b의 공배수 조건식
				System.out.println(start);
				break;
			}
			start++;
		}


		// TODO
		
		
		
		System.out.println();
		// 2단은 x 2 까지 출력
		// 3단은 x 3 까지 출력
		int a1 = 2, b1 = 3;

		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


















