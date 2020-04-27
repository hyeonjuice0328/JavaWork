package 연잔자.자가진단06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();

		if (x >= y) {
			System.out.println(x + " > " + y + " --- " + true);
			System.out.println(x + " < " + y + " --- " + false);
			System.out.println(x + " >= " + y + " --- " + true);
			System.out.println(x + " <= " + y + " --- " + false);
		} else if (x <= y) {
			System.out.println(x + " > " + y + " --- " + false);
			System.out.println(x + " < " + y + " --- " + true);
			System.out.println(x + " >= " + y + " --- " + false);
			System.out.println(x + " <= " + y + " --- " + true);
		}
		sc.close();
	}

}
