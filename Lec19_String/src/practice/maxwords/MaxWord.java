package practice.maxwords;

import java.util.Scanner;
import java.util.StringTokenizer;

/* MaxWrod
	여러문장으로 구성된 문자열을 입력받은뒤 
	문자열에서 가장 단어의 개수가 많은 문장을 찾아서, 
	그 문장과 문장의 단어의 개수를 출력
	'문장'의 구분은  .(마침표) !(느낌표) ?(물음표) 로 한다.
	'단어'구분은 '공백' 으로 한다
	
	입력예]
	We test coders. Give us a try. Can you make it out? It's awesome.
	
	출력예]
	5개
	Can you make it out
 */
public class MaxWord {

	// TODO : 필요한 메소드 있으면 추가 작성

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" 영 어 문 장 을  입 력  해 주 세 요 ");

		String str = sc.nextLine();
		String [] data1 = str.split(".!?");
		int cnt = 0; // 단어의 갯수
//		str = str.trim();
		boolean EmptyCheck = false; // 공백으로만 이루어져 있는지 검사
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ' && str.charAt(i - 1) != ' ') {
				// 띄어쓰기(공백)을 찾고 띄어쓰기 한 바로 전 문자가 빈칸이 아니면 
				cnt++; // 개수 세기 
			} else
				EmptyCheck = true; // 공백으로만 이루져있으면 개수 세지 않는다. 

		} // end for
		if (EmptyCheck) {
			System.out.println(cnt + 1);
		} else
			System.out.println(cnt);

		sc.close();
	} // end main
	
	public static void cntWords() {
		
	}
} // end class
