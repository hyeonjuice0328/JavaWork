package com.lec.java.collection14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* java.util.Collections 클래스
	 Collections 클래스는 여러 유용한 알고리즘을 구현한 메소드들을 제공
	 대부분 클래스메소드 (static) 형태로 제공됨
	 
	 정렬(sort)
	 섞기(shuffle)
	 탐색(search)
 */

public class Collection14Main {

	public static void main(String[] args) throws ParseException {
		System.out.println("Collections 메소드");

		List<String> list1 = new LinkedList<String>();
		//다형성에 의해 타입이 달라도 가능 (LinkedList는 List의 자식)
		
		list1.add("장수영");
		list1.add("김진영");
		list1.add("고유성");
		
		System.out.println(list1); // List의 toString() 결과 형태 출력
		
		System.out.println("sort()");
		// sort()
		// 기본적으로 속도가 비교적 빠르고 안전성이 보장되는 Merge Sort 사용
		
		Collections.sort(list1);
		System.out.println(list1);
		
		System.out.println();
		List<Date>list2 = new LinkedList<Date>();
		// "2018-08-16" ---> Date객체로 변환하는 방법
		//new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-16") ---> 전체가 Date객체
		list2.add(new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-16")); 
		list2.add(new SimpleDateFormat("yyyy-MM-dd").parse("2002-05-31")); 
		list2.add(new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-22"));
		System.out.println(list2); //결과:[Thu Aug 16 00:00:00 KST 2018, Fri May 31 00:00:00 KST 2002, Sat Feb 22 00:00:00 KST 2020]
		Collections.sort(list2);
		System.out.println(list2); //결과:[Fri May 31 00:00:00 KST 2002, Thu Aug 16 00:00:00 KST 2018, Sat Feb 22 00:00:00 KST 2020]
		
		// String 타입이면 알파벳 순으로 정렬된다. 한글은 가나다 순으로 정렬
		// Date 타입이면 날짜순으로 정렬된다
		// ★ String 과 Date 는 기본적으로 Comparable<T> 인터페이스가 구현되었기 때문.
		// ※ String 온라인 도움말 확인해보자
	
		System.out.println();
		// 학생들 리스트를 담는 객체 생성
		List<Student> list3 = new LinkedList<Student>();
		list3.add(new Student("Susie", 50));
		list3.add(new Student("James", 80));
		list3.add(new Student("Kevin", 30));
		System.out.println(list3);
		
		
		System.out.println("Comparable 구현, sort() 적용");
		Collections.sort(list3);
//	    ★ String 과 Date 는 기본적으로 Comparable<T> 인터페이스가 구현되었기 때문 안되어있으면 에러난다. 
		System.out.println(list3);
		
		// 역순 정렬
		System.out.println("reverseOrder() 적용");
		Collections.sort(list3, Collections.reverseOrder());
		System.out.println(list3);
		
		System.out.println("reverse() 적용");
		Collections.reverse(list3);
		System.out.println(list3);
		
		
		// Comparator<> 적용
		// Collections.sort 메소드는 두 번째 인자로 Comparator 인터페이스를 받을 수 있도록 해놓았습니다.
		// Comparator 인터페이스의 compare 메소드를 오버라이드 하면 됩니다.
		System.out.println("Comparator<> 적용");
		Collections.sort(list3, new Asc());  // '이름'오름차순으로 정렬 
		System.out.println(list3);
		
		// 이름 내림차순
		Collections.sort(list3, new Desc());
		System.out.println(list3);
		
		
		// Collections 에서 많이 쓰이는 인터페이스임
		// Comparable 은 클래스 자체에 구현하는 인터페이스  compareTo(자기사진 vs 매개변수)
		// Comparator 는 두개의 객체 비교하는 기능제공 인터페이스  compare(매개변수1 vs 매개변수2)
		//      구현된 객체가 매개변수 등에 넘겨지는 형태로 많이 쓰임
		
		// Shuffling 하기 (섞기)
		System.out.println();
		System.out.println("shuffle()");
		Collections.shuffle(list1);
		System.out.println(list1);
		Collections.shuffle(list1);
		System.out.println(list1);
		
		//배열에서 랜덤으로 3개 뽑기 
		String[] arr = {"aa","vv","bb","gg","dd","ee","ss","zz"};
//		Arrays.asList(arr); // 배열을 리스트로 만들어주는 메소드 asList
		List<String> arrList = Arrays.asList(arr);
		Collections.shuffle(arrList);
		arrList = arrList.subList(0, 3); // index 0부터 3 전까지의 List<> 생성
		System.out.println(arrList);
		
		// min(), max()
		// Comparable 메소드 영향 받음
		System.out.println();
		System.out.println("min(), max()");
		System.out.println(Collections.min(list3));
		System.out.println(Collections.max(list3));
		System.out.println(Collections.min(list1));
		System.out.println(Collections.max(list1));
		
		// copy()
		System.out.println();
		List<Student> list4 = new LinkedList<Student>();
		list4.add(new Student("aaa", 10));
		list4.add(new Student("bbb", 20));
		list4.add(new Student("ccc", 30));

		System.out.println("copy()전");
		System.out.println(list4);
		System.out.println("copy()전");
		Collections.copy(list4, list3); // list3에 있는 내용이 list4에 덮어쓰기된다. 
		System.out.println(list4);
		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class


class Student implements Comparable<Student>{
	String name;
	double point;
	
	public Student(String name, double point) {
		super();
		this.name = name;
		this.point = point;
	}
	
	@Override
	public String toString() {
		return this.name + ":" + this.point + "점";
	}

	// compareTo() 메소드는 매개변수 객체를 '자신'과 비교하여 작으면 음수 
	// 같으면 0, 크면 양수를 리턴한다. 
	@Override
	public int compareTo(Student o) {
		
		// 점수 오름차순으로 정렬
//		if(o.point > this.point) return -1; //주어진 point가 내 point보다 크면 -1을 리턴
//		if(this.point > o.point) return 1; // 내 point가 주어진 point보다 크면 1을 리턴
//		return 0; // 같으면 0 
//		// 순서에 관한 이야기 
		
		//점수 내림차순으로 정렬
		if(o.point < this.point) return -1; //주어진 point가 내 point보다 크면 -1을 리턴
		if(this.point < o.point) return 1; // 내 point가 주어진 point보다 크면 1을 리턴
		return 0; // 같으면 0 
		// 순서에 관한 이야기 
		
		
	}

	// TODO

} // end class

// Student 를 이름(name)을 오름차순으로 정렬해줄 수 있는 Comparator<> 제공
class Asc implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) { // 두개를 비교해서 
		// 이름 
		return o1.name.compareTo(o2.name); // o1.name 과 o2.name 을 비교 		
	}

	
} // end Asc


// Student 를 이름(name)을 내림차순으로 정렬해줄 수 있는 Comparator<> 제공
class Desc implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o2.name.compareTo(o1.name);
	}
	
} // end Asc

