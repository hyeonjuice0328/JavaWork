package com.lec.java.collection04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Collection04Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");

		ArrayList<MemberModel> list = new ArrayList<MemberModel>();

		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 2; i++) {
			System.out.println("id 입력: ");
			String id = sc.nextLine();
			System.out.println("password 입력: ");
			String password = sc.nextLine();

			MemberModel m = new MemberModel(id, password);
			list.add(m);
		}

		sc.close();
		
		Iterator<MemberModel> itr = list.iterator();
		while(itr.hasNext()) {
			itr.next().displayInfo();
		}
		
		for (MemberModel e : list) {
			System.out.println(e);
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.println();
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
