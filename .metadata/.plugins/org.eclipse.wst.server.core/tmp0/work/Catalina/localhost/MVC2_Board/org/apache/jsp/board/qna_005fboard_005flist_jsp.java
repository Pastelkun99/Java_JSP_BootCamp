/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.13
 * Generated at: 2018-12-03 00:27:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import vo.PageInfo;
import vo.BoardBean;
import java.util.ArrayList;

public final class qna_005fboard_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("vo.BoardBean");
    _jspx_imports_classes.add("vo.PageInfo");
    _jspx_imports_classes.add("java.util.ArrayList");
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
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");

    	ArrayList<BoardBean> articleList = (ArrayList<BoardBean>)request.getAttribute("articleList");
    	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
    	int listCount = pageInfo.getListCount();
    	int nowPage = pageInfo.getPage();
    	int maxPage = pageInfo.getMaxPage();
    	int startPage = pageInfo.getStartPage();
    	int endPage = pageInfo.getEndPage();
    
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>MVC 게시판</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\t#registForm {\r\n");
      out.write("\t\twidth: 500px;\r\n");
      out.write("\t\theight: 600px;\r\n");
      out.write("\t\tborder: 1px solid red;\r\n");
      out.write("\t\tmargin: auto;\r\n");
      out.write("\t}\r\n");
      out.write("\th2 {\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t}\r\n");
      out.write("\ttable {\r\n");
      out.write("\t\tmargin: auto;\r\n");
      out.write("\t\twidth: 450px;\r\n");
      out.write("\t}\r\n");
      out.write("\t#tr_top {\r\n");
      out.write("\t\tbackground: orange;\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t}\r\n");
      out.write("\t#pagelist {\r\n");
      out.write("\t\tmargin: auto;\r\n");
      out.write("\t\twidth: 500px;\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- 게시판 리스트 -->\r\n");
      out.write("\t<section id=\"listForm\">\r\n");
      out.write("\t\t<h2>\r\n");
      out.write("\t\t\t글 목록<a href=\"boardWriteForm.bo\">게시판 글쓰기</a>\r\n");
      out.write("\t\t</h2>\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t");

				// 게시글이 하나라도 존재한다면?
				if(articleList != null && listCount > 0) { 
			
      out.write("\r\n");
      out.write("\t\t\t<tr id=\"tr_top\">\r\n");
      out.write("\t\t\t\t<td>번호</td>\r\n");
      out.write("\t\t\t\t<td>제목</td>\r\n");
      out.write("\t\t\t\t<td>작성자</td>\r\n");
      out.write("\t\t\t\t<td>날짜</td>\r\n");
      out.write("\t\t\t\t<td>조회수</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");

				for(int i = 0; i<articleList.size(); i++) {
			
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(articleList.get(i).getBOARD_NUM() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t");
 if(articleList.get(i).getBOARD_RE_LEV() != 0) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
for(int a = 0; a<=articleList.get(i).getBOARD_RE_LEV()*2; a++) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t&nbsp; ");
 } 
      out.write(' ');
      out.write('▶');
      out.write(' ');
 } 
					else { 
      out.write(' ');
      out.write('▶');
      out.write(' ');
 } 
      out.write(" <a href=\"boardDetail.bo?board_num=");
      out.print(articleList.get(i).getBOARD_NUM() );
      out.write("&page=");
      out.print(nowPage );
      out.write("\">\r\n");
      out.write("\t\t\t\t\t");
      out.print(articleList.get(i).getBOARD_SUBJECT() );
      out.write("\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(articleList.get(i).getBOARD_NAME() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(articleList.get(i).getBOARD_DATE() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(articleList.get(i).getBOARD_READCOUNT() );
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<section id=\"pagelist\">\r\n");
      out.write("\t\t");
if(nowPage <= 1) { 
      out.write("\r\n");
      out.write("\t\t[이전]&nbsp;\r\n");
      out.write("\t\t");
 }
		else { 
      out.write("\r\n");
      out.write("\t\t<a href=\"boardList.bo?page=");
      out.print(nowPage-1 );
      out.write("\">[이전]</a>&nbsp;\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t");
 for(int a=startPage; a<= endPage; a++) {
				if(a == nowPage) { 
      out.write("\r\n");
      out.write("\t\t\t\t[");
      out.print(a );
      out.write("]\r\n");
      out.write("\t\t\t");
 }
				else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"boardList.bo?page=");
      out.print(a );
      out.write('"');
      out.write('>');
      out.write('[');
      out.print(a );
      out.write("]\r\n");
      out.write("\t\t\t\t\t</a>&nbsp;\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
 if(nowPage >= maxPage) { 
      out.write(" [다음]\r\n");
      out.write("\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t<a href=\"boardList.bo?page=");
      out.print(nowPage+1 );
      out.write("\">[다음]</a>\r\n");
      out.write("\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t<section id=\"emptyArea\">등록된 글이 없습니다.</section>\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("</body>\r\n");
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
