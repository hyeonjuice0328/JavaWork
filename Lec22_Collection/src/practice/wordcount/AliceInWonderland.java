package practice.wordcount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/* 1] 문서(문자열) 안의 단어의 빈도수를 계수해서 출력하기
 * 	- 대소문자 구분하지 않기 :   The 와 the 는 같은 단어
 *  - 2글자 이상만 계수하기
 *  - 구두점/기호 ",.\"\'`!?;:-()" 잘라내기
 *  - 공백 짤라내기 -> trim()
 * ex) .........> Collecion11Main참고 
 * 	an : 234번
 * 	the : 314번
 * ...
 * 
 * hint]
 * 	split("\\s+")  --> String[]   
 * 	--> StringTokenizer  (혹은 정규표현식)
 *  	  --> HashMap<String, Integer>   <단어, 빈도수>  사용
 * ───────────────────────────────────────────────────────────    
 * 2] 빈도수 내림차순으로 정렬하여 출력하기
 * 	ex)
 *	1 the:113개
 *	2 she:95개
 *	3 to:85개
 *	...   
 *
 * hint]
 * 	Comparable<> 이나 Comparator<> 적용
 */

// TODO : 필요한 객체들 작성
// 필요한 객체들 
// hint> 빈도수 담을 객체, Comparator<> ..

public class AliceInWonderland {

	public static void main(String[] args) {
		System.out.println("실습: 단어 발생 빈도");

		String[] words = C.ALICE30.trim().toLowerCase().split("\\W+|\\_|\\t|\\n|\\d+|\\s+|\\r");
		// '|' 로 구분 하고 \\W:알파벳이나 숫자를 제외한 문자  \\_|
		//\\t|\\n|\\d:[0-9]숫자\\s+:공백문자 ,+:앞문자가1개이상존재할수있음\\r
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		List<word> word = new ArrayList<word>();
		//발생빈도 
		for (int i = 0; i < words.length; i++) {
			Integer v = hmap.get(word[i]); // word[i] 가 key
			if(word[i].length() > 1) { //2글자 이상
				if(v==null) {
					hmap.put(word[i], 1);
				} else {
					hmap.put(word[i], v+1);
				}
			}
		}
		
			
		}
		

		System.out.println("\n프로그램 종료");

	} // end main()

	static void printFreq(String[] words) {
				// HashMap 인스턴스 생성
				
				// Key - String 타입 , Value - Integer 타입
		
		// 발생빈도 작성
		for (int i = 0; i < words.length; i++) {
			Integer s = hmap.get(words[i]); // words[i]가 Key - String type

			if (s == null) {
				hmap.put(words[i], 1);
			} else
				hmap.put(words[i], s + 1);}

		// 결과 출력
		for (Map.Entry<String, Integer> e : hmap.entrySet()) {
			
			System.out.println(e.getKey() + " : " + e.getValue() + "개");}
//		System.out.println(hmap);
		
		// TODO Auto-generated method stub

	}

} // end class
