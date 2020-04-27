

import java.util.Scanner;

public class Main02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자열을 입력하세요");
		String str = sc.nextLine();
		System.out.println("정수를 입력하세요");
		int num = sc.nextInt();
		
		for (int i = 0; i < num; i++) {
			System.out.println(str);
		}
		
		sc.close();
	}

}
