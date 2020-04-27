package 선택제어문.자가진단02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int hei = sc.nextInt();
		int wei = sc.nextInt();
		int ob= wei+100-hei;
		
		if(ob < 0) {
			System.out.println(ob);
		} else if(ob > 0) {
			System.out.println(ob);
			System.out.println("Obesity");
		}
		
	
		
		sc.close();

	}

}
