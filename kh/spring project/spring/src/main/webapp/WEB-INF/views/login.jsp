<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인 페이지</title>
</head>
<body>
	<form action="/spring/login" method="post">
		<input type="text" name="id" placeholder="아이디"> <br>
		<input type="password" name="pw" placeholder="비밀번호"> <br>
		<button type="submit">전송</button>
	</form>
	
	<!-- 콘솔에 출력 -->
	아이디 : ${id} <br>
	비밀번호 : ${pw}
</body>
</html>