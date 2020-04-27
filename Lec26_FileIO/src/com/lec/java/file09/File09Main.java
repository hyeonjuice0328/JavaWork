package com.lec.java.file09;

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

import com.lec.java.file08.Member;

// Object Filter Stream + Collection

// Program <=== ObjectInputStream <=== FileInputStream <=== File
// Program ===> ObjectOutputStream ===> FileOutputStream ===> File

// ArrayList<> 와 같은 Collection 에서,
// 모든 데이터들이 Serializable 되어 있으면 ObjectInputStream / ObjectOutputStream 으로
// read/write 가능.

public class File09Main {
	
	public static final String FILEPATH  = "temp/member2.dat";

	public static void main(String[] args) {
		System.out.println("Object Filter Stream");

		//멤버 데이터 저장
				try(
						OutputStream out = new FileOutputStream(FILEPATH);
						ObjectOutputStream oout = new ObjectOutputStream(out); // 장착

						InputStream in = new FileInputStream(FILEPATH);
						ObjectInputStream oin = new ObjectInputStream(in); // 장착
						
						) {
					
					ArrayList<Member> list = new ArrayList<Member>();
					
					Member m1 = new Member("root", "root1234");
					Member m2 = new Member("guest","guest");
					Member m3 = new Member("damin", "admin123456");
					//3개의 멤버 객체 저장
					
					//list에 추가 
					list.add(m1);
					list.add(m2);
					list.add(m3);
					
					oout.writeObject(list); // list를 한번에 저장! 
					
					//저장한것을 다시 읽어오기 
					list = null; // 제대로 잘 읽어오는지 확인을 위해 null로 초기화
					
					list = (ArrayList<Member>)oin.readObject(); // list에 담으려면 형변환 !! 꼭
					for(Member m : list) {
						m.displayInfo();
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

} // end class File08Main
















