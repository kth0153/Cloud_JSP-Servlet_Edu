package com.JDBCList;

import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/JDBCList")
public class JDBCList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public JDBCList() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String start = request.getParameter("start");
		String len = request.getParameter("len");
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			out.print("드라이브 로딩 성공<br>");
			String url = "jdbc:mysql://localhost:3307/jdbc_test?severTimezone=UTC";
			String user = "root";	// 연결 DB 사용자명
			String passwd = "gwang_1";	// 연결 DB 비밀번호
			
			Connection conn = DriverManager.getConnection(url, user, passwd);
//			out.print("MySQL 연결 성공<br>");
			
			String sql = "select fidx, femail, fname, fpass, fhobby, faddr, fdate from tmember limit "+ start+", "+ len+ ";";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			String prtTag = "";
			String rsFidx,rsEmail, rsName, rsHobby, rsAddr,rsDate;
			prtTag="[";
			while(rs.next()) { // db 쿼리 실행 결과 출력을 위해 사용
			rsFidx = rs.getString("fidx");
			rsName = rs.getString("fname");
			rsEmail =  rs.getString("femail");	// 해당 컬럼의 값 출력
			rsHobby = rs.getString("fhobby");
			rsAddr = rs.getString("faddr");
			rsDate = rs.getString("fdate");
			prtTag += "{\"fidx\" : \""+rsFidx+"\", \"fname\" : \""+rsName+"\", \"fhobby\" : \""+rsHobby+"\", \"faddr\" : \""+rsAddr+"\", \"femail\" : \""+rsEmail+"\", \"fdate\" : \""+rsDate+"\"},";
			
			}
			prtTag = prtTag.substring(0, prtTag.length()-1); // 마지막 , 제외 
			prtTag = prtTag+"]";
			out.println(prtTag);
			System.out.println(prtTag);
			
		}  catch (ClassNotFoundException e) { // 드라이버 로딩, Class.forName("com.mysql.jdbc.Driver"); 에 대한 에러 처리
//			out.println("ClassNotFoundException:"+e.getMessage());
			System.out.println("ClassNotFoundException:"+e.getMessage());
		}  catch (SQLException e) { // 서버 처리부, conn = DriverManager.getConnection(url, user, passwd); PreparedStatement pstmt = conn.prepareStatement(sql);에 대한 에러 처리
//			out.println("SQLException:"+e.getMessage());
			System.out.println("SQLException:"+e.getMessage());
		}  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
