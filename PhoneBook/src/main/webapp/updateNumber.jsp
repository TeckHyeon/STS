<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ include file="dbconn.jsp"%>
<%!ResultSet rs = null;%>
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
<script>
	window.addEventListener("DOMContentLoaded", function() {
		var btnCancel = document.querySelector("#btn-cancel");
		btnCancel.addEventListener("click", function() {
			history.back();
		});
	});
</script>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8");
	String type = "연락처 수정 페이지";%>
	<jsp:include page="header.jsp" flush = "false">
	<jsp:param value="<%=type%>" name="type1"/>
	</jsp:include>

	<main class="container">
		<form class="mt-5" action="updateNumber_process.jsp" method="post">
			<%
			request.setCharacterEncoding("utf-8");
			int num = Integer.parseInt(request.getParameter("num"));

			String sql = "Select seq, fr_name, fr_phone1, fr_phone2, fr_email, fr_address, fr_comment FROM phonebook where seq = ? AND deleted_yn = 'N' ";

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
			<div class="my-3">
				<label for="seq"># : </label> <input type="text"
					class="form-control" id="seq" name="seq" readonly
					value="<%=seq%>">
			</div>
			<div class="my-3">
				<label for="name">이름 : </label> <input type="text"
					class="form-control" id="name" name="name" 
					value="<%=name%>">
			</div>
			<div class="my-3">
				<label for="passwd">비밀번호 : </label> <input type="password"
					class="form-control" id="passwd" name="passwd" value="">
			</div>
			<div class="my-3">
				<label for="phone1">전화번호1 : </label> <input type="text"
					class="form-control" id="phone1" name="phone1" 
					value="<%=phone1%>">
			</div>
			<div class="my-3">
				<label for="phone2">전화번호2 : </label> <input type="text"
					class="form-control" id="phone2" name="phone2" 
					value="<%=phone2%>">
			</div>
			<div class="my-3">
				<label for="email">이메일 : </label> <input type="text"
					class="form-control" id="email" name="email" 
					value="<%=email%>">
			</div>
			<div class="my-3">
				<label for="address">주소 : </label> <input type="text"
					class="form-control" id="address" name="address" 
					value="<%=address%>">
			</div>
			<div class="my-3">
				<label for="comment">코멘트 : </label>
				<textarea class="form-control" rows="5" id="comment"
					name="comment" ><%=comment%></textarea>
			</div>
			<div class="d-flex justify-content-between">
				<div>
					<a href="phoneBookList.jsp" class="btn btn-secondary">목록</a>
				</div>
				<div>
					<button type="submit" class="btn btn-primary">수정</button>
					<button type="button" class="btn btn-warning" id="btn-cancel">취소</button>
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
			if (conn != null) {
			conn.close();
			}
			}
			%>

		</form>


	</main>

	<%@ include file="footer.jsp" %>
</body>
</html>