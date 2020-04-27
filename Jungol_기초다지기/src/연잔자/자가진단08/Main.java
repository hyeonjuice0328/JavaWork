package 연잔자.자가진단08;

import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();

		if (x > y && x > z) {
			System.out.print(true);
		} else
			System.out.print(false);

		if (x == y && y == z) {
			System.out.println(" " + true);
		} else
			System.out.println(" " + false);
	}

}
