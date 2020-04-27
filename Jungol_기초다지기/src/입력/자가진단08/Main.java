package 입력.자가진단08;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		String z = sc.next();
		
		System.out.printf("%.2f%n%.2f%n%s", x, y, z);
		
		sc.close();
	}

}
