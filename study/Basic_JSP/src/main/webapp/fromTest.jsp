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

	<form action = "formTestPost.jsp" name="frm1" method="post">
		<p><label for="name">이름 : </label><input type="text" name="name" id="name"/></p>
		<p><label for="color">좋아하는 색상 : </label>
		<select name="color" id="color">
			<option value="blue">파랑색</option>
			<option value="red">빨강색</option>
			<option value="yellow">노랑색</option>
			<option value="green">초록색</option>
		</select>
		</p>
		<p><input type="submit" value="전송하기"/></p>
	</form>

</body>
</html>