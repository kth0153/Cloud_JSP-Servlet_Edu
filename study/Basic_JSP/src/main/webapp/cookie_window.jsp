<%
//220927 수업

	// 창 닫기 버튼을 누르게 되면 쿠키 값을 생성해 결과 값 반환
	Cookie cookie = new Cookie("window","1"); // 쿠키 생성
	cookie.setMaxAge(60*2); // 쿠키 생성 시간 설정
	response.addCookie(cookie); // 쿠키 삽입
	
	Cookie[] cookies = request.getCookies(); // 모든 쿠키값 저장
	String result = "0";
	if(cookies!=null){ // 쿠키 값이 있을 경우
		for(Cookie c : cookies){ // 쿠키 값 확인
			if(c.getName().equals("window")){
				result="1";
				break;
			}
		}
	out.print(result); // ajax에 data 값 넘기기 위해 브라우져에 출력
%>