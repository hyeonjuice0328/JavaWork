<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.text.*" %>
<%@ page import = "java.util.*" %>    

<%
	String cookieName1 = "num";
	String cookieValue1 = "" + (int)(Math.random() * 10); //0~9
	Cookie cookie1 = new Cookie(cookieName1, cookieValue1);
	cookie1.setMaxAge(2 * 30); // 쿠키 파기 시간 (생성시점으로부터 .. count)
	response.addCookie(cookie1); //생성된 쿠키는 response 에 담긴다.
	
	String cookieName2 = "datetime";
	String cookieValue2 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	Cookie cookie2 = new Cookie(cookieName2, cookieValue2);
	cookie2.setMaxAge(30); // 쿠키 파기 시간 (생성시점으로부터 .. count)
	response.addCookie(cookie2); //생성된 쿠키는 response 에 담긴다.
%>

<script>
alert("<%= cookieName1 %> 쿠키생성");
location.href = "cookieList.jsp";
</script>