<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>220926 수업 태그의 반복처리(with for)</title>
</head>
<body>

	<%!
		//String[] name = {"java","jsp","html"};
	%>
	
	<table style="border: 1px solid #eee;width:300px;border-collapse: collapse;">
	<%
		String[] name = {"java","jsp","html"};
		for(int i =0; i<name.length;i++){
			%>
			
				<tr>
					<td style="border: 1px solid #eee; text-align: center;"><%=i %></td>
					<td style="border: 1px solid #eee; text-align: center;"><%=name[i] %></td>
				</tr>
			
			<%
		}
	%>
	</table>
	
	<%
	
		float f = 2.3f;
		int i = Math.round(f); // 반올림
		java.util.Date date = new java.util.Date(); // java 클래스 파일 import
		
	%>
	
	<p>실수 f의 반올림 값은 ? <%=i %></p>
	<p>현재 날짜와 시간은 ? <%= date.toString() %> <!-- 바로 값을 가져옴 --> 

</body>
</html>