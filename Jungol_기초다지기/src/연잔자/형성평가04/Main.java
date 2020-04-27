package 연잔자.형성평가04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		++x;
		int y = sc.nextInt();
		System.out.println(x + " " + y);
		y--;

		System.out.println(x + " " + y);
		sc.close();
	}

}
