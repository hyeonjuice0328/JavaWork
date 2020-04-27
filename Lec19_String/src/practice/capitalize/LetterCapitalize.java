package practice.capitalize;

import java.util.Scanner;

/* LetterCapitalize
 * 	문장을 입력하고,  단어의 앞 문자를 대문자로 만들어 출력하기를 반복하다가
 *  quit 을 입력 받으면 종료하기
 * 
 * 	[입력예]
 * 		hello my world
 *  [출력예]
 * 		Hello My World  
 */

public class LetterCapitalize {

	// TODO : 필요한 메소드 있으면 추가 작성

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s;
		String[] w;
		while (true) {
			s = sc.nextLine();
			if (s.trim().equalsIgnoreCase("quit"))
				break;

			s = s.toLowerCase(); // 일단 소문자로 변환
			w = s.split("\\s+"); // 공백 단위로 쪼개기
//			System.out.print(s); // Hello java > Hello 만 출력된다. 이유가 뭐지..? - sc.next(); 가 아니라 sc.nextLine(); 사용하기!

			for (String word : w) {
				// 앞글자만 떼내기
				String firstLetter = word.substring(0, 1).toUpperCase();
				String rest = word.substring(1); // 나머지 문자열
				System.out.print(firstLetter + rest + " "); // 최종 출력
			}
			System.out.println();
		}
		sc.close();
	} // end main()
} // end class
