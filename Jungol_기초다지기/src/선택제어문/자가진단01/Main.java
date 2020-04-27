package 선택제어문.자가진단01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		if(num < 0) {
			System.out.println(num);
			System.out.println("minus");
		}else if(num > 0) {
			System.out.println(num);
		}
		
	
		
		sc.close();

	}

}
