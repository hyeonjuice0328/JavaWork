package com.lec.java.oop06;

import java.util.Scanner;

public class Interface02Main {

	public static void main(String[] args) {
		System.out.println("인터페이스");

		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 선택: ");
		int menu = sc.nextInt();
		sc.close();
		
		switch(menu) { //리터럴(0,1,2,3,"입력메뉴" ...etc) 이 들어가는 코드는 자제하는 추세 활용도가 떨어지기 때문이다. 
		case 0: 
			System.out.println("프로그램 종료 ");
			return;
		case 1:
			System.out.println("입력 메뉴");
			break;
		case 2:
			System.out.println("검색 메뉴");
			break;
		default : 
			System.out.println("잘못입력했습니다.");
		}

		switch(menu) {
		case Menu.Menu_Quit: 
			System.out.println(Menu.Menu_Quit);
			return;
		case Menu.Menu_Insert:
			System.out.println(Menu.Menu_Insert);
			break;
		case Menu.Menu_Search:
			System.out.println(Menu.Menu_Search);
			break;
		default : 
			System.out.println(Menu.STR_ERROR);
			break;
		}

		System.out.println("\n 프로그램 종료");
		System.out.println("\n 프로그램 종료");
	} // end main()

} // end class
