package 선택제어문.자가진단04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		double w = sc.nextDouble();
		
		if(w <= 50.80) {
			System.out.println("Flyweight");
		}if(w <= 61.23 && w > 50.80) {
			System.out.println("Lightweight");
		}if(w <= 72.57 && w > 61.23) {
			System.out.println("Middleweight");
		}if(w <= 88.45 && w > 72.57) {
			System.out.println("Cruiserweight");
		}else if(88.45 < w) {
			System.out.println("Heavyweight");
		}
		
		
		sc.close();

	}

}
