package com.prjFileUpload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//@MultipartConfig(

//location = "업로드할 파일의 저장 폴더 로컬절대 경로",
////==> 파일 업로드 시에 임시 저장 디렉터리를 지정한다. 자료형(String)
//maxFileSize = -1(무한대), // ==> 업로드할 파일의 최대 크기를 지정한다. 자료형(long)
//maxRequestSize = -1 // ==> request 시에 최대 크기를 지정한다. 자료형(long)
//fileSizeThreshold = 1024)
////--> fileUpload 시에 메모리에 저장되는 임시 파일 크기를 정의, 자료형(int)

@MultipartConfig(
		maxFileSize = 1024*1024*5, // 5m
		maxRequestSize = 1024*1024*5 // 50m
		)

@WebServlet("/fu")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileUpload() {
    	
        
    }
    
//	String file = "C:\\Users\\KoTaehoon\\Desktop\\cloud_edu\\JSP_Servlet\\study\\FileTest\\src\\main\\webapp\\upload\\01_JSP&Servlet.pdf";
//	
//	//----------- 파일의 이름 및 경로-------------------------------------
//	String fileName = file.getName(); // 경로를 제외한 파일 이름
//	String parentFolder = file.getParent(); // 파일을 제외한 경로
//	String fileAllName = file.getPath(); // 경로를 포함한 파일이름
//	String filePath = file.getAbsolutePath(); // 파일의 경로
//	
//	out.write("<p>파일명: " + fileName +"<br />");
//	out.write("폴더경로: " + parentFolder +"<br />");
//	out.write("전체경로: " + fileAllName +"<br />");
//	out.write("절대경로: " + filePath +"<p/>");
//	
//	//------------------확인------------------------------
//	File folder = new  File("C:\\Users\\KoTaehoon\\Desktop\\cloud_edu\\JSP_Servlet\\study\\FileTest\\src\\main\\webapp\\upload");
//	out.write("<p>파일존재여부: " + file +"<br />");
//	out.write("폴더존재여부: " + folder.exists() +"<br />");
//	out.write("디렉토리여부: " + folder.isDirectory() +"<br />");
//	out.write("디렉토리여부: " + file.isDirectory() +"<p/>");
//	
//	File[] files = folder.listFiles();
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName=""; 
		String exName = "";
		String orgName = "";
		String folderName ="C:\\Users\\KoTaehoon\\Desktop\\cloud_edu\\JSP_Servlet\\study\\FileTest\\src\\main\\webapp\\fileupload";

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); // 브라우저에 값을 출력하기 위함
		

		// 업로드된 파일은 getPart()를 통해 받는다.
		//Part part = request.getPart("uploadFile"); // 받아오는 파일명과 같아야함, requset.getParameter()와 동일 사용법
		
		//-----------------파일 하나만 등록하는 경우--------------------------------------------------
//		   out.print(part.getSubmittedFileName()); //전송된 파일의 이름값 출력
//		   String ContentType = part.getHeader("Content-Disposition"); // part.getHeader("Content-Disposition");에 filename=을 포함하고 있으면 파일에 해당하므로 업로드한 파일 데이터를 처리
		   
		   //------------- part.getSumittedFileName(); 만들시 사용
//		   int hpos = ContentType.indexOf("filename") + 10; // filename의 인덱스 값 구하는 곳 
//		   String orgName= ContentType.substring(hpos).trim(); // 맨앞 " 제외하고 맨위 글자 까지 가져 오는 것 //
//		   //orgName = "자바 작명 규칙.txt\"".substring(0,"자바 작명규칙.txt\" ..indexof("\""));
//		   orgName = orgName.substring(0, orgName.indexOf("\"")); // 맨마지막 " 제외
		   
		   //------------- 여러개 파일 값 -----------------------------------------------
		   Collection<Part>parts = request.getParts(); // 여러개 파일 받아오는 것
		   for(Part part : request.getParts()) { // 요청된 파일의 갯수 만큼 반복
			   
			   orgName = part.getSubmittedFileName(); // 요청된 파일의 이름 가져오는 것
//			   System.out.println(orgName);
			   
			   firstName = orgName.substring(0,orgName.lastIndexOf(".")); // 파일 앞 이름 => 01_JSP&Servlet1
			   exName = orgName.substring(orgName.indexOf(".")); // 파일 뒤쪽 이름 => .pdf
//			   System.out.println(firstName + " " + exName);
//		   String filePath = folderName + "\\" + orgName; // 파일 저장 경로 = 폴더명 : 파일원본이름
//		   String filePath;
			   File file = new File(folderName + "\\" + orgName); // folderName \ orgName
//		   String fileName = "";
			   String regName = orgName; // 데이터베이스에 저장할 파일명, 새로운 파일을 추가할때 원본 이름을 저장하기 위함
			   
			   int cnt =1; // 파일명 변경을 위한 변수
			   while(file.exists()) { // 파일이 존재할 경우 반복 abcdef.txt = 파일 있는지 ? => abcdef1.txt(중복) => abcdef2.txt(중복) => 저장
				   
				   regName = firstName + cnt++ + exName; // 중복되는 파일이 있는 경우 숫자를 붙여줘서 파일 중복을 없앤다
				   file = new File(folderName + "\\" + regName);
//			   out.write(folderName + "\\" + regName);
			   }
			   
			  part.write(folderName + "\\" + regName);
			  out.print("<a href='fd?filename=" + regName + "'>파일다운로드("+ regName +")</a><br>" ); // 파일 다운로드
		   }
		   
		   
		   //out.print(orgName.substring(orgName.indexOf("."))); // orgName을 기준으로 확장자명 앞 .위치 까지 찾기
//		   out.print(orgName);
		
	}

}
