<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- <jsp:forward page = "./boardList.jsp" /> -->
	<h1>게시판 만들기</h1>
	<%
	response.sendRedirect("./boardList.jsp");%>
	
	
	<! --
	전화번호 목록 페이지 : phoneBookList.jsp
	전화번호 상세 페이지 : selectNumber.jsp
	전화번호 등록 페이지 : insertNumber.jsp
	전화번호 등록 내부 프로세스 : insertNumber_process.jsp
	연락처 수정 페이지 : updateNumber.jsp
	연락처 수정 내부 프로세스 : updateNumber_process.jsp
	연락처 삭제 페이지 : deleteNumber.jsp
	연락처 삭제 내부 프로세스 : deleteNumber_process.jsp
	-->
</body>
</html>