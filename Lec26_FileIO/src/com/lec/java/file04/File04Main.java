package com.lec.java.file04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* 보조스트림 (filter stream)
Program <=== FilterInputStream <=== InputStream <=== Source
					↓ 상속					↓ 상속
Program <=== BufferedInputStream <=== FileInputStream <=== File
			// 내부적으로 Buffer를 운영하고 있다. 
Program ===> FilterOutputStream ===> OutputStream ===> Source
					↓ 상속					↓ 상속
Program ===> BufferedOutputStream ===> FileOutputStream ===> File
			// 내부적으로 Buffer를 운영하고 있다. 
java.io.InputStream
 |__ java.io.FilterInputStream
      |__ java.io.BufferedInputStream

java.io.OutputStream
 |__ java.io.FilterOutputStream
      |__ java.io.BufferedOutputStream

참고 ) 보조스트림 (filter stream)
보조스트림(filter stream) 이란 다른 스트림과 연결되어 여러가지 편리한 기능을 제공해주는 스트림
*/


public class File04Main {

	public static void main(String[] args) {
		System.out.println("BufferedInputStream, BufferedOutputStream");

		InputStream in = null; // InputStream 변수 선언
		BufferedInputStream bin = null; //자체적으로 buffer를 제공하는 보조 stream 
		OutputStream out = null; // OutputStream 변수 선언
		BufferedOutputStream bout = null; //자체적으로 buffer를 제공하는 보조 stream
		
		
		try {
			//FileInputStream 인스턴스 생성
			in = new FileInputStream("temp/big_text.txt"); // 입력할때
			bin = new BufferedInputStream(in); // 기존에 있던 inputstream 을 받아서 bufferedinputstream을 장착!!
			
			//FileOutputStream 인스턴스 생성
			out = new FileOutputStream("temp/copy_big_text.txt"); //출력할때
			bout = new BufferedOutputStream(out);
			                          
			int dataRead;
			int bytesCopied = 0; // 복사한 파일의 크기 확인하기 
			
			long startTime = System.currentTimeMillis(); // 현재 시간 저장 (while문이 시작하는 시간) 
			// 파일 복사 : 읽기 -> 쓰기  
			while(true) { // 무한반복
				dataRead = bin.read(); 
				if(dataRead == -1) { // 더 이상 읽은 값(정보) 가 없으면 read()는 -1 리턴
					break;
				} // 읽기 완료!!!
				
				bout.write(dataRead); 
				bytesCopied++; 
			}
			long endTime = System.currentTimeMillis(); // while문이 끝나는 시간 체크 
			long elapsedTime = endTime - startTime; // 경과시간 
			
			System.out.println("읽고 쓴 바이트 : " + bytesCopied);
			System.out.println("경과 시간(ms) : " + elapsedTime);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch ( IOException e) {
			e.printStackTrace();
		} finally {
			// 리소스 해제 !!! 중요 꼭 해주어야 한다. 
			try {
				if(bout != null) out.close(); 
				if(bin != null) in.close(); 
				// bin을 close 하면 bin을 만든 in도 같이 close 된다. 
				// bout을 close 하면 bin을 만든 out도 같이 close 된다. 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class














