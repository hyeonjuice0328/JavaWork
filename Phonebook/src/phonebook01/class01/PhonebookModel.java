package phonebook01.class01;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PhonebookModel {
	//멤버변수
	private int uid;         // uid : unique id 전화번호부 데이터에 고유한 식별 
	private String name;
	private String phoneNum;
	private String email;
	private Date regDate;	//등록일시 
	
	//기본생성자
	public PhonebookModel() { // 기본 초기화 값은 null이고 이를 빈문자열 형식으로 변경했다. 
		this.name = "";
		this.phoneNum = "";
		this.email = "";
		this.regDate = new Date(); // 생성되는 그 시간 
	}
	//메개변수 생성자 

	public PhonebookModel(String name, String phoneNum, String email) {
		this(); //생성자 위임 (위의 기본생성자 기본적으로 실행)
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
	}

	//생성자
	public PhonebookModel(int uid, String name, String phoneNum, String email, Date regDate) {
		super();
		this.uid = uid;
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
		this.regDate = regDate;
	}
	
	//getter setter (uid, name, phoneNum, email, regDate)

	
	public int getUid() {
		return uid;
	}
	
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegDate() {
		return regDate;
	}
	
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	//toString() 오버라이드   %3d-3자리 , Date regDate 는 Date type 이라서
	// new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(regDate)로 형변환
	@Override
	public String toString() {
		String str = String.format("%3d|%s|%s|%s|%20s"
				, uid ,name, phoneNum, email, 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(regDate));
		return str;
	}
	
	
}
