
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>220927 수업 아이디 저장</title>



</head>
<body>

	<% 
		// 체크 박스 사용 id 저장
		// String userID = request.getParameter("tid");
		// String checkbox = request.getParameter("saveId");
		//response.setCharacterEncoding("utf-8");
		// Cookie cookie = new Cookie("tid",userID);
		
		/* if(checkbox != null){
			// 체크박스 체크 되었을 때 쿠키 저장
			response.addCookie(cookie);
		}else{
			// 체크박스 체크 해제 되었을때 쿠키 유효시간 0으로 해서 브라우저에서 삭제
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		} */
		
		// radio 박스 이용 id 쿠키 값 저장 삭제
		String userID = "";
		String chk1 = "";
		String chk2 = "checked";
		
		/* 
		   경우의 수 1 : 로그인 페이지에 접속 --> 두 값이 모두 없음 --> 쿠키 정보가 있다면 텍스트 박스에 출력,
						 쿠키값이 없다면 아무 일도 안함 (쿠키 값 만들지 않는다.)
		   경우의 수 2 : getParameter() 값이 있는 경우(로그인 버튼을 클릭한 경우), 쿠키 저장? 또는 삭제? 
		*/
		String CookieID = "";
		// -------------- 일반적인 페이지 접속 -------------------------------------------   
		Cookie[] cookies = request.getCookies();
		   if(cookies!=null){
			  for(Cookie c : cookies){
				  if(c.getName().equals("id")){ // "쿠키 저장할 때 이름은 "id"로 지정"
					  chk1="checked"; // 한 번 반복
					  chk2 = "";
					  break;
				  }
				  else {
					  chk1 = "";
					  chk2="checked"; // 여러번 반복
				  }
			  }
		   }	
		// -------------- e : 일반적인 페이지 접속 -------------------------------------------   
		if(request.getParameter("tid")!=null){//전송버튼을 클릭 한 경우
				Cookie cook = new Cookie("id",null);
				cook.setMaxAge(0);
			if( request.getParameter("saveId").equals("id")){ // 아이디 저장을 선택한 경우
					cook.setValue("1");
					cook.setMaxAge(3600*24+365); // 1년간 쿠키를 저장한다 설정
					chk1="checked"; // ID 저장 버튼 클릭
					chk2=""; // ID 삭제 버튼 비활성화
					userID = request.getParameter("tid");
				}
				response.addCookie(cook);
		}else{ // 로그인 페이지에 들어온 경우
			Cookie[] cook = request.getCookies(); // 생성된 쿠키 값 가져 오는 곳
			if(cookies!=null){
				for(Cookie c : cookies){
					chk1="";
					chk2="checked";
					if(c.getName().equals("id")){
						chk1="checked";
						chk2="";
						userID=request.getParameter("saveId");
						break;
						}
					}
				}
			}
		
		/* if(request.getParameter("tid")!=null){//전송버튼을 클릭 한 경우
				Cookie cookie = new Cookie("id","1"); // 쿠키 생성("name", "value")
			if( request.getParameter("saveId").equals("id")){ // 아이디 저장을 선택한 경우
				cookie.setMaxAge(3600*24+365); // 1년간 쿠키를 저장한다 설정
				response.addCookie(cookie); // 생성한 쿠키 삽입
				chk1="checked"; // ID 저장 버튼 클릭
				chk2=""; // ID 삭제 버튼 비활성화
			}else{ // 쿠키 삭제
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				chk2="checked"; // ID 저장 버튼 클릭
				chk1=""; // ID 삭제 버튼 비활성화
			}
		}else{ // 로그인 페이지에 들어온 경우
			Cookie[] cook = request.getCookies(); // 생성된 쿠키 값 가져 오는 곳
			if(cookies!=null){
				for(Cookie c : cookies){
					chk1="";
					chk2="checked";
					if(c.getName().equals("id")){
						chk1="checked";
						chk2="";
						userID=request.getParameter("saveId");
						break;
						}
					}
				}
		} */
		
		
	%>
	<form name="fn" action="cookie_ex.jsp" method="get">
	
	<input type="text" name="tid" id="tid" maxlength="20" minlength="8" value="<%=userID%>"/><br>
	<!-- <input type="checkbox" name="saveId" value="id"/> ID 저장<br> -->
	<input type="radio" name="saveId" value="id" checked=<%=chk1 %>/> ID 저장<br>
	<input type="radio" name="saveId" value="non" checked=<%=chk2 %>/> ID 삭제<br>
	<input type="submit" value="전송"/>
	
	</form>
</body>
</html>