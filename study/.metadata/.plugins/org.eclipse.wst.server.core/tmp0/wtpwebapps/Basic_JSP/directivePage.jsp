<%@page import="java.util.Date"
		errorPage="error.jsp"
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>220926 수업 PAGE 디렉티브 : PAGE Directive</title>
</head>
<body>
<!-- errorPage import를 함으로서 에러 발생시 해당 에러 메시지 페이지의 내용을 출력(해당 에러 발생 위치) -->
<!-- include 효과를 나타냄 -->
<%=1/0 %> <!-- 데이터 값 오류 발생  에러 발생되는 위치에 따라 페이지에 표현 되는 것이 달라짐-->
	<%
		Date date = new Date(); // import
	%>
	
	<%= date.toLocaleString() %>
	<%
		out.flush();
		int one = 1;
		int zero = 0;
	%>
	

</body>
</html>