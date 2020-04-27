package 연잔자.형성평가01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int math = sc.nextInt();
		int com = sc.nextInt();
		
		int sum = (int)(kor + eng + math + com);
		int avg = (int)((kor + eng + math + com)/4);
		System.out.println("sum " + sum);
		System.out.println("avg " + avg);
		
		
		sc.close();
	}

}
