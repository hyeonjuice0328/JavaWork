package com.lec.java.regexp02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 그룹(group) 
 * 정규표현식에 () 을 사용하여  패턴 내에서 '그룹'을 지정 하면
 * () 의 개수만큼 그룹이 만들어진다.
 */
public class RegExp02Main {

	public static void main(String[] args) {
		System.out.println("정규표현식 : group");

		String input;
		String regex;
		Pattern pat;
		Matcher matcher;

		
	
		System.out.println();
		regex = "(My)(....)"; // 정규표현식에 () 사용
		pat = Pattern.compile(regex);

		input = "-My98KK-myABCD--My1234567--MyZZ---My789";

		matcher = pat.matcher(input);

		System.out.println("groupCount() : " + matcher.groupCount()); // 이 정규표현식에 그룹이 몇개 인지 알려주는 ....

		System.out.println("입력문자열 : " + input);

		while (matcher.find()) {
			System.out.println(matcher.group() + "  {" + matcher.start() + "~" + matcher.end() + "}");

			// 매칭된 그룹들 출력
			// group(int group), start(int group), end(int group)
			System.out
					.println("\t group(0) : " + matcher.group(0) + "{" + matcher.start(0) + "~" + matcher.end(0) + "}");
			System.out
					.println("\t group(1) : " + matcher.group(1) + "{" + matcher.start(1) + "~" + matcher.end(1) + "}");
			System.out
					.println("\t group(2) : " + matcher.group(2) + "{" + matcher.start(2) + "~" + matcher.end(2) + "}");
			// group(0) : 그룹에서 0은 항상 전체 문자열 !!

		} // end while

		// 도우미 함수를 사용해보자
		System.out.println();
		regExpTest("My....", "-My1234-");
		regExpTest("(My)(....)", "-My1234-");
		regExpTest("My....", input);
		regExpTest("(My)(....)", input);
		regExpTest("ABC...DEF", input);

		System.out.println("프로그램 종료");
	} // end main

	// 도우미 함수
	public static void regExpTest(String regex, String input) {
		System.out.println("------------[정규표현식 매칭 테스트]------------");
		System.out.println("정규표현식 : " + regex);
		System.out.println("입력문자열 : " + input);

		Matcher matcher = Pattern.compile(regex).matcher(input);
		int groupCount = matcher.groupCount(); // 그룹 갯수 출력

		int matchCount = 0; // 매칭된 문자열의 갯수 매칭된 패턴의 갯수
		while (matcher.find()) {
			matchCount++; // 매칭된 패턴 또는 문자열이 발견됬으면 1 증가 !
			System.out.println("	매치" + matchCount + ": " + matcher.group() + "  {" + matcher.start() + "~"
					+ matcher.end() + "}");

			// 그룹이 있었다면 그룹별로 출력
			// 그룹 설정이 되어있지 않으면 0을 리턴한다.
			if (groupCount > 0) { // 그룹이 있다는 뜻
				for (int i = 0; i <= groupCount; i++) { // 그룹이 0이 아닌 1부터 시작되기 때문에
					System.out.printf("\t group(%d) : %s {%d~%d}\n", i, matcher.group(i), matcher.start(i),
							matcher.end(i));
				}
			}

		} // end while

		if (matchCount == 0)
			System.out.println("  X매칭 없슴X");

		System.out.println();

	}

} // end class
