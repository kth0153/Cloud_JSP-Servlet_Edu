<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<!-- 
	[웹 브라우저에 보내는 응답 정보는 HttpServletResponse 객체 사용]
	response 내장 객체에서 자주 사용 되는 메소드
	- void setHeader(name, value) : 헤더 정보의 값을 수정하는 메소드로, name에 해당하는 헤더 정보를 value값으로 설정한다.
	- void setContentText(type) : 웹 브라우저의 요청의 결과로 보일 페이지의 contentType을 설정한다.
	- void setRedirect(url) : 페이지를 이동시키는 메소드로, url로 주어진 페이지로 제어가 이동 한다. 
	-->


	<%
		response.setContentType("text/html;charset=UTF-8");
		response.sendRedirect("request.jsp");	// request.jsp 로 리다이렉트 시킨다.
	%>
</body>
</html>