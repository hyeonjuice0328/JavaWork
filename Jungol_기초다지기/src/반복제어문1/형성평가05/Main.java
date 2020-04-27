package 반복제어문1.형성평가05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int b;
		int h;
		String a;

		while (true) {
			System.out.printf("Base = ");
			b = sc.nextInt();
			System.out.printf("Height = ");
			h = sc.nextInt();
			System.out.printf("Triangle width = %.1f\n", (b * h) / 2.0f);
			System.out.printf("Continue? ");
			a = sc.next();
			if (!a.equals("y") && !a.equals("Y"))
				break;
		}

	}
}
