package com.lec.java.access03;

import com.lec.java.access04.TestPublic2;

// 다른 패키지의 (default) 클래스는 import 가 불가하다! 
//import com.lec.java.access04.MyDefault2; 에러 메세지 : not visible
// 다른 패키지 안에 있는 같은 이름의 클래스는 동시 사용이 불가하다. 중복 import 가 불가하다. 
// 꼭 사용하고 싶다면 fullname을 사용해야 한다. 
// 클래스의 접근 권한 수식어: public, (default)
// 1. public class: 어디에서나 인스턴스 생성이 가능한 클래스
//   (주의) public 클래스의 이름은 .java 파일 이름과 반드시 같아야 함
// 2. (default) class: 같은 패키지에 있는 클래스들에서만 인스턴스 생성이 가능

public class Access03Main {

	public static void main(String[] args) {
		System.out.println("public, default 클래스");
		
		TestPublic t1 = new TestPublic();
		MyDefault t2 = new MyDefault(); // 같은 패키지에 있는 클래스에서는 인스턴스 생성(사용) 가능 
		// 다른 패키지에 있는 public 클래스 사용하려면 import
		// ---> 인스턴스 생성 가능 
		TestPublic2 t3 = new TestPublic2();
		
		//다른 패키지에 있는 default 클래스 
		// ---> 인스턴스 생성 불가  에러메세지 : cannot be resolved
//		MyDefault2 t4; 
		
		//다른 패키지의 클래스와 동인 이름의 클래스가 충돌한다면 ? fullname을 사용
		com.lec.java.access04.TestPublic t11 = 
				new com.lec.java.access04.TestPublic();
		
	} // end main()

} // end class Access05Main










