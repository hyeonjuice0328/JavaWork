package com.lec.java.collection08;

import java.util.HashSet;
import java.util.Iterator;

public class Collection08Main {

	public static void main(String[] args) {
		System.out.println("HashSet 연습");
		
		// MyClass 타입을 저장할 수 있는 HashSet 인스턴스 생성
		// 데이터 3개 이상 저장해보고 iterator, enahnce-for 등을 
		// 사용하여 출력해보기
		HashSet<MyClass> set = new HashSet<MyClass>();
		
		// 데이터 3개 저장
		MyClass mc1 = new MyClass(1, "goo");		
		MyClass mc2 = new MyClass(2, "jh");
		MyClass mc3 = new MyClass(1, "goo");
		set.add(mc1);
		set.add(mc2);
		set.add(mc3);
		
		System.out.println("size = " + set.size() + "개");
		
		// 검색: Iterator, enhanced for
		System.out.println();
		System.out.println("Iterator");
		Iterator<MyClass>itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println();
		System.out.println("enhanced for");
		for(MyClass x : set) {
			System.out.println(x);
		}

		// forEach() 메소드 사용
		System.out.println();
		System.out.println("forEach() 사용");
		// TODO

		System.out.println("\n프로그램 종료");
	} // end main()
} // end class

