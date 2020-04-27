package 연잔자.자가진단05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();

		if (x == y) {
			System.out.println("1");
		} else
			System.out.println("0");

		if (x == y) {
			System.out.println("0");
		} else
			System.out.println("1");

		sc.close();
	}

}
