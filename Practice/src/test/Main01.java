package test;

import java.util.Scanner;

public class Main01 {
	public static void main(String[] args) {
		int num1;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요.");
		num1 = sc.nextInt();
		
		System.out.println(num1 + 100);
		System.out.println(num1 * 1000);
		double num2 = Math.pow(num1, 0.5);
		double result = Math.round(num2);
		System.out.println((int)result);
		
		sc.close();
	}

}
