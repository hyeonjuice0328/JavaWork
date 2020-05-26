<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial=scale=1.0">
<title>EL</title>
</head>
<body>
<h3>Expression Language</h3>
${10 }<br>
${99.99 }<br>
${"ABC" }<br>
${true }<br>
<hr>
<h3>EL 의 연산자</h3>
${1 + 2 }<br>
${1 - 2 }<br>
${1 * 2 }<br>
${1 / 2 }<br>
${1 > 2 }<br>
${1 < 2 }<br>
${(1 < 2)? 1 : 2 }<br>
${ (1 > 2) || (1 < 2) }<br>
<hr>

<%
	int num = 10;
%>

<%-- EL 은 Java 언어가 아니다. Java 변수 그래도 표현은 안된다. 
	 하지만 특별히 에러가 나지도 않는다. --%>
num: ${num }<br>
num: <%= num %><br>


</body>
</html>











