package 입력.형성평가04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, y, z;
		x = sc.nextInt();
		y = sc.nextInt();
		z = sc.nextInt();

		System.out.println("sum = " + (x + y + z));
		System.out.println("avg = " + (int)((x + y + z) / 3));

		sc.close();
	}

}
