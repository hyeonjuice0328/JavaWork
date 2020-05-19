<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial=scale=1.0">
<title>Insert title here</title>
</head>
<body>
<%
	int sum = 0;
	for(int cnt = 1; cnt <= 100; cnt++){
		sum += cnt;
	}
%>
1부터 100까지의 합은: <%= sum %>
</body>
</html>
