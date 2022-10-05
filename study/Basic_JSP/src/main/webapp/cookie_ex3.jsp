<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>220927 수업 Cookie</title>

	<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
	<script src="close_window.js"></script>
	
	<style type="text/css">
		body{
			background-color: green;
			margin: 0px;
			padding: 0px;
			position: relative;
			width: 100%;
			height: 100%;
		}
		#container{
			margin: 0px;
			padding: 0px;
			width: 500px;
			height: 400px;
			background-color: #fff;
			background-color: rgba(255,255,255,0.5);
			position: absolute;
			left: 100px;
			top:100px;
			visibility: visible;
			border: 1px solid #666;
		}
		#container.hidden{visibility:hidden;}
		
	</style>
	
	
	<%
		String strClass="";
		Cookie[] cookies = request.getCookies();
		
		if(cookies!=null){
			for(Cookie c : cookies){
				if(c.getName().equals("window")){
					strClass = "hidden"; // 해당 쿠키가 있을 경우 div container를 hidden으로 숨기기 위함
					break;
				}
			}
			//strClass="";
		}
	
	%>
	
</head>
<body>
	<div id="container" class="<%=strClass %>"/>
		<div id="windowBox">
			<form>
				<input type="checkbox" name="chkBox" id="chkBox" value="1" />
				<span>2분동안 창열지 않기</span> | <span id="btnClose">창닫기</span>
			</form>
		</div>
	</div>

</body>
</html>