package 반복제어문2.자가진단06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int num, i, score, sum = 0;
		double avg = 0;
		num = sc.nextInt();

		for (i = 0; i < num; i++) {
			score = sc.nextInt();
			sum += score;
			avg = sum/(float)num;
		}

		System.out.printf("avg : %.1f\n" , avg);
		if (avg >= 80)
			System.out.println("pass");
		if (avg < 80)
			System.out.println("fail");
	}

}
