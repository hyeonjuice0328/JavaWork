package 연잔자.자가진단03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x;
		x = sc.nextInt();

		System.out.printf("%d%n%d", x++, ++x);

		sc.close();
	}

}
