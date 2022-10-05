<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>220926 수업 구구단 출력</title>
</head>
<body>
	<table style="border: 1px solid #eee; width : 1000px; border-collapse:collapse; text-align: center;">
	<tr>
		<td>2단</td><td>3단</td><td>4단</td><td>5단</td>
		<td>6단</td><td>7단</td><td>8단</td><td>9단</td>
	</tr>
	<%
		for(int i = 1; i<=9; i++){
			%>
			<tr>
			<%
			for(int j =2; j<=9; j++){
				%>
					<td><%=j %> * <%=i %> = <%=j*i %></td>
				<%
			}
			%>
			</tr>
			<%
		}
	%>
	</table>
</body>
</html>