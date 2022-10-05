package pkgStudy;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/CW")

//-------------------------------------------------------------------------------------------------------------------------
/*
 * 서블릿 3.0에서는 InputStream이나 외부 라이브러리를 사용하지 않고도 웹 브라우저가 업로드한 파일을 읽어 올 수 있는 기능 추가
 * 2가지 파일 업로드 처리 방법 - 1. httpServletRequest의 getPart() 메서드를 이용해서 업로드 데이터 접근 - 2.
 * 서블릿이나 multipart 데이터를 처리할 수 있도록 설정 => @MultipartConfig 애노테이션을 사용하거나 =>
 * web.xml에서 < multipart-config> 태그 사용
 * 
 * enctype="multipart/form-data" : 파일 전달하기 위해 필수 요소!!
 * enctype="multipart/form-data" 형식으로 전송된 데이터는 request.getParameter()와 같은 메서드로는
 * 접근 할 수 없다. 서블릿 3.0에 새롭게 추가된 Part 인터페이스를 사용해서 접근해야 한다.
 * 
 * <접근 방식> - 1. HttpServletRequest, getContentType()을 이용해서 "multipart/form-data"
 * 인지 확인한다. - 2. "multipart/form-data"인 경우 => HttpServletRequest의 getParts()나
 * getPart(name) 메서드를 이용해서 Part를 구한다. => Part의 Content-Disposition 헤더가
 * "filename="을 포함하면, 파일로 처리한다. => "filename="을 포함하지 않으면 파라미터로 처리한다.
 */

@MultipartConfig(maxFileSize = 1024 * 1024 * 5, // 5m
		maxRequestSize = 1024 * 1024 * 5 // 50m
)
//-------------------------------------------------------------------------------------------------------------------------
public class CtrlWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CtrlWrite() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // post 방식만 가능
												// 서블릿에서 post 방식으로 서버에 전달 시
												// jsp나 html에서 전달한 한글 값을 깨지지 않게 전달 하기 위한 설정
												// get 방식의 경우 tomcat이 기본적으로 UTF-8문자 코드가 적용 되게 자동으로 처리
		response.setCharacterEncoding("utf-8"); // post, get 방식 둘다 가능
												// 서블릿에서 직접 브라우저에 출력해줄 경우 사용
												// servlet 화면에 데이터를 출력하기 위해 out.println을 사용하는데 이때 한글 값이 깨지지 않게 설정
		response.setContentType("text/html;charset=utf-8"); // post, get 방식 둘다 가능
		PrintWriter out = response.getWriter(); // 브라우저에 출력하기 위함

		String top = ""; // 상단 체크박스
		String header = ""; // select
		String writer = ""; // 작성자
		String subject = ""; // 제목
		String content = ""; // 내용
		String passw = ""; // 비밀번호

		if (request.getParameter("top") != null && !"".equals(request.getParameter("top"))) {
			top = request.getParameter("top"); // null, 공백문자열("")이 아닌 경우 값을 저장
		}
		if (request.getParameter("header") != null && !"".equals(request.getParameter("header"))) {
			header = request.getParameter("header");
		}
		if (request.getParameter("writer") != null && !"".equals(request.getParameter("writer"))) {
			writer = request.getParameter("writer");
		}
		if (request.getParameter("subject") != null && !"".equals(request.getParameter("subject"))) {
			subject = request.getParameter("subject");
		}
		if (request.getParameter("content") != null && !"".equals(request.getParameter("content"))) {
			content = request.getParameter("content");
		}
		if (request.getParameter("passw") != null && !"".equals(request.getParameter("passw"))) {
			passw = request.getParameter("passw");
		}

		out.println(top);
		out.println(header);
		out.println(writer);
		out.println(subject);
		out.println(content);
		out.println(passw);

		// out.print("서블릿 성공");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		// ================ 게시판 변수 ==============
		// 문자열로 저장 "" 로 초기화
		String top = ""; // 상단 체크박스
		String header = ""; // select
		String writer = ""; // 작성자
		String subject = ""; // 제목
		String content = ""; // 내용
		String passw = ""; // 비밀번호

		if (request.getParameter("top") != null && !"".equals(request.getParameter("top"))) {
			top = request.getParameter("top");
		} else {
			top = "No"; // 체크 박스 체크 하지 않았을 경우 null 값 대신 DB에 설정한 값인 'No' 지정
		}

		if (request.getParameter("header") != null && !"".equals(request.getParameter("header"))) {
			header = request.getParameter("header");
		}
		if (request.getParameter("writer") != null && !"".equals(request.getParameter("writer"))) {
			writer = request.getParameter("writer");
		}
		if (request.getParameter("subject") != null && !"".equals(request.getParameter("subject"))) {
			subject = request.getParameter("subject");
		}
		if (request.getParameter("content") != null && !"".equals(request.getParameter("content"))) {
			content = request.getParameter("content");
		}
		if (request.getParameter("passw") != null && !"".equals(request.getParameter("passw"))) {
			passw = request.getParameter("passw");
		}
//		out.println(top);
//		out.println(header);
//		out.println(writer);
//		out.println(subject);
//		out.println(content);
//		out.println(passw);

		// out.print("서블릿 성공");

		// ================= 답변글에 대한 데이터 취득부분 ============================
		// int 값으로 저장 "0"으로 초기화
		// 답변 값은 Hidden 값으로 받아오게 설정 되어 있음
		String qidx = "0"; // 답변 번호 = 해당 글번호
		String group = "0"; // 답변의 그룹 - 답변 번호와 같음
		String level = "0"; // 답변의 들여쓰기
		String step = "0"; //
		String list = "0";
		// ================= 정규표현식 ===============================================
//		 - [0-9] : 문자열 중에서 0 ~ 9 까지의 숫자가 들어있는 문자열은 모두 해당 [0123456789] 와 같은 의미
//		 - [^] : 캐럿(^)은 반대를 의미, !와 같은 의미
//		   [^0-9] : 문자열 중에서 0 ~9 를 제외한 문자열 (a-z, A-Z)가 해당

		if (request.getParameter("idx") != null && !"".equals(request.getParameter("idx"))
				&& request.getParameter("idx").matches("[0-9.]+"))
			qidx = request.getParameter("idx");

		if (request.getParameter("group") != null && !"".equals(request.getParameter("group"))
				&& request.getParameter("group").matches("[0-9.]+"))
			group = request.getParameter("group");

		if (request.getParameter("level") != null && !"".equals(request.getParameter("level"))
				&& request.getParameter("level").matches("[0-9.]+"))
			level = request.getParameter("level");

		if (request.getParameter("step") != null && !"".equals(request.getParameter("step"))
				&& request.getParameter("step").matches("[0-9.]+"))
			step = request.getParameter("step");

		if (request.getParameter("list") != null && !"".equals(request.getParameter("list"))
				&& request.getParameter("list").matches("[0-9.]+"))
			list = request.getParameter("list");

		// ================= 답변글에 대한 데이터 취득부분 끝 ============================

		// ======================전송 데이터====================
		// FIDX, FNUM, FGROUP, FLEVEL, FSTEP, FTOP, FPARTIDX, FSUBJECT, FCONTENT,
		// FID, FNAME, FPASSW, FDELETED, FDATE

		// 받아온 파라미터 값을 LIST에 저장에서 DAO에서 처리
		List<String> req = new ArrayList<String>();

		req.add(top); // FTOP
		req.add(header); // FPARTIDX
		req.add(subject); // FSUBJECT
		req.add(content); // FCONTENT
		req.add(""); // FID
		req.add(writer); // FNAME
		req.add(passw); // FPASSW
		req.add(qidx); // FIDX
		req.add(group); // FGROUP
		req.add(level); // FLEVEL
		req.add(step); // FSTEP
		req.add(list); //

		// ============데이터베이스 연결=================================
		BbsDAO bbs = new BbsDAO(); // 사용자 객체 생성

		// ================= 게시물 등록부분 ============================
		// bbs.addBoard(req);
		// forward를 통해 이동할 수 있는 준비
		int[] keyVal = bbs.addBoard(req); // list에 저장한 값들을 처리한 후 반환된 값 keyVal로 저장
		if (keyVal == null)
			out.print("null"); // 에러 발생시 에러 페이지 생성 후 redirect 하는 것이 좋음

		// ================= 게시물 등록부분 끝 ============================

		// ============데이터베이스 메서드 호출=================================
		bbs.bbsConnect(); // 객체 메서드 호출(실행)

		// ============파일관련===============================================================
		// ================ 파일 변수 ==============
		String firstName = ""; // 파일 앞쪽 이름(ex - file.jsp => file)
		String exName = ""; // 파일 뒤쪽 이름(ex - file.jsp => .jsp)
		String orgName = ""; // 파일 처음 받아온 이름(ex - file.jsp)
		long fileSize = 0; // 전송된 파일의 size
		int idx = 0; // 새로 등록할 파일정보 P/K 값(FIDX)
		
		// FileSystem objFile = FileSystems.getDefault(); // return value : 업로드 파일 갯수
		
		Collection<Part> parts = request.getParts();
		
		FileUpload upFile =new FileUpload();
		upFile.fileUpload(parts);
		
		
		// out.println(strSQL);

		// doGet(request, response);
		// ======================================================
		// forward()를 통한 이동
		// import javax.servlet.RequestDispatcher; 필요
		RequestDispatcher fw = request.getRequestDispatcher("/view.jsp"); // 이동 경로

		// 배열로 출력
//		String KeyName[] = {"idx","group","level","step","list"};
//		for(int i=0; i<KeyName.length;i++) {
//			
//				request.setAttribute(KeyName[i],keyVal[i]);				
//	
//		}
		request.setAttribute("idx", keyVal[0]); // "키이름","값" write.jsp로 가져갈 값
		request.setAttribute("group", keyVal[1]);
		request.setAttribute("level", keyVal[2]);
		request.setAttribute("step", keyVal[3]);
		request.setAttribute("list", keyVal[4]);
		fw.forward(request, response);

	} // e:protected void doPost

}
