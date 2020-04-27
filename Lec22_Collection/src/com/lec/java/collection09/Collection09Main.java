package com.lec.java.collection09;

import java.util.Iterator;
import java.util.TreeSet;

/* TreeSet

 Collection<E>
  |__ Set<E>
       |__ HashSet<E>-검색속도, TreeSet<E>-정렬에 특화

 TreeSet: 데이터가 정렬된 상태로 저장(오름차순, 내림차순)
 
 	(※ TreeXXX ← 주로 '정렬'에 특화된 자료구조 입니다)
*/
public class Collection09Main {

	public static void main(String[] args) {
		System.out.println("TreeSet 클래스");
		
		// Integer 타입을 저장할 수 있는 TreeSet 인스턴스 생성
		TreeSet<Integer> tset = new TreeSet<Integer>();
		
		// 데이터 저장 : add()
		tset.add(11);
		tset.add(2);
		tset.add(14);
		tset.add(1);
		tset.add(7);
		tset.add(15);
		tset.add(5);
		tset.add(8);
		
		// 데이터 검색 - Iterator 사용
		// TreeSet인 경우에 iterator() 메소드 오름차순 정렬
		System.out.println("오름차순:");
		Iterator<Integer> itr = tset.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
		System.out.println();
		System.out.println("내림차순:");
		// 내림차순 Iterator : descendingIterator() 사용 - treeset에서만 사용가능
		Iterator<Integer> itr2 = tset.descendingIterator();
		while(itr2.hasNext()) {
			System.out.println(itr2.next());
		}
		
		// enhanced for
		System.out.println();
		System.out.println("enhanced for");
		for(Integer i : tset) {System.out.println(i);}
		
		//특정구간을 treeset으로 또 나누어 구분할 수 있다.
		//subset() 메소드 
		//시작값과 끝값을 매개변수로 받아 , 그것을 범위로 부분 set 추출
									//TreeSert<Integer>타입으로 형변환
		System.out.println("\nsubset()");
		TreeSet<Integer> subSet = (TreeSet<Integer>)tset.subSet(5, 14);
//		for(Integer e : subSet) {
//			System.out.println(e);
//		} 
		System.out.println(subSet);
		
		subSet = (TreeSet<Integer>)tset.subSet(5,true, 14, true);
		//(값, true) 그 값을 포함해서 출력하겠다는 의미 
		System.out.println(subSet);
		
		subSet = (TreeSet<Integer>)tset.subSet(3, 10);
		//정확하게 그 안에 있는 데이터가 있지 않아도 범위로 구분해서 출력이 가능하다. 
		System.out.println(subSet);
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












