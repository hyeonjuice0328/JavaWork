<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial=scale=1.0">
<title>JSP 시작</title>
</head>
<body>
첫 JSP 파일입니다!<br>
<a href="page1.jsp">page1</a><br>
<!-- http://localhost:8082/JSP01_Hello/Hello.jsp 에서
	 http://localhost:8082/JSP01_Hello/page1.jsp 를 request-->
<a href="./page2.jsp">page2</a><br>
<!-- 현재 경로 : ./ 로 표시 -->
<a href="/page3.jsp">page3</a>
<!-- http://localhost:8082/page3.jsp
	도메인 경로 다음에 연결이 된다. 에러 발생 404에러 파일을 찾을 수가 없음 
	404에러 발생하면 우선 url 부터 확인하기 -->
</body>
</html>