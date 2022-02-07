<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ include file="dbconn.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String phone1 = request.getParameter("phone1");
	String phone2 = request.getParameter("phone2");
	String email = request.getParameter("email");
	String address = request.getParameter("address");
	String comment = request.getParameter("comment");
	String passwd = request.getParameter("passwd");
	try {
		String sql = "insert into phonebook (fr_name, fr_phone1, fr_phone2, fr_email, fr_address, fr_comment, passwd) values (?,?,?,?,?,?,?) ";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, phone1);
		pstmt.setString(3, phone2);
		pstmt.setString(4, email);
		pstmt.setString(5, address);
		pstmt.setString(6, comment);
		pstmt.setString(7, passwd);
		
		int count = pstmt.executeUpdate();
		
		if (count < 1) {
			
		} else {
			
		}
		
	} catch (SQLException e) {
		out.println();
	} finally {
		if (pstmt != null) {
			pstmt.close();
		}
		if (conn != null) {
			conn.close();
		}
		
		response.sendRedirect("phoneBookList.jsp");
	}
	%>
</body>
</html>