package pkgStudy;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.Part;

public class FileUpload {
	public int fileUpload(Collection<Part> parts) {
		
		String firstName="";	// 파일 앞쪽 이름(ex - file.jsp => file)
		String exName = "";		// 파일 뒤쪽 이름(ex - file.jsp => .jsp)
		String orgName = "";	// 파일 처음 받아온 이름(ex - file.jsp)
		long fileSize = 0; // 전송된 파일의 size
		int idx=0; // 새로 등록할 파일정보 P/K 값(FIDX)
		String strSQL="";
		int fboardidx = 0;
		
		BbsDAO bbs = new BbsDAO(); // DB 연결을 위한 BbsDAO() 호출
		bbs.bbsConnect(); // DB 드라이브 연결
		
		idx = bbs.getFileIdx(); // 파일 idx 최대값 가져오는 곳 select IFNULL(max(fidx)+1,1) aidx from TBOARD_FILE;
		strSQL = "insert into TBOARD_FILE(FIDX,FBOARDIDX,FFILENAME,FSAVENAME,FFILESIZE) values"; // 파일 테이블 삽입 쿼리문
		
		for(Part part : parts) { // Collection<Part> parts로 파라미터값을 가져오기에 parts 값을 사용
		if(part.getSubmittedFileName()!=null) { // 다른 입력 요소 제외 파일명이 전달된 것만 처리(파일이 있을경우)
			System.out.println(part.getSubmittedFileName());
			
			String uploadFilePath = "C:\\Users\\KoTaehoon\\Desktop\\cloud_edu\\JSP_Servlet\\study\\JSPProject-main\\src\\main\\webapp\\fileupload\\"; // 맨뒤 \\ 생략하거나 넣거나 가능, 업로드 파일 경로
			String regFileName=""; // 중복되는 파일 이름
			
			orgName = part.getSubmittedFileName(); // 요청된 파일의 이름 가져오는 것
			if(!orgName.isEmpty()) { // 파일 이름이 있을 경우에만 파일 이름 가공
			firstName = orgName.substring(0,orgName.lastIndexOf(".")); // '.'을 기준으로 0~'.' 까지 파일 앞 이름 => 01_JSP&Servlet1
			exName = orgName.substring(orgName.indexOf(".")); // '.' ~ 마지막 인덱스 까지 파일 뒤쪽 이름 => .pdf
			}
			// ===================파일 중복 체크 후 새 파일명 생성===================
			File file = new File(uploadFilePath + orgName); // 업로드 경로 + 맨처음 받아온 파일명
			                                                // C:\\Users\\KoTaehoon\\Desktop\\cloud_edu\\JSP_Servlet\\study\\JSPProject-main\\src\\main\\webapp\\fileupload\\ + Hello.jsp
			int cnt=1; // 중복된 파일명 뒤에 붙일 값
			regFileName = orgName; // 중복되지 않는 파일이 업로드 된 경우 대비
			while(file.exists()) { // file.exists() : 파일의 존재 유무 확인 / 업로드 된 파일 명과 동일한 것이 있는지 판단
						           // 중복된 파일이 있는 경우 종복된 파일명이 존재하지 않을 때 까지 파일명 변경
				
				// 1. 파일명 만들기
				 regFileName = firstName + (cnt++) + exName; // 중복되는 파일이 있는 경우 숫자를 붙여줘서 파일 중복을 없앤다
				 file = new File(uploadFilePath + regFileName); // 기존의 파일 + 새로 만들어질 파일명
				
			} // e:while(file.exists())
			
			// uploadFilePath에 지정된 폴더로 클라이언트에서 전송된 파일을
			// 새로 만들어진 이름으로 저장
			file = new File(uploadFilePath);
			if(!file.exists()) { // 해당 경로에 폴더가 없다면
				file.mkdirs(); // 해당 경로에 폴더를 생성
				}
			fileSize = part.getSize(); // Part 에서 전송된 파일의 크기를 반환 받음
//				out.println(regFileName);
			
			try {
				part.write(uploadFilePath + regFileName); // 새로 만들어진 이름으로 파일 저장
			} catch (IOException e) {

				e.printStackTrace();
			}
			
			// ===================파일 중복 체크 후 새 파일명 생성 끝===================
			
				if(idx>0) { // P/K 값을 정상적으로 받아온 경우, -1은 장애발생을 의미
					strSQL += "('"+(idx++) +"','"+fboardidx+"','"+orgName+"','"+regFileName+"','"+fileSize+"'),"; // idx 값을 증가 시켜줘야 함!!!
				}// e:if(idx>0)

			}// e:if(part.getSubmittedFileName()!=null) ==> 실제 파일이 있을 경우 처리 부분
			
		}// e:for(Part part : request.getParts()) ==> 여러 파일 반복 끝
		
		strSQL = strSQL.substring(0, strSQL.length() - 1); // 마지막 ',' 제거, 0 ~ strSQL의 마지막 앞 까지만 추출
		if (!orgName.isEmpty()) {
			System.out.println(bbs.addFile(strSQL)); //
		}// e:if (!orgName.isEmpty()) ==> orgName이 없을 경우 확인 끝

		return bbs.addFile(strSQL); // 삽입된 sql 값 전달
	}
	
	
}
