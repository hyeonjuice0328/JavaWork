package ex3;

import java.util.Scanner;

/* 
문제3]
정수 학점 입력 받은뒤
아래와 같이 등급을 출력하세요

학점이 90점 이상이면 "A학점" 출력
학점이 80점 이상이면 "B학점" 출력
학점이 70점 이상이면 "C학점" 출력
학점이 60점 이상이면 "D학점" 출력
학점이 60점 미만이면 "F학점" 출력

[입력예]
87

[출력예]
B
 */
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int average = sc.nextInt();
		
		if (average >= 90) {
			System.out.println("A학점");
		} else if (average >= 80) {
			System.out.println("B학점");
		} else if (average >= 70) {
			System.out.println("C학점");
		} else if (average >= 60) {
			System.out.println("D학점");
		} else {
			System.out.println("F학점");
		} // end else

		sc.close();
		
	} // end main()

} // end class
