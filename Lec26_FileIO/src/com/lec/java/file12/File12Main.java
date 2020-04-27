package com.lec.java.file12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 버퍼사용 문자입출력 : BufferedReader, BufferedWriter
 * 
 * java.lang.Object
 *  └─ java.io.Reader
 *      └─ java.io.BufferedReader
 *       
 * java.lang.Object
 *  └─ java.io.Writer
 *      └─ java.io.BufferedWriter
 *      
 * ★ 문자기반 출력시 꼭 끝에 flush() 해주자 ★     
 *             
*/

/*
 * txt 는 utf-8 로 인코딩 , 영문 텍스트
 */
public class File12Main {
	
	private static final String BIG_TEXT = "temp/big_eng.txt"; 
	
	public static void main(String[] args) {
		System.out.println("FileReader / FileWriter");
		
		FileWriter fw = null;
		FileReader fr = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		int charRead = 0;
		int charsCopied = 0;
		long startTime, endTime, elapsedTime;
		
		//read 와 writer 먼저 사용 
		System.out.println("FileReader/Writer만 사용");
		try {
			fr = new FileReader(BIG_TEXT);
			fw = new FileWriter("temp/bid_eng_copy1.txt");
			
			startTime = System.currentTimeMillis();
			//read()는 한글자씩 읽어서 리턴한다. 더 이상 읽을 것이 없으면 -1리턴 
			while((charRead = fr.read()) != -1) { //더이상 읽을 것이 없는 동안까지만 무한반복! 
				fw.write(charRead); // fr(BIG_TEXT) 에서 한글자씩 읽어와서 charRead에 넣고 ! 그 후에 fw(temp/bid_eng_copy1.txt)에 다가 한글자씩 적는다.
				charsCopied++;
			}
			fw.flush();
			endTime = System.currentTimeMillis();
			elapsedTime = endTime - startTime;
			System.out.println("읽고 쓴 문자 수 : " + charsCopied);
			System.out.println("경과 시간 : " + elapsedTime);
			//----------------------------------------------------------
			fw.close(); //하면 아래에서 다시 시작할 수 있다. 재사용 가능 
			fr.close();
			//----------------------------------------------------------
			
			System.out.println();
			System.out.println("BufferedReader/Writer + 버퍼 사용");
			fr = new FileReader(BIG_TEXT);
			fw = new FileWriter("temp/bid_eng_copy2.txt");
			br = new BufferedReader(fr); //장착
			bw = new BufferedWriter(fw); //장착
			
			char [] buf = new char[1024];
			//한꺼번에 여러 글자 읽어 들일것이기 때문에 
			
			int charsRead = 0; // 버퍼에 몇글자를 읽어들였는지 
			charsCopied = 0; // 초기화
			
			startTime = System.currentTimeMillis();
			//TODO
			while((charsRead = br.read(buf)) != -1) {
				bw.write(buf, 0, charsRead);
				charsCopied += charRead;
			}
			endTime = System.currentTimeMillis();
			elapsedTime = endTime - startTime;
			System.out.println("읽고 쓴 문자 수 : " + charsCopied);
			System.out.println("경과 시간 : " + elapsedTime);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if( bw != null) bw.close();
				if( br != null) br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\n프로그램 종료");		
		
	} // end main()
} // end class
