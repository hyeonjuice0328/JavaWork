package 연잔자.자가진단02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, y;
		x = sc.nextInt();
		y = sc.nextInt();

		System.out.printf("%d %d", (x + 100), (y % 10));

		sc.close();
	}

}
