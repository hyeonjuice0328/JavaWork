package com.lec.java.datetime01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/*
 * 날짜를 다루기 위해 자바에선 java.util.Date 클래스 제공   JDK 1.0 부터..
 * 이후 보완하여 java.util.Calendar 등장   JDK 1.1 부터..
 * java.time 패키지 제공 JDK 1.8 (Java8)부터
 * 
 * 지금은 java.time 패키지만으로 충분하긴 하나.. 
 * 오랜시간 Date, Calendar 를 사용하여 만들었으므로 이 또한 알긴 알아야 한다
 * 
 */
public class DateTime01Main {

	public static void main(String[] args) throws Exception{
		System.out.println("Date객체로 날짜 다루기");
		System.out.println();
		// 현재 날짜 얻어오기,  생성자가 현재 날짜, 시간을 얻어온다.
		
		System.out.println("1. Date 의 toString() 사용한 출력");
		Date now = new Date();
		String strNow = now.toString();
		System.out.println(strNow);
		
		System.out.println();
		System.out.println("2. Date 의 get..()을 사용한 출력");
		// Date객체의 대부분의 메소드들은 현재 deprecated(앞으로는 이것을 사용하지 않을겁니다.)줄이 쳐진다. 됨.
		int year = now.getYear() + 1900; // 연도는 1900년 이후 경과 년도 
		int month = now.getMonth() + 1; // 베이스가 0 이라 0부터 시작한다.
		int day = now.getDate();
		int hours = now.getHours();
		int minute = now.getMinutes();
		int second = now.getSeconds();
		System.out.println(year + "년 " + month + "월 " + day + "일 " +
							hours + "시 " + minute + "분 " + second + "초");
		
		System.out.println();
		System.out.println("3. SimpleDateFormat 사용한 출력");
		SimpleDateFormat fmt = 
				new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초"); //format객체 정의 내가 원하는 표현형식을 입력 
		String strnow2 = fmt.format(now);
		System.out.println(strnow2);
		System.out.println();
		
		
		// yyyy-MM-dd hh:mm:ss 형식 출력
		// 포맷에 사용되는 문자열 종류 : 자바의 정석 교재 p544
		// H: 시간 (0~23),  h : 시간 (1~12)
		// TODO
		SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String strnow3 = fmt2.format(now);
		System.out.println(strnow3);
		
		// ※ 현재 Date() 객체는 생성자를 제외하고는 거의다 deprecated 되어 있다.
		
		System.out.println();
		System.out.println("Date 테스트");
		long baseTime = System.currentTimeMillis();  // 현재 시각을 ms 로 리턴 1/1000 long타입을 리턴
		//System.out.println(baseTime); // 1970-01-01 00:00:00 UTC 기준으로 경과된 ms
		long curTime = baseTime + 2000;
		
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("YYYY:MM:dd-HH:mm:ss", Locale.KOREA);
		String mTime = mSimpleDateFormat.format(new Date(baseTime));
		String mTime2 = mSimpleDateFormat.format(new Date(curTime));
		System.out.println(mTime);
		System.out.println(mTime2);
		
		
		// 문자열을 Date 타입으로 파싱하기 //
		System.out.println();
		System.out.println("문자열 -> Date");
		String oldstring = "2018-08-16 14:21:52.3";
		/*문자열을 Date타입으로 변환하는 방법 */
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S", Locale.KOREA).parse(oldstring);
		System.out.println(date);
		
		// 경과시간 체크하기
		System.out.println();
		System.out.println("경과시간");
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			Thread.sleep(1000); //1초간 딜레이
		}
		long end = System.currentTimeMillis();
		long lapTime = end - start;
		System.out.println("경과시간" + lapTime + " ms");
		
		// nanosec : 10E-9초
		System.out.println();
		start = System.nanoTime();
		// ....
		end = System.nanoTime();
		
		System.out.println();
		System.out.println("millisec -> time");
		long durationInMillis = 1000003;
		long millis = durationInMillis % 1000;
		long sec = (durationInMillis / 1000) % 60;
		long min = (durationInMillis / (1000 * 60)) % 60;
		long hr = (durationInMillis / (1000 * 60 * 60)) % 24;
		
		String time = String.format("%02d:%02d:%02d:.%03d", hr, min, sec, millis);
		System.out.println(time);
		
	} // end main()

} // end class
