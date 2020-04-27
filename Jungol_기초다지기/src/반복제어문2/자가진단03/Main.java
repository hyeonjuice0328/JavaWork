package 반복제어문2.자가진단03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();

		for (int i = 1; i <= x; ++i) {
			if (i % 2 == 0)
				System.out.print(i + " ");
		}

	}

}
