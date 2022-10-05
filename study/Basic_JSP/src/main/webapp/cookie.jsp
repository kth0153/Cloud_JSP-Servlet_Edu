<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>220927 수업 cookie</title>
</head>
<body>
	<!-- 
	[쿠키 생성]
	- Cookie cookie = new Cookie("cookieName","value1"); // 쿠키 생성
	- cookie.setValue("value2"); // 쿠키 값 재설정 -> 잘 사용 하지 않음
	- cookie.setMaxAge(60*2); // 쿠키 유지 시간 설정(초단위); - 60*60*24(하루 설정)
	- response.addCookie(cookie); // 쿠키를 클라이언트로 전송
	
	- 여러개 쿠키 생성시
	- response.addCookie(new Cookie("cookieName1","value1"));
	- response.addCookie(new Cookie("cookieName2","value2"));
	- response.addCookie(new Cookie("cookieName3","value3"));
	
	- 쿠키 삭제 시 cookieName, setMaxAge 값 초기화 시켜야 함
	
	[쿠키 로드(읽어오기)]
	- Cookie[] cookies = request.getCookies(); // client에서 쿠키를 받아옴
	- (cookies != null) // 쿠키 유무 확인
	- cookies[num].getName() // 쿠키 이름 얻기
	- cookies[num].getValue() // 쿠키 값 얻기
	
	- Cookie.setComment("쿠키에 대한 설명"); // 의미 없음
	 -->
	
	<%
		/* Cookie cookie = new Cookie("name","홍길동"); // 쿠키명 name으로 홍길동 저장
		cookie.setMaxAge(60*60); // 쿠키 유지 시간 설정(초단위);
		response.addCookie(cookie); // 쿠키를 클라이언트로 전송 */
		Cookie[] cookies = request.getCookies(); // client에서 쿠키를 받아둠
		out.println("쿠키의 길이 : " + cookies.length+"<br>"); // 2
		out.println("쿠키의 값 : " + cookies[0].getValue()+"<br>");
		
		if(cookies!=null) {
			for(int i=0;i<cookies.length;i++){ // for(Cookie c : cookies)
				//if(cookies[i].getName().equals("name")){
					out.println(cookies[i].getValue()); 
				//}
				// out.println(cookies[i].getName()); // c.getName();
			}
		}
		
		Cookie clearCookie = new Cookie("name",null); // 쿠키명 name을 null로 치환
		clearCookie.setMaxAge(0);
		response.addCookie(clearCookie);
		/* out.print(cookies.length); */
	%>
	
</body>
</html>