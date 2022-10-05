package com.prjFileUpload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/fd")
public class FileDownLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileDownLoad() {
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String fileName = request.getParameter("filename");
		String folder = "C:\\Users\\KoTaehoon\\Desktop\\cloud_edu\\JSP_Servlet\\study\\FileTest\\src\\main\\webapp\\fileupload\\"; // 파일 업로드한 폴더 DownLoadPath
		String filePath = folder + fileName;
		
		// 파일 이름이 한글일 경우를 대비해 URF-8로 인코딩함
		String encodingFileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
		
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=UTF-8");

		byte[] b = new byte[4096]; // 4kb
		FileInputStream fileInputStream = new FileInputStream(filePath); // 다운 받은 파일 경로 
		
		String sMimeType = getServletContext().getMimeType(filePath);
		if(sMimeType == null) {
			sMimeType = "application/octet-stream";
		}
		
		// 다운 로드 받을 수 있게 설정(파일 MINE 타입 얻어오기)
		response.setContentType(sMimeType);
		response.setHeader("Content-Disposition", "attachment; filename=" + encodingFileName); // 다운받을 때 원본 파일 이름과 같은 것 다운 받게 하는 것
		
		ServletOutputStream stream = response.getOutputStream();
		int read;
		while((read = fileInputStream.read(b,0,b.length))!= -1) { // -1 데이터 최대 크기 지정
			stream.write(b,0,read);
		}	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
