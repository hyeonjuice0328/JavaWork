<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Enumeration" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial=scale=1.0">
<title>Session List</title>
</head>
<body>
<%
	if(request.isRequestedSessionIdValid()){
		out.println("유효한 세션이 있습니다.<hr>");
	}else{
		out.println("유효한 세션이 없습니다.<hr>");
	}

	// 세션이 있다면 세션 뽑기
	String sessionName, sessionValue;
	
	// 현재 세션의 모든 name 들 가져오기
	Enumeration<String> enumeration = session.getAttributeNames(); // Enumeration<String> return
	
	int i = 0;
	while(enumeration.hasMoreElements()){
		
		// 세션의 이름
		sessionName = enumeration.nextElement();
		
		// 세션의 값 (오브젝트 리턴)
		sessionValue = session.getAttribute(sessionName).toString();
		
		out.println((i+1) + "] " + sessionName + " : " + sessionValue + "<br>");
		
		i++;
	}// end while
		
	if(i == 0){
		out.println("세션이 없습니다<br>");
	}
		
		
%>

<hr>
<form action="sessionCreate.jsp">
	<input type="submit" value="세션생성">
</form>
<br>
<form action="sessionDelete.jsp">
	<input type="submit" value="세션삭제">
</form>

<hr>
<%
	String sessionId = session.getId();
	int sessionInterval = session.getMaxInactiveInterval();
	
	out.println("세션 ID : " + sessionId + "<br>");
	out.println("세션 유효시간 : " + sessionInterval + "<br>");
%>

<%
	out.println("---session.invalidate() --- <br>");
	// 기존 세션 테이블 삭제 - session Id 무효화
	// 그 안에 모든 attribute(이름...) 도 삭제  
	// 새로운 테이블 생성 
	
	//session.invalidate();
	
	sessionId = session.getId();
	sessionInterval = session.getMaxInactiveInterval();
	
	out.println("세션 ID : " + sessionId + "<br>");
	out.println("세션 유효시간 : " + sessionInterval + "<br>");

%>





</body>
</html>