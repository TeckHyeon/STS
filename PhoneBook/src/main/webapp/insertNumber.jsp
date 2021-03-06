<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
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
	String type = "번호 등록 페이지";
	%>
	<jsp:include page="header.jsp" flush="false">
		<jsp:param value="<%=type%>" name="type1" />
	</jsp:include>
	<main class="container">
		<form class="mt-5" action="insertNumber_process.jsp" method="post">
			<div class="mt-3">
				<label for="name">이름 : </label> 
				<input type="text"	class="form-control" id="name" name="name"
					placeholder="이름을 입력해주세요.">
			</div>
			<div class="mt-3">
				<label for="passwd">비밀번호 : </label> <input type="password"
					class="form-control" id="passwd" name="passwd"
					placeholder="비밀번호를 입력해주세요.">
			</div>
			<div class="mt-3">
				<label for="phone1">전화번호1 : </label> 
				<input type="text"	class="form-control" id="phone1" name="phone1"
					placeholder="전화번호를 입력해주세요.">
			</div>
			<div class="mt-3">
				<label for="phone2">전화번호2 : </label> 
				<input type="text"	class="form-control" id="phone2" name="phone2"
					placeholder="전화번호를 입력해주세요.">
			</div>
			<div class="mt-3">
				<label for="email">이메일 : </label> 
				<input type="text"	class="form-control" id="email" name="email"
					placeholder="이메일을 입력해주세요.">
			</div>
			<div class="mt-3">
				<label for="address">주소 : </label> 
				<input type="text"	class="form-control" id="address" name="address"
					placeholder="주소를 입력해주세요.">
			</div>
			<div class="mt-3">
				<label for="comment">코멘트 : </label> 
				<textarea rows = "5" class = "form-control" id = "comment" name = "comment" placeholder = "코멘트를 입력해주세요."></textarea>
			</div>
			<div class="d-flex justify-content-between my-3">
			<a href="phoneBookList.jsp" class="btn btn-secondary">목록</a>
				<button type="submit" class="btn btn-primary">번호 등록</button>
			</div>
		</form>
	</main>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>