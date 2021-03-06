<%@page import="org.apache.jasper.runtime.JspRuntimeLibrary"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ include file="dbconn.jsp"%>
<%!	ResultSet rs = null;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<style>
.jumbotron {
	background-color: lightgray;
}
</style>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	String type = "전화번호 목록 페이지";
	%>

	<jsp:include page="header.jsp" flush="false">
		<jsp:param value="<%=type%>" name="type1" />
	</jsp:include>
	
	<main class="container">
		<table class="table table-border">
			<colgroup>
			<col width="3%">
			<col width="10%">
			<col width="16%">
			<col width="16%">
			<col width="17%">
			<col width="18%">
			<col width="20%">		
			</colgroup>
			<thead>	
				<tr>
					<th>#</th>
					<th>이름</th>
					<th>전화번호 1</th>
					<th>전화번호 2</th>
					<th>이메일</th>
					<th>주소</th>
					<th>코멘트</th>
				</tr>		
			</thead>
			<tbody>
			<%
			String sql = "Select seq, fr_name, fr_phone1, fr_phone2, fr_email, fr_address, fr_comment FROM phonebook where deleted_yn = 'N' ";
			
			
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					int seq = rs.getInt("seq");
					String name = rs.getString("fr_name");
					String phone1 = rs.getString("fr_phone1");
					String phone2 = rs.getString("fr_phone2");
					String email = rs.getString("fr_email");
					String address = rs.getString("fr_address");
					String comment = rs.getString("fr_comment");
					
					
					
					String item = "<tr>"; 
					item += "<td>" + seq + "</td>";
					item += "<td><a href = 'selectNumber.jsp?num=" + seq + "'>" + name + "</td>";
					item += "<td>" + phone1 + "</td>";
					item += "<td>" + phone2 + "</td>";
					item += "<td>" + email + "</td>";
					item += "<td>" + address + "</td>";
					item += "<td>" + comment + "</td>";
					item += "</tr>";
					out.println(item);
				}
			} catch(SQLException e) {
				out.println();
			} finally {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			}
			%>
			</tbody>
		</table>
		<div class="d-flex justify-content-end">
			<a href="insertNumber.jsp" class="btn btn-primary">번호 등록</a>
		</div>
	</main>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>