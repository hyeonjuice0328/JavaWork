package com.lec.beans;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import common.D;

//DAO : Data Access Object
// DB 에 접속하여 트랜젝션을 수행하는 객체 
// 다루는 데이터 소스의 종류에 따라 DAO는 여러개 정의 사용 가능 

public class WriteDAO {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// DAO 객체가 생성될 때 Connection 도 생성되게끔 설계
	public WriteDAO() {} // 생성자
	
	// Connection Pool 리소스
	public static Connection getConnection() throws SQLException, NamingException{
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/testDB");
		// 언제든지 필요하면 getConnection 받아서 사용한다. 생성을 하지 않는다. 
		return ds.getConnection();
	}
	
	// DB 자원 반납
	public void close() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	} // end close();

	// 새 글 작성 ver1 (DTO 를 받아서 ) 
	public int insert(WriteDTO dto) throws SQLException, NamingException {
		String subject = dto.getSubject();
		String content = dto.getContent();
		String name = dto.getName();
		
		int cnt = this.insert(subject, content, name);
		return cnt;
	}
	
	// 새 글 작성 ver2 (제목 , 내용, 작성자 받아서 - form)
	public int insert(String subject, String content, String name) 
			throws SQLException, NamingException {
		
		int cnt = 0;
		
		try {
			
			conn = getConnection(); // connection pool 사용
			
		pstmt = conn.prepareStatement(D.SQL_WRITE_INSERT);
		pstmt.setString(1, subject);
		pstmt.setString(2, content);
		pstmt.setString(3, name);
		
		cnt = pstmt.executeUpdate();
		} finally {
			close();
		}
		return cnt;
			
	}
	
	// ResultSet -> DTO 배열로 리턴
	public WriteDTO [] createArray(ResultSet rs) throws SQLException{
		WriteDTO [] arr = null; // DTO 배열
		
		ArrayList<WriteDTO> list = new ArrayList<WriteDTO>();
		
		while(rs.next()) {
			int uid = rs.getInt("wr_uid");
			String subject = rs.getString("wr_subject");
			String name = rs.getString("wr_name");
			String content = rs.getString("wr_content");
			int viewCnt = rs.getInt("wr_viewcnt");
			Date d = rs.getDate("wr_regdate");
			Time t = rs.getTime("wr_regdate");
			
			String regDate = "";
			if(d != null){
				regDate = new SimpleDateFormat("yyyy-MM-dd").format(d) + " "
						+ new SimpleDateFormat("hh:mm:ss").format(t);
			
			}
			WriteDTO dto = new WriteDTO(uid, subject, content, name, viewCnt);
			dto.setRegDate(regDate);
			list.add(dto);
		} // end while
		
		int size = list.size();
		
		if(size == 0) return null;
		
		arr = new WriteDTO[size];
		list.toArray(arr); // list 를 배열로 변환
		return arr;
	}
	
	//전체 SELECT
	public WriteDTO [] select() throws SQLException, NamingException{
		WriteDTO [] arr = null;
		
		try {
			
			conn = getConnection(); // connection pool 사용
			
			pstmt = conn.prepareStatement(D.SQL_WRITE_SELECT);
			rs = pstmt.executeQuery();
			arr = createArray(rs);
		} finally {
			close();
		}
		
		return arr;
	} // end select()
	
	// 특정 uid의 글내용 읽기, 조회수 증가 
	// viewCnt 1증가 + 내용 읽어오기 -트렌젝션
	public WriteDTO [] readByUid(int uid) throws SQLException , NamingException{
		int cnt = 0;
		WriteDTO [] arr = null;
		
		try {
			conn = getConnection(); // connection pool 사용
			
			// 트랜젝션 처리
			conn.setAutoCommit(false);
			
			// 쿼리들 수행
			pstmt = conn.prepareStatement(D.SQL_WRITE_INC_VIEWCNT);
			pstmt.setInt(1, uid);
			cnt = pstmt.executeUpdate();
			
			pstmt.close();
			
			pstmt = conn.prepareStatement(D.SQL_WRITE_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			
			arr = createArray(rs);
			conn.commit();
			
		} catch(SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			close();
		}
		
		
		return arr;
	}// end readyByUid()
	
	// 특정 uid 의 글만 SELECT - 조회 수 증가 없음
	public WriteDTO [] selectByUid(int uid) throws SQLException, NamingException{
		WriteDTO [] arr = null;
		
		try {
			
			conn = getConnection(); // connection pool 사용
			
			pstmt = conn.prepareStatement(D.SQL_WRITE_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			arr = createArray(rs);
		} finally {
			close();
			
		}
		return arr;
		
	}
	
	
	
	// 특정 uid 의 글 수정(제목, 내용)
	public int update(int uid , String subject, String content) throws SQLException, NamingException{
		int cnt = 0;
		
		try {
			
			conn = getConnection(); // connection pool 사용
			
			pstmt = conn.prepareStatement(D.SQL_WRITE_UPDATE);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, uid);
			
			cnt = pstmt.executeUpdate();
		}finally {
			close();
		}
		return cnt;
	}


	// 특정 uid 글 삭제하기
	public int deleteByUid(int uid) throws SQLException, NamingException{
		int cnt = 0;
		try {
			
			conn = getConnection(); // connection pool 사용
			
			pstmt = conn.prepareStatement(D.SQL_WRITE_DELETE_BY_UID);
			pstmt.setInt(1, uid);
			cnt = pstmt.executeUpdate();
		} finally {
			close();
		}
		return cnt;
	} // end delete by uid
	
}
