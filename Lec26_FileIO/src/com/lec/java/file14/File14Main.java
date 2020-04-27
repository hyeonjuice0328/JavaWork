package com.lec.java.file14;

public class File14Main {

	public static void main(String[] args) {
		System.out.println("시스템 정보 확인");
		
		System.out.println(System.getProperty("os.arch"));
		//> 결과 amd64 : 64bit 
		System.out.println(System.getProperty("os.version"));
		// JRE 경로: Java Runtime Environment(JVM)
		System.out.println();
		//> 결과 C:\Program Files\Java\jre1.8.0_151
		System.out.println(System.getProperty("java.home"));
		//
		System.out.println(System.getProperty("java.version"));
		
		System.out.println();
		// current working directory
		System.out.println(System.getProperty("user.dir"));
		
		// user home directory("내 문서"가 있는 폴더)
		System.out.println(System.getProperty("user.home"));
		
		System.out.println();
		System.out.println(System.getProperty("file.separator"));

		System.out.println();
		System.out.println(System.getProperty("os.name"));
		//getProperty 의 키값 

		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class














