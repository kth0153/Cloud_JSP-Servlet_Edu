<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>220926 수업</title>
</head>
<body>
	<!-- // 선언부가 먼저 컴파일되서 스크립릿에 있는 team변수가 출력이 된다. -->
	<% String name = team + "Fighting"; %>
	<%! String team = "Korea"; %>
	<p><%= name %></p>
	
	<%!
		/* 전역변수는 기본적으로 초기화 되어있지만 지역변수는 초기화를 시켜줘야 한다. */
		 
		int one; /// 전역변수 선언부에서는 초기값 지정하지 않아도 0으로 자동초기화 단, 지역변수 스크립트릿에서는 초기화값 적어줘야함.
		
		int two = 1;
		public int plusMethod(){
			return one + two; // 1
		}
		
		String msg; // String의 초기값 null
		int three; // 0
		
	%>
	<p>plusMethod()함수의 값은? : <%=plusMethod() %></p>
	<p>String msg의 값은? : <%=msg %></p>
	<p>int three의 값은? : <%=three %></p>

</body>
</html>