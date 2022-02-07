<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="daodto.MemberDto"%>
<%@ page import="daodto.MemberDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DAO, DTO를 사용한 DB 사용</title>
</head>
<body>
	<jsp:useBean id="dao" class="daodto.MemberDao"></jsp:useBean>
	<jsp:useBean id="member" class="daodto.MemberDto"></jsp:useBean>
	<%
	int result = 0;

	member.setId("test05");
	member.setPasswd("1234");
	member.setName("테스터");

	result = dao.memberUpdate(member);

	if (result > 0) {
		out.println("데이터 베이스에 정보가 정상적으로 수정되었습니다.");
	} else {
		out.println("데이터 베이스에 정보 수정 시 오류가 발생했습니다.");
	}
	%>
</body>
</html>