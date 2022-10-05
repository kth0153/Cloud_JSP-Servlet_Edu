<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>220927 수업 모든 쿠키 삭제</title>
</head>
<body>
	<%
	
		Cookie[] cookies = request.getCookies();
	
		if(cookies!=null){
			for(int i=0; i<cookies.length; i++){ // 모든 쿠키 삭제
				cookies[i].setMaxAge(0);
				cookies[i].setValue(null);
				response.addCookie(cookies[i]);
			}
		}
		out.print(cookies.length);
	
	%>
</body>
</html>