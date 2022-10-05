package pkgMVC;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerMVC
 */
@WebServlet("/MVC")
public class ControllerMVC extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ControllerMVC() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=EUC-KR");
		
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();// URI
		String path = request.getContextPath();
		String command = uri.substring(path.length()); // 요청 경로
		
		out.println("<p>URI : " + uri+"</p>");
		out.println("<p>PATH : " + path+"</p>");
		out.println("<p>command : " + command+"</p>");
		System.out.println("uri : " + uri);
		System.out.println("path : " + path);
		System.out.println("command : " + command);
		
		String url = "";
		if(command.equals("/join.do")) {		
			url="/join.jsp";
		}
		else if(command.equals("/chklogin.do")) { // 전송된 데이터로 로그인 실행  
			MemLogin chkMem = new MemLogin();
			if(chkMem.chkLogin(request)) { // 로그인 성공
				url="/login.jsp";
			}else { // 로그인 실패
				url="/nonMem.jsp";
			}
		}
		else { // 지정된 이외의 경로가 들어온 경우 처리
			url="";
		}
		
		out.println(url);
		
		// ===================== 페이지 이동 =================
		RequestDispatcher fw = request.getRequestDispatcher(url);
		fw.forward(request, response);
		// ===================================================
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
