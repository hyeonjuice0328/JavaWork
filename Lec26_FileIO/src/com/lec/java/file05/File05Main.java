package com.lec.java.file05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* Buffered Stream + Buffer 예제
Program <=== FilterInputStream <=== InputStream <=== Source
					↓ 상속					↓ 상속
Program <=== BufferedInputStream <=== FileInputStream <=== File

Program ===> FilterOutputStream ===> OutputStream ===> Source
					↓ 상속					↓ 상속
Program ===> BufferedOutputStream ===> FileOutputStream ===> File

java.io.InputStream
 |__ java.io.FilterInputStream
      |__ java.io.BufferedInputStream

java.io.OutputStream
 |__ java.io.FilterOutputStream
      |__ java.io.BufferedOutputStream
*/

public class File05Main {

	public static void main(String[] args) {
		System.out.println("Buffered Stream + Buffer");
		
		// TODO:
		// file03 패키지 참조
		// try with resource 구문으로 작성
		// in.read(buff) --> bin.read(buff);
		// out.write( , , ) --> bout.write( , , ); 사용
		// finally 필요 없슴
		
		try (	InputStream in = new FileInputStream("temp/big_text.txt");
				BufferedInputStream bin = new BufferedInputStream(in); //장착
				
				OutputStream out = new FileOutputStream("temp/copy_big_text.txt");
				BufferedOutputStream bout = new BufferedOutputStream(out); //장착
				){
			//finally 를 하지 않아도 in 과 out은 자동으로 close 가 된다. 
			byte [] buff = new byte[1024]; // 사용자가 직접 버퍼 사용 준비 
			int lengthRead = 0; // 버퍼에 읽어들인 바이트 수 
			int byteCopied = 0; 
			
			long startTime = System.currentTimeMillis();
			// 이제 정보 읽기 최대 1024바이트씩 읽어들이고 쓰기가 가능하다. 
			
			// 파일 복사 
			while(true) {
				//데이터 읽기 
				// 매개변수로 주어진 byte[] 배열의 길이 만큼 read한다.
				// 실제 읽어 들인 데이터는 매개변수 byte[] 에 담김.
				// 읽어들인 바이트 리턴,  읽어들인게 없으면 -1 리턴.
				lengthRead = bin.read(buff);// 곧바로 매게변수를 읽는다. read는 읽어들인 바이트 수만큼 리턴한다. 
				if(lengthRead == -1 )break; // 더 이상 읽어들일게 없으니까 
			
				//데이터 쓰기 
				bout.write(buff, 0, lengthRead); //직전에 읽어들인 데이터 만큼 write
			    //파일에 1024바이트가 모두 다 차있지 않을 수가 있다.
				byteCopied += lengthRead;
			}		
			long endTime = System.currentTimeMillis();
			long elapsedTime = endTime - startTime;
			
			System.out.println("전제 복사한 바이트 : " + byteCopied);
			System.out.println("경과 시간(ms) : " + elapsedTime);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n프로그램 종료");

	} // end main()

} // end class File05Main
















