package com.jdbcCtr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// JDBC 필요 객체 import
import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;

@WebServlet("/JDBCCtr")
public class JDBCCtr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JDBCCtr() {
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
//		
		String strEmail = request.getParameter("temail");
		String strName = request.getParameter("tname");
		String strPwd = request.getParameter("tpwd");
		String[] arrHobby = request.getParameterValues("thobby");
		String strHobby = String.join(",", arrHobby); // 배열값으로 가져오는 hobby 문자열로 변경
		String strAddr = request.getParameter("taddr");
//		
		String url = "jdbc:mysql://localhost:3307/jdbc_test?severTimezone=UTC"; // 해당DB정보/DB주소/DB TABLE명?severTimezone=UTC
		String user = "root";	// 연결 DB 사용자명
		String passwd = "gwang_1";	// 연결 DB 비밀번호
		
		try { 
			Class.forName("com.mysql.jdbc.Driver"); // 자바에서 MySQL을 사용하기 위한 드라이버 설정, 드라이브 로딩
			out.print("드라이버 로딩 성공");
			
			Connection conn = null;
			conn = DriverManager.getConnection(url, user, passwd);
			String sql = "insert into tmember(femail,fname,fpass,fhobby,faddr,fdate) "
					+ "values('"+strEmail+"','"+strName+"','"+strPwd+"','"+strHobby+"','"+strAddr+"',SYSDATE())";
			System.out.println(sql);
			// String sql = "insert into tmember(femail,fname,fpass,fhobby,faddr,fdate) values('1','2','3','1,2','부산',SYSDATE());";
			// String sql = "delete from tmember where idx = 1";
			// String sql = "update tmember set femail='123@13', fname='홍길동', fpass='1234', fhobby='1,2,3,4,5', faddr='부산' where fidx=2;";
			
			
			PreparedStatement pstmt = conn.prepareStatement(sql); // 데이터베이스 스테이트먼트 생성
			int rowCnt = pstmt.executeUpdate(); // select문을 제외한 쿼리문 실행
			System.out.println(rowCnt);
			
		}  catch (ClassNotFoundException e) { // 드라이버 로딩, Class.forName("com.mysql.jdbc.Driver"); 에 대한 에러 처리
//			out.println("ClassNotFoundException:"+e.getMessage());
			System.out.println("ClassNotFoundException:"+e.getMessage());
		}  catch (SQLException e) { // 서버 처리부, conn = DriverManager.getConnection(url, user, passwd); PreparedStatement pstmt = conn.prepareStatement(sql);에 대한 에러 처리
//			out.println("SQLException:"+e.getMessage());
			System.out.println("SQLException:"+e.getMessage());
		}  
//		out.print(sql);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
