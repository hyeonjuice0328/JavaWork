package 반복제어문1.자가진단05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int x;

		while (true) {
			x = sc.nextInt();

			if (x != -1) {
				if (x % 3 == 0) {
					System.out.println(x / 3);
				} else {

				}
			} else
				break;

		}

	}
}
