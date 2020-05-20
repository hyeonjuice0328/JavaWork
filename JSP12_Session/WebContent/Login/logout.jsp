<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
"D:/JavaApp1/Dropbox/Java_lecture/JavaWork/JSP12_Session/WebContent/loginOk.jsp"
<%
	session.removeAttribute("userid");
	response.sendRedirect("login.jsp");
%>
<script>
alert("로그아웃 되었습니다");
</script>