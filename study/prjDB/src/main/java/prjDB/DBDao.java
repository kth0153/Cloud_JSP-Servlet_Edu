package prjDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import prjDB.DbBean;

// =================================데이터베이스 컨트롤 클래스 =====================================
public class DBDao {
	private Connection conn; // 데이터베이스 연결
	private ResultSet rs; // 테이블 레코드 반환
	
	
	// 1. 데이터베이스 연결
	public void dbConnect() {
//		
		try { 
			String url = "jdbc:mysql://localhost:3307/study"; // 해당DB정보/DB주소/DB명?severTimezone=UTC
			String user = "root";	// 연결 DB 사용자명
			String passwd = "gwang_1";	// 연결 DB 비밀번호
			
			Class.forName("com.mysql.jdbc.Driver"); // 자바에서 MySQL을 사용하기 위한 드라이버 설정
			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("드라이버 로딩 성공");
			
			
 
		}  catch (Exception e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
			
		}  
		
	}
	
	// ================= 목록 출력 메서드, 출력을 jsp에서 함 =======================
	public ArrayList<DbBean> getList(int pageNum, int groupNum) {
			
//		1페이지		0
//		2페이지		10
//		3페이지		20
//		4페이지		30
//		5페이지		40
		
		ArrayList<DbBean> boardList = new ArrayList<DbBean>();
		
		try {
			int fieldNum = (pageNum-1)*groupNum; // 해당 페이지의 첫번째 row 반환
			
			dbConnect(); // 데이터 베이스 연결
			
			String SQL = "SELECT FIDX, FPART FROM TBOARD_PART ORDER BY FIDX DESC LIMIT "+fieldNum+", "+groupNum+"";
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			rs = pstmt.executeQuery(SQL);
			System.out.println(SQL);
			while(rs.next()) {
				DbBean board = new DbBean(); // bean 객체에 값 저장
				board.setIdx(rs.getInt("fidx"));
				board.setPart(rs.getString("fpart"));
				boardList.add(board); // list.jsp에서 가져갈 ArrayList에 DBBean을 추가
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardList; // ArrayList를 반환
	}
	

}
