<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>220926 함수, 변수의 연산</title>
</head>
<body>

	<%
		Date date = new Date();
		int hour = date.getHours(); // 현재 시간 값 가져오는 곳
		int one = 10;
		int two = 12;
	
	%>
	<%! // 함수 선언시 전역 변수로 사용해야 함
		public int operation(int i, int j){
		// if(i>j) return i;
		// else return j;
		return i>j ? i : j; // 삼항 연산자 => 조건문 ? 참 : 거짓
	}
	%>
	<p>지금은 <%=hour %>시 오전 ? 오후 : <%= hour<12 ? "오전" : "오후" %></p> <!-- 삼항 연산자 사용해 해당 시간의 오전, 오후 값 출력 -->
	<p><%= one %> or <%=two %> 중 큰 수는 ? : <%=operation(one, two) %></p>
	

</body>
</html>