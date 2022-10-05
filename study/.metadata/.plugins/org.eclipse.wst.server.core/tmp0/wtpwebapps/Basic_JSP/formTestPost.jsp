<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>220926 수업 폼 데이터 전송</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8");%>
	
	<%! String msg; %>
	
	<%
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String msg;
		
		// 방법 1
		if(color.equals("blue")){
			%>
			<p><%=name %>이 좋아하는 색은 파랑색 입니다.</p>
			<div style="width: 200px;padding: 50px; background: blue;"> </div>
			<%
		}else if(color.equals("red")){
			%>
			<p><%=name %>이 좋아하는 색은 빨강색 입니다.</p>
			<div style="width: 200px;padding: 50px; background: red;"> </div>
			<%
		}else if(color.equals("yellow")){
			%>
			<p><%=name %>이 좋아하는 색은 노랑색 입니다.</p>
			<div style="width: 200px;padding: 50px; background: yellow;"> </div>
			<%
		}else {
			%>
			<p><%=name %>이 좋아하는 색은 초록색 입니다.</p>
			<div style="width: 200px;padding: 50px; background: green;"> </div>
			<%
		}
		
		
	/* 	// 방법 2(주로 사용하는 방법)
		if(color=="blue"){
			msg="파랑";
		}else if(color=="red"){
			msg="빨강";
		}else if(color=="yellow"){
			msg="노랑";
		}else {
			msg="초록";
		} */
		
	%>
	<%-- <%=name %>님이 좋아하는 색은<%=msg %>입니다.
	<div style="width: 200px;padding: 50px; background: <%=color%>;"> </div> --%>

</body>
</html>