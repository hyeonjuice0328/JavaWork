package com.lec.java.db01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;

/*
JDBC (Java DataBase Connectivity) 사용
 0. 라이브러리(jar) 추가:
  1) 이클립스 프로젝트 폴더에 libs 폴더를 생성
  2) C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6_g.jar
 파일을 libs 폴더로 복사
  3) 복사한 라이브러리를 빌드패스에 추가   
		BulidPath - Configure Build Path..
		Libraries 탭에서  [Add JARs..]   ->  위 libs 폴더의 ojdbc6_g.jar 파일 추가
		Order and Export 탭에서  우선순위 Up (권장)

 1. Oracle 연동을 위한 정보들(상수들)을 정의(세팅)
 2. JDBC 드라이버 클래스를 메모리에 로드
 3. DB와 connection(연결)을 맺음
 4. Statement 인스턴스를 생성 (SQL을 사용하기 위한 인스턴스)
 5. SQL 문장 작성(SELECT, INSERT, UPDATE, DELETE)
 6. SQL 문장을 DB 서버로 전송
 7. 실행 결과 확인
*/

// er-diagram 만들기
// http://ermaster.sourceforge.net/update-site


public class DB01Main {

// 1. Oracle 연동을 위한 정보들(상수들)을 정의(세팅)
	// JDBC 드라이버 클래스 정보 찾기 
	public static final String DRIVER =
			"oracle.jdbc.driver.OracleDriver";
	//접속할 데이터베이스의 URL (DB 서버 접속 주소 정보) 
	public static final String URL = 
			"jdbc:oracle:thin:@localhost:1521:XE";
	//DB 접속 사용자 계정 정보 
	public static final String USER = "scott0316";
	public static final String PASSWD = "tiger0316";
	
		
	public static void main(String[] args) {
		System.out.println("DB 1 : JDBC 프로그래밍");
		
// 2. JDBC 드라이버 클래스를 메모리에 로드
		
		Connection conn = null; // java.sql
		Statement stmt = null;  // java.sql
		ResultSet rs = null;    // java.sql
		
		try {
			Class.forName(DRIVER); //동적 클래스 로딩
			System.out.println("드라이버 클래스 로딩 성공");

// 3. DB와 connection(연결)을 맺음 > Connection conn = null; 생성 			
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB Connect 연결");
			
// 4. Statement 인스턴스를 생성 (SQL을 사용하기 위한 인스턴스) > Statement stmt = null; 생성
			stmt = conn.createStatement();//connection으로부터 statement 생성
			System.out.println("Statement 생성 성공");
			System.out.println();
			
// 5. SQL 문장 작성(SELECT, INSERT, UPDATE, DELETE)
			String sql_insert = "INSERT INTO test_member VALUES(100, '마징가', SYSDATE)";
			
			System.out.println(sql_insert);
			int cnt = stmt.executeUpdate(sql_insert); // DML 명령은 executeUpdate() 로 실행
			                                // return 값은 정수 (int) 몇개의 행이 UPDATE, INSERT, DELETE 되는지...
			System.out.println(cnt + "개의 row(행)이 INSERT 됨");
			
// 5. SQL 문장 작성(SELECT, INSERT, UPDATE, DELETE)			
			System.out.println();
			String sql_select = "SELECT mb_no, mb_name, mb_birthdate FROM test_member";
			System.out.println(sql_select);
			
			//ResultSet rs = null; 생성
			rs = stmt.executeQuery(sql_select); // 'SELECT' 및 기타 쿼리의 경우 executeQuery()로 실행
			                                    // 리턴값은 ResultSet 객체로 받는다. 왜냐면 결과 형태가 테이블 형태이기 때문
// 7. ResultSet 에 담겨있는 record 확인
// 7-1. 컬럼 이름으로 받기
			/*
			System.out.println();
			while(rs.next()) { // next() 레코드 하나 추출 true 리턴, 더 이상 뽑아낼 레코드 없으면 false 리턴
				String no = rs.getString("mb_no");	// getXXX()  에 컬럼명 혹은 별명 명시
				String name = rs.getString("mb_name");
				String birthdate = rs.getString("mb_birthdate");
				String result = no + "\t | " + name + "\t | " + birthdate;
				System.out.println(result);
			}
			*/
// 7-2. 컬럼 인덱스로 받기 
			/*
			System.out.println();while(rs.next()) 
			while(rs.next()) { // next() 레코드 하나 추출 true 리턴, 더 이상 뽑아낼 레코드 없으면 false 리턴
				String no = rs.getString(1);	// getXXX()  에 컬럼명 혹은 별명 명시
				String name = rs.getString(2);
				String birthdate = rs.getString(3);
				//인덱스 1부터 시작 ! 1:mb_no 2:mb_name 3:mb_birthdate
				
				String result = no + "\t | " + name + "\t | " + birthdate;
				System.out.println(result);
			}
			*/
// 7-3. null 처리하기 
// getXXX() 로 가져온 데이터가 null 값이면 null 을 리턴한다. 이를 화면에 보이게 하지 않기 위한 처리		
			/*
			System.out.println();
			while(rs.next()) { // next() 레코드 하나 추출 true 리턴, 더 이상 뽑아낼 레코드 없으면 false 리턴
				String no = rs.getString("mb_no");	// getXXX()  에 컬럼명 혹은 별명 명시
				if(no == null) no = "";
				String name = rs.getString("mb_name");
				String birthdate = rs.getString("mb_birthdate");
				if(birthdate == null) birthdate = "";
				String result = no + "\t | " + name + "\t | " + birthdate;
				System.out.println(result);
			} */
// 7-4. 개별적인 타입으로 get하기
			System.out.println();
			while(rs.next()) { // next() 레코드 하나 추출 true 리턴, 더 이상 뽑아낼 레코드 없으면 false 리턴
				Integer no = rs.getInt("mb_no");	// getXXX()  에 컬럼명 혹은 별명 명시
				// mb_no 컬럽 값이 null 이면 0을 리턴
				String name = rs.getString("mb_name");
				String birthdate = "";
				
				Date d = rs.getDate("mb_birthdate"); // 날짜만 따로 가져오기 (java.sql)
				Time t = rs.getTime("mb_birthdate"); // 시간만 따로 가져오기 (java.sql)
				
				if(d != null) {
					birthdate = new SimpleDateFormat("yyyy년MM월dd일").format(d)+ " "
							+ new SimpleDateFormat("hh:mm:ss").format(t);
				}
				
				String result = no + "\t | " + name + "\t | " + birthdate;
				System.out.println(result);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close(); // 나중에 만들어진  instance 먼저 close 
				if(stmt != null) stmt.close();// conn 보다 stmt 먼저 close
				if(conn != null) conn.close();// 자원이기 때문에 용량 차지! 무한하지 않기때문에 사용후 꼭 close 해주기!! 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println("프로그램 종료");
	} // end main()

} // end class DB01Main













