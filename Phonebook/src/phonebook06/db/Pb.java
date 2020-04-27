package phonebook06.db;

//Controller interface 
// 인터페이스를 만든 이유 -> 컨트롤러(동작정의) 그 전에 인터페이스에서 '동작설계'
public interface Pb {
	
	
	public static final String VERSION = "전화전호부 6.0"; 
	
	// 만들고자 하는 응용프로그램의 
	// '동작' 을 설계하는 것이 인터페이스다.
	// 이 인터페이스는  View 와 Controller 의 연결고리 역할을 하여.  모듈단위 유지관리를 용이하게 해준다. 
	
	// [동작 설계]
	// 1. 이름(name) 과 전화번호(phoneNum) 과 (memo) 값이 주어지면 전화번호 데이터(PhonebookModel) 를 생성하여 저장,  
	//		날짜(regDate) 는 생성한 날짜로, uid 값은 자동 증가 값으로
	//		성공하면 1, 실패하면 0 리턴
	// 2. 현재 전화번호부에 저장된 전화번호 데이터(PhonebookModel) 들을 전부 불러들여서 리턴 (PhonebookModel 배열로)
	// 3. 특정 uid 값을 가진 전화번호 데이터(PhonebookModel) 을 찾아서 리턴 (검색 기능)
	//		없으면 null 리턴
	// 4. 특정 uid 값을 가진 전화번호 데이터(PhonebookModel) 을 찾아서 
	//		주어진 이름(name) 과 전화번호(phoneNum) 과 (memo) 값 으로 변경. (수정 기능)  성공하면 1, 실패하면 0 리턴
	// 5. 특정 uid 값을 가진 전화번호 데이터(PhonebookModel) 을 찾아서 삭제.  성공하면 1, 실패하면 0 리턴
	// 6. 최대 uid 값 찾기 --------> PhonebookdManager(CONTROLLER) 안에 getMaxUid() 를 만들었음
	
	public abstract int insert(String name, String phoneNum, String memo); /* [동작설계1] */
	public abstract PhonebookModel[] selectAll(); /*[동작설계2]*/
	public abstract PhonebookModel selectByUid(int uid); /*[동작설계3]*/
	public abstract int/* 성공하면 1, 실패하면 0 */
		updateByUid(int uid, String name, String phoneNum, String memo); /*[동작설계4]*/
	public abstract int deleteByUid(int uid); /*[동작설계5]*/
	
//	public static final int QUERY_FAIL = 0; /*실패하면 0을 리턴하기 때문에 설정*/
	
	// 에러가 발생될 상황들에 맞춰서 상수 만들기 
	public static final int ERR_GENERIC = 0; // 일반적이 오류 , 일반오류 , 인덱스 범위 벗어나는 상황
	public static final int ERR_INDEXOUTOFRANGE = 1; // 인덱스 범위 벗어남
	public static final int ERR_EMPTY_STRING = 2; // 입력문자열이 empty 인 경우 ( 혹은 null 인 경우) 
	public static final int ERR_UID = 3; // uid가 없는 경우 
	
	//에러 문자열
	//위의 에러코드에 맞는 상응하는 문자열은 생성 
	public static final String[] ERR_STR = {
		"일반 오류", //0
		"인덱스 오류", // 1
		"문자열 오류", // 2
		"UID 오류", // 3
	};

	//데이터 베이스 관련된 상수들 선언 
	// 1. Oracle 연동을 위한 정보들(상수들)을 정의(세팅)
	// JDBC 드라이버 클래스 정보
	public static final String DRIVER =
			"oracle.jdbc.driver.OracleDriver";
	// DB 서버 정보
	public static final String URL =
			"jdbc:oracle:thin:@localhost:1521:XE";
	// DB 사용자 계정 정보
	public static final String USER = "scott0316";
	public static final String PASSWD = "tiger0316";
	
	public static final String TBL_NAME = "phonebook";
	
	public static final String COL_LABEL_UID = "pb_uid";
	public static final String COL_LABEL_NAME = "pb_name";
	public static final String COL_LABEL_PHONENUM = "pb_phonenum";
	public static final String COL_LABEL_MEMO = "pb_memo";
	public static final String COL_LABEL_REGDATE = "pb_regdate";
	public static final String SEQ_NAME = "phonebook_seq";
	
	//쿼리 문자열 만들기!!
	// PreparedStatement 방식
	
	public static final String SQL_COUNT_ALL 
		= "SELECT COUNT(*) cnt FROM " + TBL_NAME;
	
	public static final String SQL_SELECT_ALL
		= "SELECT * FROM " + TBL_NAME +
		" ORDER BY " +  COL_LABEL_UID + " DESC";
	
	public static final String SQL_INSERT
		= "INSERT INTO " + TBL_NAME 
		  + "(pb_uid, pb_name, pb_phonenum, pb_memo) "
		  + "VALUES(" + SEQ_NAME + ".nextval, ?, ?, ?)";
	
	public static final String SQL_UPDATE_BY_UID
		= "UPDATE" + TBL_NAME + " SET "
		+ COL_LABEL_NAME + " = ?, "
		+ COL_LABEL_PHONENUM + " =?, "
		+ COL_LABEL_MEMO + " =? "
		+ "WHERE " + COL_LABEL_UID + " = ?"
		;

	public static final String SQL_DELETE_BY_UID
		= "DELETE FROM " + TBL_NAME
		+ " WHERE " + COL_LABEL_UID + " = ?"
		;
	
	public static final String SQL_SELECT_BY_UID
		= "SELECT COUNT(*) FROM " + TBL_NAME
				 + " = ?";
	
	//TODO : 추가로 필요한 쿼리 문 
	
	
}
