<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인</h1>
	
	<span>로그인정보</span>
	<br>
	<span>${loginMember.memberId }</span>
	<br>
	<span>${loginMember.memberNick }</span>
	<br>
	<img alt="프로필사진" src="/app/resources/upload/${loginMember.changeName }">
	
</body>
</html>