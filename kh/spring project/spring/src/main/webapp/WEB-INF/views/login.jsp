<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α��� ������</title>
</head>
<body>
	<form action="/spring/login" method="post">
		<input type="text" name="id" placeholder="���̵�"> <br>
		<input type="password" name="pw" placeholder="��й�ȣ"> <br>
		<button type="submit">����</button>
	</form>
	
	<!-- �ֿܼ� ��� -->
	���̵� : ${id} <br>
	��й�ȣ : ${pw}
</body>
</html>