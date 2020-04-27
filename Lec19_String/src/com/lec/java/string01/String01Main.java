package com.lec.java.string01;

import java.util.Arrays;
import java.util.Scanner;

/* 문자열 (String) 관련 메소드들
 * 
 * https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
 * - 문자열 메소드는 꼭 정독해보세요.
 * - 매개변수의 의미, 동작의 의미, 리턴값의 의미 꼭 숙지해주세요
 * - 인스턴스 메소드 인지, 클래스 메소드(static) 인지 구분 
 */
public class String01Main {

	public static void main(String[] args) {
		System.out.println("String 클래스의 메소드들");
		
		String str1 = "AbCdEfg";
		String str2 = "안녕하세요~";
		
		System.out.println();
		System.out.println("length()");  // 문자의 개수
		System.out.println("str1 길이: " + str1.length());
		System.out.println("str2 길이: " + str2.length());
		
		System.out.println();
		System.out.println("concat()");  // 문자열 연결 (concatenation)
		System.out.println(str1.concat(str2));
		System.out.println(str2.concat(str2));
		System.out.println(str1.concat(str2).concat(str1));
		String str3 = str1.concat(str2);
		System.out.println(str3.length());
		
		
		// ★주의★
		// 문자열(String) 은 변경불가(immutable) 이기 때문에
		// 메소드 수행했다고 하여 원본이 변경되지 않는다.
		str1.concat(str2);
		System.out.println(str1); //원본의 결과는 변경되지 않는다. 
		//변경시키고 싶다면!!!
		str1 = str1.concat(str2); //덮어쓰기! 
		System.out.println(str1);
		
		// ★주의★
		// empty 문자열과 null 은 다르다
		// null 인 경우 메소드 수행하면 NullPointerException 발생!
		str3 = ""; // empty 문자열 , String객체는 존재하나 비어있는 문자열 
		System.out.println(str3.length()); // 결과값 = 0
		str3 = null; // null은 문자열 이 존재하지 않음
		//System.out.println(str3.length()); 
		// NullPointerException 객체 자체가 존재하지 않기 때문에 '.'찍어서 어딘가 안으로 들어가서 작업하는 것이 불가능 
		
		
		System.out.println();
		System.out.println("charAt(index)"); // 문자열 안의 특정위치(index)의 문자 리턴, 인덱스 범위 벗어나면 StringIndexOutOfBoundsException
											// 문자열 인덱스는 0 부터 시작!
		System.out.println(str1.charAt(0)); //0번째 문자
		System.out.println(str1.charAt(1)); //1번째 문자
//		System.out.println(str1.charAt(20)); //StringIndexOutOfBoundsException String도 인덱스 벗어나면 

		
		System.out.println();
		System.out.println("indexOf(char), indexOf(String)"); // 문자열 안에서 특정 문자(char) 혹은 문자열(String)의 위치(index), 발견 못하면 -1 리턴
		System.out.println(str1.indexOf('c'));
		System.out.println(str2.indexOf('요'));
		System.out.println(str2.indexOf("하세")); //문자열에 이 문자 있는지 확인 여부 없으면  -1을 리턴

		
		System.out.println();
		System.out.println("toUpperCase(), toLowerCase");  // 대문자 변환, 소문자 변환
		System.out.println(str1.toUpperCase()); //알파벳에서만 적용이 가능 알페벳 대소문자 정렬
		System.out.println(str1.toLowerCase());
		
		System.out.println();
		System.out.println("startWith()");  // 문자열이 주어진 prefix문자열로 시작하는지 여부 true/false 리턴
		String prefix = "http://";
		String url = "www.google.com";  
		System.out.println(url.startsWith(prefix)); // 주어진 url이 prefix문자열로 시작합니까?
		if(!url.startsWith(prefix)) {
			String newUrl = prefix.concat(url);
			System.out.println(newUrl);
		}
		
		
		System.out.println();
		System.out.println("split(regex)"); // 문자열을 주어진 문자열로 쪼개어 String형 배열!>String[] 리턴
		String str4 = "HH:MM:SS";
		String[] strings = str4.split(":"); // :를 기준으로 쪼개겠다는 의미 
		System.out.println(Arrays.toString(strings));
		
		// 공백기준으로 쪼갤때는 정규표현식의 \\s+  사용하기 : 공백, 탭, 줄바꿈
		str4 = "    Hel\tlo  M\ny World";
		strings = str4.split("\\s+");
		System.out.println(Arrays.toString(strings));
		
		// 단!  "|" 을 할경우는 주의,   ※ split(정규표현식) 을 사용하는 메소드임
		String str5 = "HH|MM|SS";
		strings = str5.split("\\|");
		for(String x : strings) {
			System.out.println(x);
		}
		
		// 년, 월, 일, 시 , 분, 초 분리하기 split은 string타입의 []배열을 리턴한다. 
		str4 = "2018-08-16 14:34:52";
		String date =  str4.split("\\s+")[0];
		String time =  str4.split("\\s+")[1];
		System.out.println("date : " + date);
		System.out.println("time : " + date);
		String year = date.split("-")[0]; 
		System.out.println("year : " + year);
		String month = date.split("-")[1]; 
		System.out.println("month: " + month);
		
		
		// String.join() 
		// 문자열들, 문자열 배열  --> 하나의 문자열로 합하기     split() 과 반대
		System.out.println();
		System.out.println("String.join(delimeter, elements ...)");
		String[] str7 = {"Alice", "Bob", "Carol"};
		System.out.println(String.join(" - ", str7));
		
		
		System.out.println();
		System.out.println("substring(beginIndex, endIndex)");  // 문자열의 일부분 추출 beginIndex ~ endIndex직전 까지,  인덱스 범위 벗어마면 IndexOutOfBoundsException 
		String str8 = "Hello Java";
		System.out.println(str8.substring(2, 5)); // 2부터 5전까지 
		System.out.println(str8.substring(6)); // 6부터 끝까지
			
		
		System.out.println();
		System.out.println("trim()");   // 좌우의 여백 제거
		String str9 = "   김동후   ";
		System.out.println("[" + str9 + "]"); //공백도 문자열이라 str9를 호출하면 공백도 같이 출력된다. 
		System.out.println("[" + str9.trim() + "]"); //공백 제거 
		
		
		System.out.println();
		System.out.println("replace(target, replacement)");   // 문자열 치환  target → replacement  
		String str10 = "Hello Language My Language";
		System.out.println(str10.replace("My", "Our")); // My->Our 로 치환 
		System.out.println(str10.replace("Language", "Java")); 
	
		System.out.println();
		System.out.println("replaceAll(regex, replacement), replaceFirst(regex, replacement)"); // 정규표현식 사용버젼  , replaceAll() 매칭되는것 전부 치환, replaceFirst() 첫매칭만 치환
		System.out.println(str10.replaceAll("Language", "자바")); //전부 치환
		System.out.println(str10.replaceFirst("Language", "자바")); //첫번째 부분만 치환
				
		System.out.println();
		System.out.println("equals(), equalsIgnoreCase()");  // 문자열 비교
		String str11 = "Java";
		String str12 = "java";
		// TODO
		
		System.out.println();
		System.out.println("String.format()");
		// TODO
		
		
		// 연습 : id /pw 입력받고요
		//  로그인 성공 여부를 출력해주세요
		
		Scanner sc = new Scanner(System.in);
		
		// TODO
		
		sc.close();

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









