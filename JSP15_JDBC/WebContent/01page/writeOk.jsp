<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%> <%-- JDBC 관련 import --%>

<%
	request.setCharacterEncoding("utf-8"); // 한글 인코딩
	// 입력한 값 받아오기
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	//유효성 체크 (프론트엔드에서 한번 백엔드에서도 한번 더 유효성 체크해주기)
	//name, subject 는 비어있으면 안된다. NN(Not Null)
	//null 이거나 빈 문자열이면 이전화면으로 돌아가기.
	if(name == null || subject == null || 
		name.trim().equals("") || subject.trim().equals("")){
%>
	<script>
		alert("작성자 이름, 글제목은 필수 입니다!");
		history.back(); // history.go(-1); 작성하던 그 이전으로 돌아가기
	</script>
<% 
	return;	// ★★★ 더 이상 JSP 프로세싱 하지 않도록 종료 ★
	}
%>    

<%!
	// JDBC 관련 기본 객체변수
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;   // SELECT 결과, executeQuery() 
	int cnt = 0;   // DML 결과, executeUpdate()
	
	// Connection 에 필요한 값 세팅
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "scott0316";
	String userpw = "tiger0316";
%>

<%!
	// 쿼리문 준비
	String sql_insert = "INSERT INTO test_write" +
		"(wr_uid, wr_subject, wr_content, wr_name) " +
		"VALUES(test_write_seq.nextval, ?, ?, ?)"
		;
%>

<%
	try{
		Class.forName(driver);
		out.println("드라이버 로딩 성공" + "<br>");
		conn = DriverManager.getConnection(url, userid, userpw);
		out.println("conn 성공" + "<br>");
		
		// 트랜잭션 실행
		pstmt = conn.prepareStatement(sql_insert);
		
		pstmt.setString(1, subject);
		pstmt.setString(2, content);
		pstmt.setString(3, name);
		
		cnt = pstmt.executeUpdate();
		
	} catch(Exception e){
		e.printStackTrace();
		// 예외 처리
	} finally {
		// 리소스 해제
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
%>
<%-- 위 트랜잭션이 마무리 되면 페이지 보여주기 --%>

<% if(cnt == 0){ %>
	<script>
		alert("등록실패");
		history.back();
	</script>
<% } else { %>
	<script>
		alert("등록성공, 리스트를 출력합니다.");
		location.href = "list.jsp";
	</script>
<% } %>








