<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인페이지</h1>
	${loginMember.memberNick }
	<br>
	<a href="/app/member/join">회원가입</a>
	<br>
	<a href="/app/member/login">로그인</a>
	<br>
	<a href="/app/board/list">게시글 목록</a>
	<br>
	<a href="/app/board/write">게시글 작성</a>
</body>
</html>