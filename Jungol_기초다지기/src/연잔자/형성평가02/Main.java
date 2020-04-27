package 연잔자.형성평가02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();

		System.out.println(x + " / " + y + " = " + (x / y) + "..." + (x % y));

		sc.close();
	}

}
