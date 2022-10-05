<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>220927 수업 request</title>
</head>
<body>
<!-- 
	[http 메서지를 통해 httpServletRequest를 얻음]
	request 객체의 요청 파라미터 관련 메소드
	String getParameter(name) - 파라미터 변수 name에 저장된 변수를 얻어내는 메소드로, 이때 변수의 값은 String으로 리턴된다.
	- String[] getParameterValues(name) - 파라미터 변수 name에 저장된 모든 변수값을 얻어내는 메소드로, 이때 변수의 값은 String 배열로 리턴된다. checkbox에서 주로 사용
	- Enumeration getParameterNames() - 요청에 의해 얻어오는 모든 파라미터 변수를 java.util.Enumeration 타입으로 리턴한다. -->

<% 
	String name = request.getParameter("name");
	String[] hobby = request.getParameterValues("hobby");
	out.println("<p>getParameter(name) : "+name+"</p>");
	out.println(hobby.length);
%>
<P>URI, request.getRequestURI() : <%= request.getRequestURI() %>
<P>URI, request.getRemoteAddr() : <%= request.getRemoteAddr() %>

	<!-- 
	[requset 객체의 웹 브라우저, 웹 서버 및 요청 헤더 정보 관련 메소드]
	- String getProtocol() - 웹 서버로 요청 시, 사용 중인 프로토콜을 리턴한다.
	- String getServerName() - 웹 서버로 요청시, 서버의 도메인 이름을 리턴한다.
	- String getMethod() - 웹 서버로 요청시, 요청에 사용된 요청 방식(get,post,put 등 )을 리턴한다.
	- String getQueryString() - 웹 서버로 요청시, 요청에 사용된 QueryString을 리턴한다.
	* String getRequestURI() - 웹 서버로 요청시, 요청에 사용된 url로 부터 uri 값을 리턴한다.
	** String getRemoteAddr() - 웹 서버로 정보를 요청한 웹 브라우저의 ip주소를 리턴한다.
	- int getServerPort() - 웹 서버로 요청시 서버의 port 번호를 리턴한다.
	- String getContextPath() - 해당 Jsp 페이지가 속한 웹 어플리케이션의 콘텍스트 경로를 리턴한다.
	- String getHeader(name) - 웹 서버로 요청시, http 요청 헤더(header)의 헤더 이름인 name에 해당 하는 속성값을 리턴한다.
	- Enumeration getHeaderNames() - 웹 서버로 요청 시, http 요청 헤더에 있는 모든 헤더 이름을 리턴한다. 
	-->
	<%
	
	%>
	
	

	
</body>
</html>