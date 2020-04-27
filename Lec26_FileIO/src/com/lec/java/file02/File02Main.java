package com.lec.java.file02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* FileIO
 Program <=== InputStream <=== Source
 Program ===> OutputStream ===> Source
 Program <=== FileInputStream <=== File
 Program ===> FileOutputStream ===> File

 java.io.InputStream
  |__ java.io.FileInputStream: 파일로부터 데이터를 읽어오는 통로
 java.io.OutputStream
  |__ java.io.FileOutputStream: 파일로 데이터를 쓰는 통로
*/

public class File02Main {

	public static void main(String[] args) {
		System.out.println("File IO");

		InputStream in = null; // InputStream 변수 선언
		OutputStream out = null; // OutputStream 변수 선언
		
		try {
			//FileInputStream 인스턴스 생성
			in = new FileInputStream("temp/big_text.txt"); // 입력할때
			
			//FileOutputStream 인스턴스 생성
			out = new FileOutputStream("temp/copy_big_text.txt"); //출력할때
			                          //위 파일이 없으면 새로 생성 있으면 기존 파일 삭제 후 새로 생성
			int dataRead;
			int bytesCopied = 0; // 복사한 파일의 크기 확인하기 
			
			long startTime = System.currentTimeMillis(); // 현재 시간 저장 (while문이 시작하는 시간) 
			// 파일 복사 : 읽기 -> 쓰기 
			//temp/big_text.txt 파일의 사이즈가 얼마정도인지 알수 없으니 우선 끝까지 읽는다. 
			while(true) { // 무한반복
				// 데이터 읽기: InputStream에 있는 read() 메소드 사용
				// read()는 InputStream 으로부터 
				// 1byte 씩 읽어서 int(4byte) 에 담아 리턴한다
				// [ ... ][ ... ][ ... ][ 1byte ] 부가적인 정보를 담기 위해서 4바이트로 받는다. 
				dataRead = in.read(); // dateRead 계속 읽어들인다. 무한반복
				if(dataRead == -1) { // 더 이상 읽은 값(정보) 가 없으면 read()는 -1 리턴
					break;
				} // 읽기 완료!!!
				
				// 데이터 쓰기: OutputStream에 있는 write() 메소드 사용
				// write() 는 
				// int(4byte)에 1byte씩 담아 OutputStream에 쓴다
				// [ ... ][ ... ][ ... ][ 1byte ]
				out.write(dataRead); // dataRead 에 담긴 값(정보)를 쓰겠습니다. 
				bytesCopied++; //1바이트씩 복사될때마다 1씩 증가하게해서 데이터의 크기 확인!
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
				if(out != null) out.close(); 
				// if(out != null) out이 null이면 nullPointException output 사용했기 때문에 close
				if(in != null) in.close(); 
				// if(in != null) in이 null이면 nullPointException intput 사용했기 때문에 close
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class

