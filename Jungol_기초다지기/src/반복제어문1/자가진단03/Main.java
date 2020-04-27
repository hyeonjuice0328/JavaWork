package 반복제어문1.자가진단03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int x;

		while (true) {
			System.out.println("number?");
			x = sc.nextInt();

			if (x != 0) {
				if (x > 0) {
					System.out.println("positive integer");
				} else
					System.out.println("negative number");
			} else
				break;

		}

	}
}
