package 반복제어문1.자가진단06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int x = 0;

		while (true) {
			System.out.println("1. Korea\n" + "2. USA\n" + "3. Japan\n" + "4. China");
			System.out.print("number? ");
			x = sc.nextInt();

			System.out.println();
			if (x == 1) {
				System.out.println("Seoul");
				System.out.println();
				continue;
			} else if (x == 2) {
				System.out.println("Washington");
				System.out.println();
				continue;
			} else if (x == 3) {
				System.out.println("Tokyo");
				System.out.println();
				continue;
			} else if (x == 4) {
				System.out.println("Beijing");
				System.out.println();
				continue;
			} else
				System.out.println("none");
			break;

		}

	}
}
