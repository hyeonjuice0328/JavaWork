<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% // parameter 받아오기
	int uid = Integer.parseInt(request.getParameter("uid"));
	// ※ 이 단계에서 parameter 검증 필요
%>

<%	// DAO 사용한 트랜젝션
	int cnt = (Integer)request.getAttribute("result");
%>
    
<% if(cnt == 0){ %>
	<script>
		alert('수정 실패');
		history.back();
	</script>
<% } else { %>
	<script>
		alert('수정 성공');
		location.href = "view.jsp?uid=<%= uid%>";
	</script>
<% } %>
















