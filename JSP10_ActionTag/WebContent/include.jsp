<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial=scale=1.0">
<title>include</title>
</head>
<body>
<!-- Action Tag -->
<%
	String name ="홍길동";
	int age = 33;
%>
<h3>지금의 페이지는 include 페이지 입니다.</h3>
<jsp:include page="sub3.jsp">
	<jsp:param value="<%= name %>" name="name"/>
	<jsp:param value="<%= age %>" name="age"/>
</jsp:include>




</body>
</html>