<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

/* int idx = (int)request.getAttribute("idx");
int group = (int)request.getAttribute("group");
int level = (int)request.getAttribute("level");
int step = (int)request.getAttribute("step");
int list = (int)request.getAttribute("list");
 */
%>    
    
    
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8"> 
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 글쓰기</title>
    <link href="css/style.css" rel="stylesheet" />
    <script src="https://code.jquery.com/jquery-3.6.1.js"></script>
    <script src="js/board_common.js"></script>
</head>
<body>
    <div id="container">
	    <form name="fn" id="fn" enctype="multipart/form-data"> <!-- enctype="multipart/form-data" : 파일 업로드 위해 필요 -->
	    <%-- <input type="hidden" name="idx" id="idx" value="<%=idx %>" >
	    <input type="hidden" name="group" id="group" value="<%=group %>" >
	    <input type="hidden" name="level" id="level" value="<%=level %>" >
	    <input type="hidden" name="step" id="step" value="<%=step %>" >
	    <input type="hidden" name="list" id="list" value="<%=list %>" > --%>
	   	<h3><span>질문</span>게시판</h3>
       <ul class="tableBox">
          <li class="row">
               <div class="cell">
               	<label for="writer">작성자</label>
               </div>
               <div class="cell">
               	<input type="text" name="writer" id="writer" placeholder="작성자 들어갈 자리">
               </div>
          </li>
          <li class="row">
               <div class="cell">
               	<label for="subject">제목</label>
               </div>
               <div class="cell">
               	<input type="text" name="subject" id="subject" value=""  placeholder="제목 들어갈 자리"/>
               </div>
          </li> 
          <li class="row">
               <div class="cell">
               	<label for="content">내용</label>
               </div>
               <div class="cell">
               	<textarea name="content" id="content" placeholder="글 내용이 들어갈 자리"></textarea>
               </div>
          </li>
          <li class="row">
               <div class="cell">
               	<label for="file">파일</label>
               	  	
               </div>
               <div class="cell">
	               	<ul id="filelist" class="fl">
	               		<li>파일목록</li>
	               		<li class="fl"></li>
	               		<table>
	               	<caption>
	               		업로드된 파일 기본 정보          	
	               	</caption>
	               	<colgroup>
	               		<col>
	               		<col>
	               		<col>
	               	</colgroup>
	               	<thead>
	               		<tr>
	               			<td>FILE</td>
	               			<td>SIZE</td>
	               			<td>DOWN</td>
	               		</tr>
	               		</thead>
	               		<tbody id="fileInfo">
	               		<tr>
	               			<td>&nbsp:1</td>
	               			<td>&nbsp:2</td>
	               			<td>&nbsp:3</td>
	               		</tr>
	               		</tbody>
	               		</table>
	               	</ul>
               </div>
          </li>
       </ul>
       
       
       <div class="boardFooter cl">
			<span class="btn" id="btnReg">목록</span>
			<span class="btn" id="btnCan">답변</span>
			<span class="btn" id="btnCan">글쓰기</span>
       </div>
    </form>
    </div>
</body>
</html>