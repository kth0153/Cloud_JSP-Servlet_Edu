package pkgMVC;

import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemLogin {
	public boolean chkLogin(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		
		String userId = "root";
		String userPw = "1234";
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		System.out.println(pw);
		System.out.println(id);
		System.out.println(pw);
		System.out.println(email);
		
		if(userId.equals(id) && userPw.equals(pw)) { // 로그인 비밀번호, 아이디 동일 시 세션 생성
			HttpSession session = request.getSession(); // session 객체 생성
			session.setAttribute("sessName", name);
			session.setAttribute("sessId", id);
			session.setAttribute("sessPw", pw);
			session.setAttribute("sessEmail", email);
			return true;
		}
		else return false;
	}
}
