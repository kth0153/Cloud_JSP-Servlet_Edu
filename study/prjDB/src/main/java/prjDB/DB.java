package prjDB;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DB
 */
@WebServlet("/DB")
public class DB extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DB() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		String strURI = "";
		RequestDispatcher dispatcher;
		
		if(command.equals("/board.do")) {		
			strURI="list.jsp";
			request.setAttribute("page", 1);
			dispatcher = request.getRequestDispatcher(strURI);
			dispatcher.forward(request, response);
		}
		
		// ===================== 페이지 이동 =================
//		dispatcher = request.getRequestDispatcher(url);
//		fw.forward(request, response);
		// ===================================================
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
