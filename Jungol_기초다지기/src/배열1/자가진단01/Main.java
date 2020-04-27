package 배열1.자가진단01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String [] arr = new String[10];
		String sum = "";
		for (int j = 0; j < arr.length; j++) {
			arr [j] = sc.next();
			sum += j;
			System.out.printf("%c", sum);
		}
		sc.close();
	}
}
