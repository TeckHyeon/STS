<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="daodto.MemberDto"%>
<%@ page import="daodto.MemberDao2"%>
<%@ page import="java.util.ArrayList"%>
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
	String id = member.getId();
	MemberDao2 dao = new MemberDao2();
	result = dao.memberDelete(id);
	
	if (result > 0) {
		out.println("데이터 베이스에 정보가 정상적으로 삭제되었습니다.");
	} else {
		out.println("데이터 베이스에 정보 삭제 시 오류가 발생했습니다.");
	}
	%>
</body>
</html>