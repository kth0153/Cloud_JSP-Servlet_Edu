package com.clsTestPrj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClsTestPrj
 */
@WebServlet("/CTP")
public class ClsTestPrj extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ClsTestPrj() {
        super();
        // TODO Auto-generated constructor stub
    }

    // get 방식으로 받을때
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); // 브라우저에 출력 하기위해 필요
		String strTname = request.getParameter("tname");
		String strAAA = request.getParameter("aaa");
		String strBBB = request.getParameter("bbb");
		String strCCC = request.getParameter("ccc");
//		out.println(strTname);
//		out.println(strAAA);
//		out.println(strBBB);
//		out.println(strCCC);
		
		String strJson = "{ \"aaa\" : \""+strAAA+"\", \"bbb\" : \""+strBBB+",\"ccc\" : \""+strCCC+"\" }";
		
		out.println(strJson);
		
		
		
	} // http://localhost:8080/CTP?aaa=1234,
	
	
	// post 방식으로 받을때
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
