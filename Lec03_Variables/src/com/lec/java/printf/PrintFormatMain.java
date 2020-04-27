package com.lec.java.printf;

/* 서식화된 문자열 (formatted string)
 *  ● 화면에 출력할때는 -> printf()
 *    
 *    printf("서식문자열", 값1, 값2....)
 *    
 *  ● 문자열(String)으로 만들때는 -> String.format()
 *       	
 *    String.format("서식문자열", 값1, 값2....)
 *    
 *  ● format specifier (서식 지정자)
 *  	%d  :  십진수 정수로 출력
 *  	%f  :  실수 출력
 *  	%s  :  문자열 출력
 *  	%c  :  '문자하나' 출력
 *  	%x  :  16진수 정수로 출력
 *  	%%  :  % 출력
 *  
 *  printf와 String.format은 서식문자 를 사용하기 위한 방법이지만 printf는 화면출력용이고 String.format은 값은 담아놓는데 사용한다. 
*/

public class PrintFormatMain {

	public static void main(String[] args) {
		System.out.println("서식화된 출력 : printf(), String.format()");
		
		double pi = Math.PI; //원주율 값
		System.out.println(pi);
		
		//printf : print with format
		//printf("서식문자열", 값1, 값2, ...)
		//서식문자열 안에는 %로 시작하는 서식지정자들(format specifier)이 있다.
		System.out.printf("원주율 %f\n", pi);
		System.out.printf("원주율 %.4f\n", pi);
		
		int age = 10;
		short grade = 3;
		
		System.out.printf("나이는 %d살입니다. 학년은 %d학년 입니다.\n", age, grade);
		
		//소수점 이하 제한
		double height = 190.4;
		System.out.printf("저는 %d살입니다. 키는 %fcm입니다\n", age, height);
		System.out.printf("저는 %d살입니다. 키는 %.1fcm입니다\n", age, height);
		
		//출력폭 지정, 좌우 정렬, 우측정렬(기본값), -값붙이면 좌측정렬
		System.out.printf("|%d|%d|%d|\n", 1000,200,30000);
		System.out.printf("|%5d|%5d|%5d|\n", 100,200,30000);
		System.out.printf("|%-5d|%-5d|%-5d|\n", 100,200,30000);
		
		System.out.printf("제 이름은 [%10s]입니다. 혈액형은 %c형 입니다.\n", "봉준호", 'B');
		
		// % 출력
		double rate = 134423.0 / 345678.0;
		System.out.printf("합격률은 %.1f%%입니다.\n", rate);
		
		//숫자의 패딩 
		System.out.printf("|%05d|%05d|%05d|\n", 100,200,300);
		
		//format 문자열을 따로 설정(변수에 담아서)해서 사용할수 있다. 
		String fmt = "주소: %s, 우편번호[%05d]";
		System.out.printf(fmt  + "\n", "서울", 12345);
		System.out.printf(fmt  + "\n", "광주", 157);
		System.out.printf(fmt  + "\n", "부산", 2254);
		
		System.out.println();

		//String.format() 화면출력이 아닌 String 값이라고 보면된다.
		String.format("합격률은 %.1f%%입니다." , rate);
		String result = String.format("합격률은 %.1f%%입니다." , rate);
		System.out.println(result);
		
		
	}//end main()

}//end class




