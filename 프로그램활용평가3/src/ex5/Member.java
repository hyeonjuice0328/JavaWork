package ex5;
/*
문제5]
회원 객체를 Member 라는 이름의 자바 클래스로 정의하고자 합니다   
다음과 같은 ‘속성’ 을 가진 클래스를 정의하고, 
기본생성자와 매개변수를 받는 생성자와 getter & setter 를 순서대로 클래스에 작성하세요  
[10점]

멤버변수 명  	객체의 속성
───────────────────────────────
name 		회원 이름  문자열 타입
id			회원 아이디 문자열 타입
pw			회원 아이디 문자열 타입

*/

public class Member {
	private String name;
	private String id;
	private String pw;
	
	public Member() {
		super();	
	}

	public Member(String name, String id, String pw) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
}
