<%@page import="daodto.MemberDao2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="daodto.MemberDto"%>
<%@ page import="daodto.MemberDao2"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DAO, DTO를 사용한 DB 사용</title>
</head>
<body>
	<%
	int result = 0;
	MemberDto member = new MemberDto();
	member.setId("test05");
	member.setPasswd("1234");
	member.setName("테스터5");

	MemberDao2 dao = new MemberDao2();
	result = dao.memberInsert(member);

	if (result > 0) {
		out.println("데이터 베이스에 정보가 정상적으로 추가되었습니다.");
	} else {
		out.println("데이터 베이스에 정보 입력 시 오류가 발생했습니다.");
	}
	%>
</body>
</html>