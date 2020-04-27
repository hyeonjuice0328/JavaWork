package phonebook06.db;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

// CONTROLLER 객체 
// 어플리케이션의 동작, 데이터 처리(CRUD).. (Business logic 담당) 
public class PhonebookManager implements Pb, Closeable {

	// TODO : DB를 위한 변수들 선언
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	// singleton적용
	private PhonebookManager() {

		// TODO : JDBC 프로그래밍
		// Statement (필요하다면) 생성
		// 클래스 로딩
		try {
			Class.forName(DRIVER);
			System.out.println("드라이버 클래스 로딩 성공");

			// 연결 Connection
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB Connect 연결 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static PhonebookManager instance = null;

	public static PhonebookManager getInstance() {
		if (instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	} // end getInstance()

	// 전화번호부 생성 등록
	@Override

	public int insert(String name, String phoneNum, String memo) {

		// 매개변수 검증 : 이름 필수
		if (name == null || name.trim().length() == 0) {
			throw new PhonebookException("insert() 이름입력오류: ", Pb.ERR_EMPTY_STRING);
		}

		int cnt = 0;

		// SQL_INSERT 사용하여 INSERT
		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			// "INSERT INTO phonebook(pb_uid, pb_name, pb_phonenum, pb_memo)
			// VALUES(phonebook_seq.nextval, ?, ?, ?)"

			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			cnt = pstmt.executeUpdate();

			System.out.println(cnt + "개 행(row) INSERT 성공");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return cnt;
	}

	@Override
	public PhonebookModel[] selectAll() {

		// TODO
		ArrayList<PhonebookModel> pblist = new ArrayList<PhonebookModel>();
		// SQL_SELECT_ALL 사용
		try {

			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			// "SELECT * FROM phonebook ORFER BY pb_uid DESC"
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int pb_uid = rs.getInt(COL_LABEL_UID);
				String pb_name = rs.getString(COL_LABEL_NAME);
				String pb_phonenum = rs.getString(COL_LABEL_PHONENUM);
				String pb_memo = rs.getString(COL_LABEL_MEMO);

				String pb_regdate = rs.getString(COL_LABEL_REGDATE);
				SimpleDateFormat tranFormat = new SimpleDateFormat("yyyy년MM월dd일 hh:mm:ss").parse();
				Date date = tranFormat.

				pblist.add(new PhonebookModel(pb_uid, pb_name, pb_phonenum, pb_memo, pb_regdate));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pblist.toArray(new PhonebookModel[pblist.size()]);
	}

	// 특정 uid 의 데이터 검색 리턴
	// 못찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) {

		try {
			pstmt = conn.prepareStatement(SQL_SELECT_BY_UID);
			pstmt.setInt(1, uid);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null; // 못찾으면 null 리턴
	}// end selectByUid()

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("update() uid 오류: " + uid, Pb.ERR_UID);

		if (name == null || name.trim().length() == 0) // 이름 필수
			throw new PhonebookException("update() 이름입력 오류: ", Pb.ERR_EMPTY_STRING);

		int cnt = 0;

		// SQL_UPDATE_BY_UID 사용
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE_BY_UID);
			// "UPDATEphonebook SET pb_name = ?, pb_phonenum =?,
			// pb_memo =? WHERE pb_uid = ?"
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			pstmt.setInt(4, uid);
			cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행(row) UPDATE 성공");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return cnt;
	}

	@Override
	public int deleteByUid(int uid) {
		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("deleteByUid() uid 오류: " + uid, Pb.ERR_UID);

		int cnt = 0;

		// SQL_DELETE_BY_UID 사용
		try {
			pstmt = conn.prepareStatement(SQL_DELETE_BY_UID);
			// "DELETE FROM phonebook WHERE pb_uid = ?"
			pstmt.setInt(1, uid);
			// TODO

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cnt;
	}

	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {
		int maxUid = 0;

		// TODO : 옵션

		return maxUid;
	}

	@Override
	public void close() throws IOException {

		try {
			if (rs != null)
				rs.close();
			if (conn != null)
				conn.close();
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		// TODO
		// ResultSet
		// Satement
		// Connection
		// 들 close() ..
	}

} // end PhonebookManager

// 예의 클래스 정의
// 예외발생하면 '에러코드' + '에러메세지'를 부여하여 관리하는게 좋다.
class PhonebookException extends RuntimeException {

	private int errCode = Pb.ERR_GENERIC;

	public PhonebookException() {
		super("Phonebook 예외 발생");
	}

	public PhonebookException(String msg) {
		super(msg);
	}

	public PhonebookException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}

	// Throwable 의 getMessage 를 오버라이딩 가능
	@Override
	public String getMessage() {
		String msg = "ERR-" + errCode + "]" + Pb.ERR_STR[errCode] + " " + super.getMessage();
		return msg;
	}

} // end PhonebookException
