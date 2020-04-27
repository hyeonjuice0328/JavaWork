package 반복제어문2.자가진단04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int sum = 0;

		for (int i = x; i <= 100; i++) {
			sum += i;
		}
		System.out.println(sum);

	}

}
