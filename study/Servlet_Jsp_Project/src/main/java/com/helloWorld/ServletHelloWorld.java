package com.helloWorld;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletHelloWorld
 */
@WebServlet("/SHW")
public class ServletHelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get 방식으로 받아올때
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset-euc-kr");
		
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("temail");
		String name = request.getParameter("tname");
		String pwd = request.getParameter("tpwd");
		String[] hobby = request.getParameterValues("thobby");
		String addr = request.getParameter("taddr");
		String labelText;
		
		for(int i=0;i<hobby.length;i++) {
			if(hobby[i].equals("1")) {
				labelText = "운동";
			}else if(hobby[i].equals("2")) {
				labelText = "운동";
			}else if(hobby[i].equals("3")) {
				labelText = "운동";
			}else if(hobby[i].equals("4")) {
				labelText = "운동";
			}else if(hobby[i].equals("5")) {
				labelText ="음악감삼";
			}else {
				System.out.println("해당 값 없음");
			}
		}
		
		// json 데이터로 값을 전달하기 위해서는 제이슨 형식으로 값을 가공해서 전달해야한다.{"key값" : "value 값"}
		String jsonData = "{ \"email\" : \""+email+"\", \"name\" : \""+name+"\", \"pwd\" : \""+pwd+"\", \"hobby\" : "+Arrays.toString(hobby)+",\"addr\" : \""+addr+"\" }";
		
		System.out.println(jsonData);
		
		out.println(jsonData);
		
		
		//String prtHobby="";
		
//		out.println("email"+email);
//		out.println("name"+name);
//		out.println("tpwd"+pwd);
//		out.println("thobby"+hobby);
//		out.println("taddr"+addr);
//	
//		prtHobby="[";
//		for(int i=0; i<hobby.length;i++) {
//			//System.out.println(hobby[i]);	
//			//out.println("hobby : " + hobby[i]+" &nbsp;&nbsp;");
//			
//			prtHobby+="\""+hobby[i]+"\",";
//			}
		/*
		for(int i=0; i<addr.length;i++) {
			System.out.println(addr[i]);	
			out.println("address : " + addr[i]+" &nbsp;&nbsp;");
			}
		*/
//		for(String item : addr) {
//			out.println("address : " + item);
//		}
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 방식으로 받아올때
		doGet(request, response);
	}

}
