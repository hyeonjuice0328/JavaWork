<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cnt" class="com.lec.beans.CountBean" scope="page"/>
<jsp:setProperty name="cnt" property="count"/>
<%-- cnt.setCount(Integer.parsInt(request.getParameter("count"))) --%>

<h3>page1<br>cnt와 getCount 호출</h3>
