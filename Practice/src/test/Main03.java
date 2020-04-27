package test;

import java.util.Scanner;

public class Main03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("나이를 입력하세요");
		int num = sc.nextInt();
		
		if(num > 0 && num <= 18) {
			System.out.println("미성년자");
		} else if (num > 18 && num >=19 ) {
			System.out.println("성년");
		} else System.out.println("잘못 입력하셨습니다.");
			
		sc.close();
	}

}
