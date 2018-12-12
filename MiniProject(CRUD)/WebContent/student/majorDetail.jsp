<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<jsp:include page="/menu.jsp"></jsp:include>
	<form action="majorDetail.nk" method="post">
		Major_id : <input type="number" name="major_id" value="${major.major_id}"><br>
		Major_title : <input type="text" name="major_title" value="${major.major_title}"><br>
		<input type="submit" value="수정하기">
	</form>
</body>
</html>