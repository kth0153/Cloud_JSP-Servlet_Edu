<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<title>Insert title here</title>
</head>
<body>
<p>userName : <%=session.getAttribute("sessName") %></p>
<p>userId : <%=session.getAttribute("sessId") %></p>
<p>userPw : <%=session.getAttribute("sessPw") %></p>
<p>userEmail : <%=session.getAttribute("sessEmail") %></p>
<p><a href="Logout">Logout</a></p>
</body>
</html>