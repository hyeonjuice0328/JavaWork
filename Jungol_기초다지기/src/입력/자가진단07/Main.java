package 입력.자가진단07;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println(x + " * " + y + " = " + (x * y));
		System.out.println(x + " / " + y + " = " + (x / y));
		sc.close();
	}

}
