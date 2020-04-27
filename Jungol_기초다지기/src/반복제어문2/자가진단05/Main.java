package 반복제어문2.자가진단05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int num = 0;
		int num3 = 0, num5 = 0;

		for (int i = 0; i < 10; i++) {
			num = sc.nextInt();
			if (num % 3 == 0)
				num3++;
			if (num % 5 == 0)
				num5++;
		}
		System.out.println("Multiples of 3 : " + num3);
		System.out.println("Multiples of 5 : " + num5);
	}

}
