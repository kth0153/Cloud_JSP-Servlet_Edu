/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.65
 * Generated at: 2022-09-30 08:34:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class write_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("    \n");

String idx="0";
String group="0";
String level="0";
String step="0";
String list="0";

// request.setAttribute("group", keyVal[1]); => 받기위해 request.getAttribute("idx").toString(); 설정
if(request.getParameter("idx") !=null && !"".equals(request.getParameter("idx"))&& 
request.getParameter("idx").matches("[0-9.]+"))
	idx =request.getAttribute("idx").toString();
	
if(request.getParameter("group") !=null && !"".equals(request.getParameter("group"))&& 
request.getParameter("group").matches("[0-9.]+"))
	group =request.getAttribute("group").toString();

if(request.getParameter("level") !=null && !"".equals(request.getParameter("level"))&& 
   request.getParameter("level").matches("[0-9.]+"))
	level =request.getAttribute("level").toString();

if(request.getParameter("step") !=null && !"".equals(request.getParameter("step"))&& 
request.getParameter("step").matches("[0-9.]+"))
	step =request.getAttribute("step").toString();

if(request.getParameter("list") !=null && !"".equals(request.getParameter("list"))&& 
request.getParameter("list").matches("[0-9.]+"))
	list =request.getAttribute("list").toString();

      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"ko\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\"> \n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>게시판 글쓰기</title>\n");
      out.write("    <link href=\"css/style.css\" rel=\"stylesheet\" />\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.6.1.js\"></script>\n");
      out.write("    <script src=\"js/board_common.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div id=\"container\">\n");
      out.write("	    <form name=\"fn\" id=\"fn\" enctype=\"multipart/form-data\"> <!-- enctype=\"multipart/form-data\" : 파일 업로드 위해 필요 -->\n");
      out.write("	    <input type=\"hidden\" name=\"idx\" id=\"idx\" value=\"");
      out.print(idx );
      out.write("\" >\n");
      out.write("	    <input type=\"hidden\" name=\"group\" id=\"group\" value=\"");
      out.print(group );
      out.write("\" >\n");
      out.write("	    <input type=\"hidden\" name=\"level\" id=\"level\" value=\"");
      out.print(level );
      out.write("\" >\n");
      out.write("	    <input type=\"hidden\" name=\"step\" id=\"step\" value=\"");
      out.print(step );
      out.write("\" >\n");
      out.write("	    <input type=\"hidden\" name=\"list\" id=\"list\" value=\"");
      out.print(list );
      out.write("\" >\n");
      out.write("	   	<h3><span>질문</span>게시판</h3>\n");
      out.write("       <ul class=\"tableBox\">\n");
      out.write("       		<li class=\"row\">\n");
      out.write("       			 <div class=\"cell\"><label for=\"top\">상단고정</label></div>\n");
      out.write("       			 <div class=\"cell\">\n");
      out.write("       			 <input type=\"checkbox\" name=\"top\" id=\"top\" value=\"Yes\"/>\n");
      out.write("       			 <label for=\"top\">게시판 상단에 위치 시킬시 선택해주세요</label>\n");
      out.write("       			 </div>\n");
      out.write("       		</li>\n");
      out.write("       \n");
      out.write("           <li class=\"row\">\n");
      out.write("               <div class=\"cell\"><label for=\"header\">머릿글</label></div>\n");
      out.write("               <div class=\"cell\">\n");
      out.write("               	<select name=\"header\" id=\"header\">\n");
      out.write("               		<option value=\"\">== 선택 ==</option>\n");
      out.write("               		<option value=\"1\">학습</option>\n");
      out.write("               		<option value=\"2\">생활</option>\n");
      out.write("               		<option value=\"3\">취업</option>\n");
      out.write("               		<option value=\"4\">고민</option>\n");
      out.write("               		<option value=\"5\">과정</option>\n");
      out.write("               	</select>\n");
      out.write("               </div>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"row\">\n");
      out.write("               <div class=\"cell\">\n");
      out.write("               	<label for=\"writer\">작성자</label>\n");
      out.write("               </div>\n");
      out.write("               <div class=\"cell\">\n");
      out.write("               	<input type=\"text\" name=\"writer\" id=\"writer\">\n");
      out.write("               </div>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"row\">\n");
      out.write("               <div class=\"cell\">\n");
      out.write("               	<label for=\"subject\">제목</label>\n");
      out.write("               </div>\n");
      out.write("               <div class=\"cell\">\n");
      out.write("               	<input type=\"text\" name=\"subject\" id=\"subject\"\n");
      out.write("               	value=\"\" />\n");
      out.write("               </div>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"row\">\n");
      out.write("               <div class=\"cell\">\n");
      out.write("               	<label for=\"content\">내용</label>\n");
      out.write("               </div>\n");
      out.write("               <div class=\"cell\">\n");
      out.write("               	<textarea name=\"content\" id=\"content\"></textarea>\n");
      out.write("               </div>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"row\">\n");
      out.write("               <div class=\"cell\">\n");
      out.write("               	<label for=\"passw\">비밀번호</label>\n");
      out.write("               </div>\n");
      out.write("               <div class=\"cell\">\n");
      out.write("               	<input type=\"password\" name=\"passw\" id=\"passw\" />\n");
      out.write("               </div>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"row\">\n");
      out.write("               <div class=\"cell\">\n");
      out.write("               	<label for=\"file\">파일</label>\n");
      out.write("               </div>\n");
      out.write("               <div class=\"cell\">\n");
      out.write("	               	<ul id=\"filelist\" class=\"fl\">\n");
      out.write("	               		<li>파일목록</li>\n");
      out.write("	               		<li class=\"fl\"></li>\n");
      out.write("	               	</ul>\n");
      out.write("	               	<div class=\"findArea\">\n");
      out.write("	               		<span id=\"btnFileUpload\" class=\"btn\">파일선택</span>\n");
      out.write("	               		<input type=\"file\" name=\"file\" id=\"file\" multiple />\n");
      out.write("	               	</div>\n");
      out.write("               	\n");
      out.write("               </div>\n");
      out.write("          </li>\n");
      out.write("       </ul>\n");
      out.write("       <div class=\"boardFooter cl\">\n");
      out.write("			<span class=\"btn\" id=\"btnReg\">저장</span>\n");
      out.write("			<span class=\"btn\" id=\"btnCan\">취소</span>\n");
      out.write("       </div>\n");
      out.write("    </form>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}