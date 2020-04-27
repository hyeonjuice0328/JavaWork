package 연잔자.형성평가03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();

		int w = (x + 5);
		int l = (y * 2);
		System.out.println("width = " + w);
		System.out.println("length = " + l);
		System.out.println("area = " + (w * l));

		sc.close();
	}

}
