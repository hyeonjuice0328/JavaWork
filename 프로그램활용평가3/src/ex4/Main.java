package ex4;

import java.util.Scanner;

/*
문제4
정수 n 을 입력 받아서 n! 을 계산하여 출력하세요
	ex) 5! = 5 x 4 x 3 x 2 x 1

[입력예]
5

[출력예]
120
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int n = sc.nextInt();
		
		int result = 1;
		for(int i = n; i >= 1; i--) {
			result *= i;
		}
		System.out.println(result);
		sc.close();
		
	} // end main()

} // end class
