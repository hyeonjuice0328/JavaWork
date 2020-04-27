package 반복제어문1.형성평가03.copy;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int num = 0;
		int cnt = 0;
		int sum = 0;
		double avg = 0.0;
		
		while(true) {
			num = sc.nextInt();
			if(num < 0 || num > 100) break;
			else {
				sum += num;
				cnt ++;
				avg = sum/(float)cnt;
				
			}
		}
		System.out.println("sum : " + sum);
		System.out.printf("avg : %.1f" , avg);

	}

}
