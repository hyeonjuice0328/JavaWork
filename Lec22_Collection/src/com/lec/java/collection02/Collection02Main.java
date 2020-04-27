package com.lec.java.collection02;

import java.util.ArrayList;
import java.util.Iterator;

public class Collection02Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		
		// String 타입을 담는 ArrayList를 만들고
		ArrayList<String> str1 = new ArrayList<String>();
		
		// 5개 이상의 String을 저장하고
		str1.add("kang");
		str1.add("kim");
		str1.add("hong");
		str1.add("cho");
		str1.add("Lee");
		System.out.println("[수정전]");
		for (int i = 0; i < str1.size(); i++) {
			System.out.println(str1.get(i));
		}
		System.out.println();
		
		// set(), remove() 등의 메소드 사용하여
		str1.set(2, "park");
		System.out.println("[set():수정후]");
		for (int i = 0; i < str1.size(); i++) {
			System.out.println(str1.get(i));
		}
		System.out.println();
		
		// 임의의 것을 수정, 삭제 도 해보시고
		str1.remove(4);
		System.out.println("[삭제후]");
		for (int i = 0; i < str1.size(); i++) {
			System.out.println(str1.get(i));
		}
		System.out.println();
		// 3가지 방식으로 출력해보세요
		System.out.println("[for문 방식으로 출력]");
		for (int i = 0; i < str1.size(); i++) {
			System.out.println(str1.get(i));
		}
		System.out.println();
		System.out.println("[Enhanced-for문 방식으로 출력]");
		for(String s : str1) {
			System.out.println(s);
		}
		System.out.println();
		System.out.println("[Iterator 사용한 출력]");
		Iterator<String> str = str1.iterator();
		while(str.hasNext()) {
			System.out.println(str.next());
		}
		//  for, Enhanced-for, Iterator


		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












