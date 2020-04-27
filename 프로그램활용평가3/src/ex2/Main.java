package ex2;

import java.util.Scanner;

/* 
문제 2
두개의 문자열을 입력받아서 같다면 true 다르면 false 를 출력하세요[10점]

[입력예1]
john
John

[출력예1]
false

[입력예2]
hello
hello

[출력예2]
true
*/
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String a = sc.nextLine();
		String b = sc.nextLine();
		
		System.out.println(a.equals(b));
		
		sc.close();
	} // end main()

} // end class
