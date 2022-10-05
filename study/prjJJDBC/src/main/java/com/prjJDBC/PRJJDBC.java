package com.prjJDBC;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;


@WebServlet("/pj")
public class PRJJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PRJJDBC() {
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
//		
//		String strEmail = request.getParameter("temail");
//		String strName = request.getParameter("tname");
//		String strPwd = request.getParameter("tpwd");
////		String[] arrHobby = request.getParameterValues("thobby");
////		String strHobby = String.join(",", arrHobby); // 배열값으로 가져오는 hobby 문자열로 변경
//		String strAddr = request.getParameter("taddr");
//		
		String url = "jdbc:mysql://localhost:3307/study?severTimezone=UTC"; // 해당DB정보/DB주소/DB명?severTimezone=UTC
		String user = "root";	// 연결 DB 사용자명
		String passwd = "gwang_1";	// 연결 DB 비밀번호
//		
		try { 
			Class.forName("com.mysql.jdbc.Driver"); // 자바에서 MySQL을 사용하기 위한 드라이버 설정
			out.print("드라이버 로딩 성공");
			
			Connection conn = null;
			conn = DriverManager.getConnection(url, user, passwd);
			
		}  catch (ClassNotFoundException e) {
		
			System.out.println("ClassNotFoundException:"+e.getMessage());
		}  catch (SQLException e) {
	
			System.out.println("SQLException:"+e.getMessage());
		}  
		
				
//		String sql = "insert into tmember(femail,fname,fpass,fhobby,faddr,fdate) "
//				+ "values('"+strEmail+"','"+strName+"',"+strPwd+"','"+strHobby+"',"+strAddr+"',SYSDATE())";
//		
//		out.print(sql);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
