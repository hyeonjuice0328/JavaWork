package 반복제어문1.형성평가02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int num = 0;
		int o = 0;
		int e = 0;

		while (true) {
			num = sc.nextInt();
			if (num == 0)
				break;
			if (num % 2 == 0)
				e++;
			else
				o++;
		}
		System.out.println("odd : " + o);
		System.out.println("even : " + e);
	}

}
