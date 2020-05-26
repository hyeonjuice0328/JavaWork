<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
	<c:when test="${result == 0 }"> <!-- 0이면 등록실패 -->
		<script>
			alert("삭제 실패");
			history.back();   // 브라우저가 기억하는 직전 페이지(입력중 페이지로)
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("삭제 성공");
			location.href = "list.do";
		</script>
	</c:otherwise>
</c:choose>

















