<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<style>
body{
	background-color : #333;
	color : white;
}
</style>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
<h1> Logout Page</h1>
<form action="${pageContext.request.contextPath}/customLogout" method='post'>
<input type="hidden"name="${_csrf.parameterName}"value="${_csrf.token}"/>
<button>로그아웃</button>
</form>
</body>
</html>


