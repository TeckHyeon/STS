<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ include file="dbconn.jsp"%>
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
	String type = "전화번호 상세보기 페이지";
	%>
	<jsp:include page="header.jsp" flush="false">
		<jsp:param value="<%=type%>" name="type1" />
	</jsp:include>
	
	<main class="container main-footer-space">
		<%
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		
		String sql = "Select seq, fr_name, fr_phone1, fr_phone2, fr_email, fr_address, fr_comment FROM phonebook where seq = ? AND deleted_yn = 'N' ";
		
		ResultSet rs = null;
		PreparedStatement pstmtCount = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int seq = rs.getInt("seq");
				String name = rs.getString("fr_name");
				String phone1 = rs.getString("fr_phone1");
				String phone2 = rs.getString("fr_phone2");
				String email = rs.getString("fr_email");
				String address = rs.getString("fr_address");
				String comment = rs.getString("fr_comment");
		%>
		<div class="mt-5">
			<div class="my-3">
				<label for="seq"># : </label> <input type="text"
					class="form-control" id="seq" name="seq" readonly
					value="<%=seq%>">
			</div>
			<div class="my-3">
				<label for="name">이름 : </label> <input type="text"
					class="form-control" id="name" name="name" readonly
					value="<%=name%>">
			</div>
			<div class="my-3">
				<label for="phone1">전화번호1 : </label> <input type="text"
					class="form-control" id="phone1" name="phone1" readonly
					value="<%=phone1%>">
			</div>
			<div class="my-3">
				<label for="phone2">전화번호2 : </label> <input type="text"
					class="form-control" id="phone2" name="phone2" readonly
					value="<%=phone2%>">
			</div>
			<div class="my-3">
				<label for="email">이메일 : </label> <input type="text"
					class="form-control" id="email" name="email" readonly
					value="<%=email%>">
			</div>
			<div class="my-3">
				<label for="address">주소 : </label> <input type="text"
					class="form-control" id="address" name="address" readonly
					value="<%=address%>">
			</div>
			<div class="my-3">
				<label for="comment">코멘트 : </label>
				<textarea class="form-control" rows="5" id="comment"
					name="comment" readonly><%=comment%></textarea>
			</div>
			<div class="d-flex justify-content-between">
				<div>
					<a href="phoneBookList.jsp" class="btn btn-secondary">목록</a>
				</div>
				<div>
					<a href="updateNumber.jsp?num=<%=seq%>" class="btn btn-info">수정</a>
					<a href="deleteNumber.jsp?num=<%=seq%>" class="btn btn-danger">삭제</a>
				</div>
			</div>
		</div>
		<%
		}
		} catch (SQLException ex) {

		} finally {
		if (rs != null) {
		rs.close();
		}
		if (pstmt != null) {
		pstmt.close();
		}
		if (pstmtCount != null) {
		pstmtCount.close();
		}
		if (conn != null) {
		conn.close();
		}
		}
		%>

	</main>

	<footer class="container-fluid p-0">
		<div class="mt-3 p-5 jumbotron text-center">
			<p>made by bitc</p>
		</div>
	</footer>
</body>
</html>