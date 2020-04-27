package 연잔자.자가진단04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		x++;
		int y = sc.nextInt();
		--y;

		System.out.printf("%d %d %d", x, y, (--x * y));

		sc.close();
	}

}
