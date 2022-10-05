<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf8");
%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="prjDB.DbBean" %>
<%@ page import="prjDB.DB" %>
<%@ page import="prjDB.DBDao" %>

<!DOCTYPE html>

<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<title>목록 출력</title>
</head>
<body>
<table border="1">
	<%
	int pageNum = 1; // 리스트의 페이지 이동을 위한 페이지 번호
	int groupNum = 2; // 한번에 반환 받을 목록의 갯수(0~9, 10~19, 20~29)
	
	if(request.getAttribute("page")!=null) {
		pageNum =(Integer)request.getAttribute("page");
	}else{
		pageNum =1;
	}
	out.println("page : " + pageNum);
	
	int prev = pageNum-1;
	int next = pageNum+1;
	DBDao dao = new DBDao();
	// out.println(dao.dbConnect()); // db 연결
	ArrayList<DbBean> list = dao.getList(pageNum, groupNum);
	
	out.println("listSize : " + list.size()); // ArrayList.size() 갯수 반환, 2차 배열 형태
	for(int i=0; i<list.size();i++){
	%>
	<tr>
		<td><%=list.get(i).getIdx() %></td>
		<td><%=list.get(i).getPart() %></td>
	</tr>
	<%} %>
</table>
<a href="board.do?page=<%=prev %>">이전</a> | <a href="board.do?page=<%=next %>">다음</a>
</body>
</html>