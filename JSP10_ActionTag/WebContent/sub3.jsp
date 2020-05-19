<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.
	String name = request.getParameter("name");
	String age = request.getParameter("age");
%>

이름: <%= name %><br>
나이: <%= age %><br>