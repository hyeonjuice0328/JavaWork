<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="person1" class="com.lec.beans.Person" scope="page"/>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial=scale=1.0">
<title>javabean</title>
</head>
<body>
	<jsp:setProperty property="name" name="person1" value="고길동"/>
	<jsp:setProperty property="age" name="person1"value="24"/>
	<jsp:setProperty property="id" name="person1" value="1515"/>
	<jsp:setProperty property="gender" name="person1" value="남"/>
	
	<h3>person1</h3>
	이름: <jsp:getProperty property="name" name="person1"/><br>
	나이: <jsp:getProperty property="age" name="person1"/><br>
	아이디: <jsp:getProperty property="id" name="person1"/><br>
	성별: <jsp:getProperty property="gender" name="person1"/><br>
</body>
</html>