package 선택제어문.형성평가04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Number?");
		int x = sc.nextInt();

		if (x == 1) {
			System.out.println("dog");
		} else if (x == 2) {
			System.out.println("cat");
		} else if (x == 3) {
			System.out.println("chick");
		} else
			System.out.println("I don't know.");

		sc.close();
	}

}
