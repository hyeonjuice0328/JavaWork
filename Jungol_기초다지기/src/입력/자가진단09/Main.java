package 입력.자가진단09;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		double z = sc.nextDouble();

		System.out.printf("%.3f%n%.3f%n%.3f", x, y, z);

		sc.close();
	}

}
