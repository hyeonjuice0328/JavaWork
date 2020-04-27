package 연잔자.자가진단07;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();

		if ((x * y) != 0) {
			System.out.print(true);
		} else
			System.out.print(false);

		if ((x + y) != 0) {
			System.out.print(" " + true);
		} else
			System.out.print(" " + false);

		sc.close();
	}

}
