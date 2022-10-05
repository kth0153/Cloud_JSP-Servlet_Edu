<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>220926 수업 코딩문법</title>
</head>
<body>
	<%! String strName = "홍길동"; %>
	<%! public String cmdMethod() {
		
			return strName;
		}
	%>
	<!-- <p><%=cmdMethod() %></p> --> 
	<p><%=cmdMethod() %></p>
	
	<%
	
		String part = "JSP";
		String strClass = "광안대교 1강의실";
		out.println("<p>"+part +" | " + strClass+"</p>");
		
	%>

</body>
</html>