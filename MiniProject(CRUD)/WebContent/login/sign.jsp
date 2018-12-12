<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LOGIN</title>
</head>
<body>
	<h1>LOGIN</h1>
	<form action="sign.nk" method="post">
		사용자 번호 : <input type="text" name=userid> 
		비밀번호 : <input type="password" name=userpass> <br> 
		<input type="submit" value="login">
	</form>
	${singMessage } 
</body>
</html>