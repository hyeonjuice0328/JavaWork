package ex1;

import java.util.Scanner;

/* 
문제 1
정두 타입의 값을 두개 입력 받아서, 나눈 '몫' 과 '나머지' 을 출력하세요  [10점]

[입력예]
52 21

[출력예]
2 10
*/
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(a / b + " " + a % b);
		sc.close();
	} // end main()

} // end class
