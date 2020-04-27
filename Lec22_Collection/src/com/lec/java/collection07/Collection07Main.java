package com.lec.java.collection07;

import java.util.HashSet;
import java.util.Iterator;

public class Collection07Main {

	public static void main(String[] args) {
		System.out.println("HashSet 연습");
		
		HashSet<String>set = new HashSet<String>();
		// String 타입을 저장할 수 있는 HashSet 를 생성하고
		set.add("abc");
		set.add("aaa");
		set.add("bbb");
		set.add("ccc");
		set.add("ddd");
		set.add("eee");
		
		for(String e : set) {
			System.out.println(e);
		}
		// 5개 이상의 데이터는 저장, 수정, 삭제 등의 동작을 해보고,
		set.remove("abc");
		set.add("ggg");
		System.out.println("수정 후");
		
		Iterator<String>itr = set.iterator();
		while(itr.hasNext()) {
		System.out.println(itr.next());	
		}
		// iterator, enhanced-for 문을 사용해서 출력해보기
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
















