package pkgStudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

// ========= 데이터베이스 관련 ===================
public class BbsDAO {
	
	private Connection conn;
	private ResultSet rs; 
	
	public void bbsConnect() {
		try {
			String dbURL = "jdbc:mysql://localhost:3307/study";
			String dbId = "root"; // 연결 DB 사용자명
			String dbPassw = "gwang_1"; // 연결 DB 비밀번호
			
			Class.forName("com.mysql.jdbc.Driver"); // 자바에서 MySQL을 사용하기 위한 드라이버 설정
			conn = DriverManager.getConnection(dbURL, dbId, dbPassw);	
			System.out.println("드라이브 로드");
		}
		catch(Exception e) {
			System.out.println(e);
		}finally {
			System.out.println("finally : DB Connection end");
		}
	}
	
	// ================= 파일처리 인덱스 값 생성하여 반환 =================
	public int getFileIdx() {
		String SQL = "";
		try {
			SQL = "select IFNULL(max(fidx)+1,1) aidx, IF(max(fboardidx)<1,max(fboardidx)+1,max(fboardidx)+1) from TBOARD_FILE;"; // IFNULL(컬럼명(null이 아닐 경우 출력), null일 경우 대체할 데이터 출력)
																		 // db에 auto_increment가 설정되지 않았기에 fidx 값을 구하기 위함
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			int idx = 1; // 초기값 주지 않아도 됨, 집합함수를 사용했을 경우 반드시 행이 반환됨
			int fboardidx = 1;
			if(rs.next()) {
				idx = rs.getInt(1);
				fboardidx = rs.getInt(2);
			}
			System.out.println(fboardidx);
			rs.close(); // ResultSet 객체를 닫아줌

			return idx;
		}
		catch(Exception e) {
			System.out.println(e);
			return -1; // 에러발생
		}
		
	}
	
	// ==================== 업로드 파일 정보 삽입 =========================
	
	public int addFile(String SQL) {
		
		try {
			int rst=0;
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rst  = pstmt.executeUpdate(SQL); // 성공시 1, 실패시 0 반환
			
			return rst; // 삽입 성공 행의 갯수 반환
		}
		catch(Exception e) {
			System.out.println(e);
			return -1; // 에러발생
		}
		
	}
	
	// ==================== 게시물 등록 =========================
	public int[] addBoard(List<String> req) {
		String SQL = "";
		try {
			int rst=0;
			ResultSet rs;
			//================= idx and group and listNum 반환
			int idx,num,grp,level,step;
			int qidx;
			bbsConnect(); // DB 드라이브 로드 ==> 데이터베이스 서버 연결, CONN은 인스턴스(전역) 변수
			SQL = "SELECT IFNULL(max(fidx)+1,1) aidx, IFNULL(max(FNUM)+1,1) anum from TBOARD;";
			      
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery(SQL);
			rs.next();
			idx = rs.getInt("aidx"); // 질문의 경우 fidx 컬럼과 fgroup의 번호는 동일
			num = rs.getInt("anum"); // 목록번호 추출(질문은 최대값+1, 답변은 0)
			grp = idx; // 그룹은 idx 값과 동일
			level = 0;
			step = 0;
			rs.close();
			
			if(Integer.parseInt(req.get(7))>0) { //답변, qidx>0 일경우
				num=0; // 답글의 경우 0
				grp=Integer.parseInt(req.get(8)); // group
				
				// ======================= 선택한 목록의 level에 +1 증가 =============
				level=Integer.parseInt(req.get(9))+1; // level
				
				// ======================= 같은 그룹내에서 나보다 크거나 같은 것들을 Update문으로 1증가(현재 insert문보다 update문이 우선적으로 되어야함)
				step =Integer.parseInt(req.get(10)); // step	
				SQL="UPDATE tboard set fstep=fstep+1 where fgroup='"+grp+"' and fstep >='"+step+"' ;";
				pstmt = conn.prepareStatement(SQL);
				rst  = pstmt.executeUpdate(SQL); 
			}

			//====================return 데이터 생성================
			int [] keyVal = {idx,grp,level,step,num};
			
			// ======================전송 데이터====================
			// FIDX, FNUM, FGROUP, FLEVEL, FSTEP, FTOP, FPARTIDX, FSUBJECT, FCONTENT, 
			// FID, FNAME, FPASSW, FDELETED, FDATE
			//=================e: idx and group and listNum 반환
			// 답변에 대한 값 삽입 후 return
			// insert 할때 sysdate()는 '' 없이 사용
			SQL="INSERT INTO TBOARD( FIDX, FNUM, FGROUP, FLEVEL, FSTEP, FTOP, FPARTIDX, FSUBJECT, FCONTENT,FID, FNAME, FPASSW, FDELETED, FDATE) VALUE"
					+ "('"+idx+"','"+num+"','"+grp+"','"+level+"','"+step+"','"+req.get(0)+"','"+req.get(1)+"','"+req.get(2)+"','"+req.get(3)+"','"+req.get(4)+"','"+req.get(5)+"','"+req.get(6)+"','No',sysdate())";
			
			pstmt = conn.prepareStatement(SQL);
			rst  = pstmt.executeUpdate(SQL); // 성공시 1, 실패시 0 반환
			
			return keyVal; // 삽입 성공한 행의 갯수 반환
		
		}
		catch(Exception e) {
			System.out.println(e);
			
			return null; // 삽입 실패시 return 값 null 반환
		}
		
	}
	// ==================== 게시물 등록 끝=========================
} //e:class
