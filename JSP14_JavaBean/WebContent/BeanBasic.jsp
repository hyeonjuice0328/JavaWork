<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="person" class="com.lec.beans.Person" scope="page" />
<%-- 다음과 같은 일 수행
	Person person = new com.test.ex.Person();
 --%>

<jsp:useBean id="person2" class="com.lec.beans.Person" scope="page">
	<jsp:setProperty name="person2" property="name" value="명기범" />
	<jsp:setProperty name="person2" property="age" value="26" />
	<jsp:setProperty name="person2" property="id" value="99887" />
	<jsp:setProperty name="person2" property="gender" value="남" />
</jsp:useBean>

<%-- form 에서 넘어온 값을 bean 객체가 submit
	bean 의 필드명(getter and setter)과 form 의 name 이 일치해야한다.  --%>
<jsp:useBean id="person3" class="com.lec.beans.Person" scope="page">

	<jsp:setProperty name="person3" property="name" />
	<jsp:setProperty name="person3" property="age" />
	<jsp:setProperty name="person3" property="id" />
	<jsp:setProperty name="person3" property="gender" />
</jsp:useBean>


<%--parameter 일괄적으로 받아오기 --%>
<jsp:useBean id="person4" class="com.lec.beans.Person" scope="page"/>
<jsp:setProperty name="person4" property="*"/>



<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자바빈</title>
</head>
<body>
	<jsp:setProperty name="person" property="name" value="고길동" />
	<%-- 다음과 같이 대소문자 틀리면 에러다
	<jsp:setProperty name="person" property="Name" value="고길동" />
	 --%>
	<jsp:setProperty name="person" property="age" value="24" />
	<jsp:setProperty name="person" property="id" value="1515" />
	<jsp:setProperty name="person" property="gender" value="남" />
	<%-- 다음과 같은 일을 수행한다.
		person.setName("고길동");
		person.setAge(24);
		person.setId(1515);
		person.setGender("남");
	 --%>

	<h3>person1</h3>
	이름:
	<jsp:getProperty name="person" property="name" />
	<br> 나이:
	<jsp:getProperty name="person" property="age" />
	<br> 아이디:
	<jsp:getProperty name="person" property="id" />
	<br> 성별:
	<jsp:getProperty name="person" property="gender" />
	<br>
	<%-- 다음과 같은 일을 수행한다
		<%= person.getName() %>
		<%= person.getAge() %>
		<%= person.getId() %>
		<%= person.getGender() %>
	 --%>

	<h3>person2</h3>
	이름:
	<jsp:getProperty name="person2" property="name" />
	<br> 나이:
	<jsp:getProperty name="person2" property="age" />
	<br> 아이디:
	<jsp:getProperty name="person2" property="id" />
	<br> 성별:
	<jsp:getProperty name="person2" property="gender" />
	<br>

	<h3>person3</h3>
	이름:
	<jsp:getProperty name="person3" property="name" />
	<br> 나이:
	<jsp:getProperty name="person3" property="age" />
	<br> 아이디:
	<jsp:getProperty name="person3" property="id" />
	<br> 성별:
	<jsp:getProperty name="person3" property="gender" />
	<br>

	<h3>person4</h3>
	이름:
	<jsp:getProperty name="person4" property="name" />
	<br> 나이:
	<jsp:getProperty name="person4" property="age" />
	<br> 아이디:
	<jsp:getProperty name="person4" property="id" />
	<br> 성별:
	<jsp:getProperty name="person4" property="gender" />
	<br>

</body>
</html>

