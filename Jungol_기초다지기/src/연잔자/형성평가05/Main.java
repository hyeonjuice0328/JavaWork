package 연잔자.형성평가05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		int x1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y1 = sc.nextInt();
		int y2 = sc.nextInt();

		if (x1 > y1 && x2 > y2) {
			System.out.println(true);
		} else
			System.out.println(false);
	}
}