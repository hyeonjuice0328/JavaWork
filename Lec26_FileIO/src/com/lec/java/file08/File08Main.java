package com.lec.java.file08;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/* Object Filter Stream
 Program <=== ObjectInputStream <=== FileInputStream <=== File
 Program ===> ObjectOutputStream ===> FileOutputStream ===> File

java.lang.Object
 └─ java.io.OutputStream
    └─ java.io.ObjectOutputStream
 
java.lang.Object
 └─ java.io.InputStream
     └─ java.io.ObjectInputStream


 Object Stream: 객체의 입출력을 위한 스트림
 사용법은 다른 Filter Stream(Buffered I/O, Data I/O)과 비슷
 Object 스트림의 입출력 대상이 되는 클래스는 Serializable 라는 인터페이스를 구현
 클래스의 일부 멤버 변수를 직렬화(Serialization)의 대상에서 제외시키려면,
 transient 키워드를 사용
*/
public class File08Main {
	
	public static final String FILEPATH  = "temp/member.dat";

	public static void main(String[] args) {
		System.out.println("Object Filter Stream");
		

		//멤버 데이터 저장
		try(
				OutputStream out = new FileOutputStream(FILEPATH);
				ObjectOutputStream oout = new ObjectOutputStream(out); // 장착

				InputStream in = new FileInputStream(FILEPATH);
				ObjectInputStream oin = new ObjectInputStream(in); // 장착
				
				) {
			Member m1 = new Member("root", "root1234");
			Member m2 = new Member("guest","guest");
			Member m3 = new Member("damin", "admin123456");
			//3개의 멤버 객체 저장
			
			oout.writeObject(m1);
			oout.writeObject(m2);
			oout.writeObject(m3);
			
			//데이터 읽어들이기 
			//파일에서 Object 타입으로 읽기 
			Member dataRead;
			
			//읽는 방법 1: 매번 readObject() 호출
//			dataRead = (Member)oin.readObject();
//			dataRead.displayInfo();
//			dataRead = (Member)oin.readObject();
//			dataRead.displayInfo();
//			dataRead = (Member)oin.readObject();
//			dataRead.displayInfo();
			
			//읽는 방법2: 무한 루프로 readObject() 호출
			// 데이터(값)이 모두 실행되고 남은게 없으면 -1 리턴이 되는게 아니라 EOFException이 발생해서 예외처리로  잡기 
			// EOFException : End Of File
			
			while(true) {
				dataRead = (Member)oin.readObject();
				dataRead.displayInfo(); 
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(EOFException e) { // EOFException 는 IOException을 상속 그래서 먼저 사용 
			System.out.println("파일 끝까지 읽었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class
