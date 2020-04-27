package com.lec.java.input02;

import java.util.Scanner;

//ctrl + shift + o : 자동 import

//문자열(String) 입력
//char 입력
public class Input02Main {

	public static void main(String[] args) {
		System.out.println("표준입력: String, char");

		Scanner sc = new Scanner(System.in);
		
/*		//String 입력
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine(); //엔터를 입력할때까지 모든 문자들을 문자열로 리턴(한줄을 입력)
		
		System.out.println("별명을 입력하세요 : ");
		String nick = sc.nextLine();
		
//		System.out.println("이름은 : " + name + "\n별명은 : " + nick);
		
		// char 입력
*/		// .nextChar()? 라는 명령 없다. 
//		System.out.println("성별을 입력하세요 M/F : ");
//		char gender = sc.next().charAt(2);
//		System.out.println("성별은 : " + gender);
//		
//		System.out.println();
//		
		System.out.println("나이를 입력하세요 : ");
		int age = sc.nextInt();
		
		System.out.println("주소를 입력하세요 :");
		sc.nextLine();
		String addr = sc.nextLine();
		//nextLine()은 enter가 입력되면 종료된다. 숫자 입력 후 enter가 들어가고 nextInt()는 숫자만 
		//가지고 가기 때문에 enter가 그대로 남아있어 nextLine()을 한번더 입력해주지 않으면 enter만 가지고 
		//가서 종료가 되어 버린다. 
		//숫자 입력 받은 뒤에 문자열 입력시에는 반드시 '\n'을 consume(버퍼에서 제거) 해야한다.
		//sc.nextLine(); 을 한번 추가로 입력해준다. 
		
		System.out.println("나이: " + age + "살"+ "\n주소: " + addr);
		
		sc.close();
		
		
	}// end main()

} // end class
