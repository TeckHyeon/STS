/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.55
 * Generated at: 2021-12-05 23:41:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.JSPBoard.src.main.webapp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.sql.*;

public final class boardList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {


// // DB와 실제 연결하기 위한 커넥션 객체
// // 미리 DB와 연관된 객체를 선언하는 이유는 try ~ catch문 때문임
// // try ~ catch 문 내에서 객체를 선언 시 만약 오류가 발생하여 catch 문이 동작할 때 해당 객체를 finally 내에서 삭제할 수 없음
// Connection conn = null;
// Statement stmt = null; // DB에 SQL 질의를 하기 위한 객체
// ResultSet rs = null; // SELECT 질의 후 결과를 저장하기 위한 객체

// // mysql 드라이버 이름
// // DB의 종류에 따라 드라이버 이름이 변경 됨
// String driver = "com.mysql.cj.jdbc.Driver";
// // 실제 DB 접속 주소
// // DB의 종류에 따라 주소를 입력하는 방식이 조금씩 달라짐
// String url = "jdbc:mysql://localhost:3306/testdb?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
// // DB에서 sql문을 실행할 DB 유저 ID 및 비밀번호
// String uid = "testuser";
// String upw = "bitc1234";


Connection conn = null;
PreparedStatement pstmt = null;

String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/testdb?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
String uid = "testuser";
String upw = "bitc1234";

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/JSPBoard/src/main/webapp/footer.jsp", Long.valueOf(1638747253965L));
    _jspx_dependants.put("/JSPBoard/src/main/webapp/dbConn.jsp", Long.valueOf(1638747253962L));
    _jspx_dependants.put("/JSPBoard/src/main/webapp/header.jsp", Long.valueOf(1638747253966L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- DB 사용 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<title>게시판 만들기</title>\r\n");
      out.write("\r\n");
      out.write("<!-- 부트스트랩5 적용 -->\r\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"./style/mystyle.css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- 	<header class=\"container\"> -->\r\n");
      out.write("<!-- 		<div class=\"mt-4 p-5 rounded jumbotron\"> -->\r\n");
      out.write("<!-- 			<h1>게시판 목록 페이지</h1> -->\r\n");
      out.write("<!-- 		</div> -->\r\n");
      out.write("<!-- 	</header> -->\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("\r\n");

// 현재 페이지 파일명을 불러옴
String path = request.getServletPath();
// '/' 문자가 있는 위치를 가져오기
int k = path.lastIndexOf('/');
// 첫번째 지정한 위치에서 두번째 지정한 위치까지의 문자를 가져오기
path = path.substring(k + 1, path.length());

String pageName = ""; // 각 페이지 제목란에 출력할 문자를 저장할 변수

if (path.equals("boardList.jsp")) {
	pageName = "게시판 목록 페이지";
}
else if (path.equals("selectBoard.jsp")) {
	pageName = "게시판 글 상세 페이지";
}
else if (path.equals("insertBoard.jsp")) {
	pageName = "게시판 글 등록 페이지";
}
else if (path.equals("updateBoard.jsp")) {
	pageName = "게시판 글 수정 페이지";
}
else if (path.equals("deleteBoard.jsp")) {
	pageName = "게시판 글 삭제 페이지";
}

      out.write("\r\n");
      out.write("<header class=\"container\">\r\n");
      out.write("	<div class=\"mt-4 p-5 rounded jumbotron\">\r\n");
      out.write("		<h1>");
      out.print( pageName );
      out.write("</h1>\r\n");
      out.write("	</div>\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<main class=\"container main-footer-space\">\r\n");
      out.write("		<table class=\"table table-striped table-hover mt-5\">\r\n");
      out.write("			<colgroup>\r\n");
      out.write("				<col width=\"10%\" />\r\n");
      out.write("				<col width=\"50%\" />\r\n");
      out.write("				<col width=\"15%\" />\r\n");
      out.write("				<col width=\"20%\" />\r\n");
      out.write("				<col width=\"5%\" />\r\n");
      out.write("			</colgroup>\r\n");
      out.write("			<thead class=\"text-center\">\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th>글번호</th>\r\n");
      out.write("					<th>제목</th>\r\n");
      out.write("					<th>글쓴이</th>\r\n");
      out.write("					<th>등록일</th>\r\n");
      out.write("					<th>조회수</th>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</thead>\r\n");
      out.write("			<tbody>\r\n");
      out.write("				");

				String sql = "SELECT idx, title, creator_id, created_date, hit_cnt ";
				sql += "FROM t_board ";
				sql += "WHERE deleted_yn = 'N' ";
				
				ResultSet rs = null;
				
// 				데이터베이스와 같은 외부 리소스를 사용하는 부분은 오류가 발생할 가능성이 매우 높기 때문에 반드시 try ~ catch를 통해서 예외처리를 해야 함
				try {
					// DB에 연결하기 위한 드라이버 이름을 적용
					// DriverManager 클래스에 자동으로 등록 및 객체를 생성
// 					Class.forName(driver);
// 					getConnection() 메서드를 실행하면 실제 DB와 연결하고 그 결과를 Connection 클래스 타입의 객체에 대입함
					conn = DriverManager.getConnection(url, uid, upw);
// 					Connection 클래스 타입의 객체를 통해서 Statement 클래스 타입의 객체를 생성함
// 					stmt = conn.createStatement();
// 					Statement 클래스 타입의 객체가 가지고 있는 executeQuery() 메서드를 통해서 실제 SQL 쿼리를 DB에 질의함
// 					그 결과를 ResultSet 클래스 타입의 객체에 저장함
// 					rs = stmt.executeQuery(sql);

					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					
// 					ResultSet 클래스의 next() 메서드를 실행 시 데이터가 있으면 true, 없으면 false를 출력
					while (rs.next()) {
// 						getInt, getString 메서드 사용 시 매개변수로 사용하는 문자열은 실제 DB의 컬럼명을 사용해야 함
						int idx = rs.getInt("idx");
						String title = rs.getString("title");
						String creatorId = rs.getString("creator_id");
						String createdDate = rs.getString("created_date");
						int hitCnt = rs.getInt("hit_cnt");
						
						String item = "<tr>";
						item += "<td>" + idx + "</td>";
						item += "<td><a href='selectBoard.jsp?num=" + idx + "'>" + title + "</a></td>";
						item += "<td>" + creatorId + "</td>";
						item += "<td>" + createdDate + "</td>";
						item += "<td>" + hitCnt + "</td>";
						item += "</tr>";
						
						out.println(item);
					}
				}
				catch (SQLException ex) {

				}
				finally {
// 					데이터 베이스 사용 후 리소스 삭제
// 					데이터 베이스는 외부 리소스이기 때문에 자바의 가비지컬렉터가 자동으로 메모리에서 삭제를 할 수 없음
// 					삭제 시 사용된 순서의 반대로 삭제해야 함
					if (rs != null) { rs.close(); }
// 					if (stmt != null) { stmt.close(); }
					if (pstmt != null) { pstmt.close(); }
					if (conn != null) { conn.close(); }
				}
				
      out.write("\r\n");
      out.write("			</tbody>\r\n");
      out.write("		</table>\r\n");
      out.write("		<div class=\"d-flex justify-content-end\">\r\n");
      out.write("			<a href=\"insertBoard.jsp\" class=\"btn btn-primary\">글 쓰기</a>\r\n");
      out.write("		</div>\r\n");
      out.write("	</main>\r\n");
      out.write("	\r\n");
      out.write("<!-- 	<footer class=\"container-fluid fixed-bottom p-0\"> -->\r\n");
      out.write("<!-- 		<div class=\"mt-3 p-5 jumbotron text-center\"> -->\r\n");
      out.write("<!-- 			<p>made by bitc</p> -->\r\n");
      out.write("<!-- 		</div> -->\r\n");
      out.write("<!-- 	</footer> -->\r\n");
      out.write("\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<footer class=\"container-fluid fixed-bottom p-0\">\r\n");
      out.write("	<div class=\"mt-3 p-5 jumbotron text-center\">\r\n");
      out.write("		<p>made by bitc</p>\r\n");
      out.write("	</div>\r\n");
      out.write("</footer>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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