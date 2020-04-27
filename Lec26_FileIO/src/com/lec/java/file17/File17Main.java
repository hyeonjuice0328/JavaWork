package com.lec.java.file17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* HTML 데이터, 웹데이터 (텍스트)
 * Java 에서 웹 연결을 위한 객체 두가지
 * 1.	URL : 웹 상의 주소, 
 * 2.	HttpURLConnection : 웹연결
 * 		URLConnection
 * 		 └─ HttpURLConnection
 * 
 * 	java.io.Reader    프로그램이 '문자 단위' 데이터를 읽어들이는(read) 통로
 * 		├─ java.io.InputStreamReader    // 스트림 기반의 reader
 * 		└─ java.io.BufferedReader 		// 문자(character) 기반 reader
 */

public class File17Main {

	public static void main(String[] args) {
		System.out.println("웹데이터 가져오기(텍스트)");

		String url = "https://www.naver.com/srchrank?frm=main&ag=all&gr=0&ma=-2&si=-2&en=-2&sp=-2";
		
		StringBuffer sb = readFromUrl(url);
		System.out.println(sb);
		System.out.println(sb.toString().substring(0, 200));
		

		System.out.println("\n프로그램 종료");
	} // end main()

	/**
	 * 
	 * @param urlAddress : 주어진 url주소
	 * @return 서버로부터 받은 텍스트데이터(HTML) 리턴
	 */
	public static StringBuffer readFromUrl(String urlAddress) {
		// StringBuffer에 urlAddress를 담아서 return

		StringBuffer sb = new StringBuffer(); // response 받은 데이터 담을 객체
		URL url = null; // java.net.URL
		HttpURLConnection conn = null; // java.net.HttpURLConnection

		InputStream in = null;
		InputStreamReader reader = null; // byte 스트림 --> 문자기반 Reader
		BufferedReader br = null; // 버퍼 달려있는 필터

		char[] buf = new char[512]; // 문자용 버퍼

		// BufferedReader <- InputStreamReader <- InputStream <- HttpURLConnection

		try {
			url = new URL(urlAddress);
			conn = (HttpURLConnection) url.openConnection(); // Connection 객체 생성
			// 해당 url 과 connection이 안잡힐 수도 있기 때문에 조건문으로 .. 조건넣기
			// 서로 연결이 안되면 null을 return 하기 때문에 
			// 아래 if 조건은 conn 이 null 이 아닌 경우에만 계속 실행을 진행한다. 
			if (conn != null) {
				conn.setConnectTimeout(2000); // 2초 이내에 연결이 수립되지 않으면 
				                              // java.net.SocketTimeOutException 발생
											  // 마냥 연결되기를 한없이 기다리다가 프로그램이 나가버릴 수가 있기 때문에 
				conn.setRequestMethod("GET"); // GET 방식 request
				// "GET", "POST" ...

				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
				// 인코딩을 하는데 String url = "https://www.daum.net"; 이러한 문자열로 하겠다 라는 의미
				conn.setUseCaches(false); // 캐시 사용 하지 않겠다.

				// request start
				System.out.println("request 시작: " + urlAddress);
				conn.connect(); // request 발생 --> 이후 response 받을때까지 delay
				System.out.println("response 완료");

				// response 받은 후 그 안에 담겨 있는 코드값을 확인 -> 200 이라는 코드값을 가지고 왔을 때만 정상 !!!
				int responseCode = conn.getResponseCode();
				System.out.println("response code : " + responseCode);
				// 참조 : https://developer.mozilla.org/ko/docs/Web/HTTP/Status
				if (responseCode == HttpURLConnection.HTTP_OK) { // 정상인 경우=HttpURLConnection.HTTP_OK=200
						
					in = conn.getInputStream(); // conn 에서 InputStream 뽑아서 in 에 저장 
					                            //InputStream <- HttpURLConnection
					reader = new InputStreamReader(in, "utf-8"); //  InputStreamReader <- InputStream 
					br = new BufferedReader(reader); // BufferedReader <- InputStreamReader
					
					int cnt; // 읽은 글자의 갯수 
					while((cnt = br.read(buf)) != -1) { //buf에 담긴 내용을 
						sb.append(buf, 0, cnt); // response 받은 텍스트를 StringBuffer 에 추가
					//	sb.append(str, offset, len);
					}
					
				} else {
					System.out.println("response fail");
					return null;
				}

			} else {
				System.out.println("conn null");
				return null;
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(conn != null)  conn.disconnect();  // 작업 끝나고 Connection 해제
		}

		return sb;

	}

} // end class
