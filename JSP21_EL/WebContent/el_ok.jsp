<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial=scale=1.0">
<title>EL 내장객체</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String [] hobby = request.getParameterValues("hobby");
%>

아이디: <%= id %><br>
비밀번호: <%= pw %><br>
취미: <% for(int i = 0; i < hobby.length; i ++){ %>
		<%= hobby[i] %>
	<%} %>
<hr>		

아이디 : ${param.id }<br>
비밀번호 : ${param.pw }<br>
취미 : ${paramValues.hobby[0] }
	${paramValues.hobby[1] }
	${paramValues.hobby[2] }<br>
<hr>	

아이디 : ${param["id"] }<br>
비밀번호 : ${param["pw"] }<br>
취미 : ${paramValues["hobby"][0] }
	${paramValues["hobby"][1] }
	${paramValues["hobby"][2] }<br>
<hr>	

applicationScope : ${applicationScope.application_name }<br>
sessionScope : ${sessionScope.session_name }<br>
pageScope : ${pageScope.page_name }<br>
<%-- 페이지스코프는 그 페이지 안에서만 유효 하기 떄문에 값이 나오지 않는다. --%>
requestScope : ${requestScope.request_name }<br>
<%-- 이미 서브밋이 실행되서 넘어왔으면 다른 리퀘스트로 변경되었기 때문에 값 넘어오지 않는다. --%>

<hr>

context 초기화 파라미터<br>
${initParam.con_name }<br>
${initParam.con_id }<br>
${initParam.con_pw }<br>
<hr>

ContextPath<br>
<%= request.getContextPath() %><br>
${pageContext.request.contextPath }<br>

</body>
</html>













