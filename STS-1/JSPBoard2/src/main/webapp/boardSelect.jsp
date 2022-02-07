<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.bitc.dto.*"%>
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
	String type = "게시판 글 상세보기 페이지";
	%>
	<jsp:include page="header.jsp" flush="false">
		<jsp:param value="<%=type%>" name="type1" />
	</jsp:include>

	<main class="container main-footer-space">
		<%
		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("userId");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		BoardDao dao = new BoardDao();
		BoardDto board = new BoardDto();
		
		board.setTitle(title);
		board.setContents(contents);
		board.setHitCnt(hitCnt);
		int result = dao.boardSelect(board);
		
		%>
		<div class="mt-5">
			
			<div class="my-3">
				<label for="title">글제목 : </label> <input type="text"
					class="form-control" id="title" name="title" readonly
					value="<%=title%>">
			</div>
			<div class="my-3">
				<label for="userId">글쓴이 : </label> <input type="text"
					class="form-control" id="userId" name="userId" readonly
					value="<%=userId%>">
			</div>
			<div class="my-3">
				<label for="hitCnt">조회수 : </label> <input type="text"
					class="form-control" id="hitCnt" name="hitCnt" readonly
					value="<%=hitcnt%>">
			</div>
			<div class="my-3">
				<label for="contents">내용 : </label>
				<textarea class="form-control" rows="5" id="contents"
					name="contents" readonly><%=contents%></textarea>
			</div>
			<div class="d-flex justify-content-between">
				<div>
					<a href="boardList.jsp" class="btn btn-secondary">목록</a>
				</div>
				<div>
					<a href="updateBoard.jsp?num=<%=idx%>" class="btn btn-info">수정</a>
					<a href="deleteBoard.jsp?num=<%=idx%>" class="btn btn-danger">삭제</a>
				</div>
			</div>
		</div>
		

	</main>

	<footer class="container-fluid p-0">
		<div class="mt-3 p-5 jumbotron text-center">
			<p>made by bitc</p>
		</div>
	</footer>
</body>
</html>