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
	<form action="" method="post">
		StudentID : <input type="number" name="studentID" value="${student.studentID}"><br>
		Name : <input type="text" name="name" value="${student.name}"><br>
		Major_id : <input type="number" name="major_id" value="${student.major_id}"><br>
		Skill : <input type="text" name="skill" value="${student.skill}"><br>
		Major_title : <input type="text" name="major_title" value="${student.major_title}"><br>
	</form>
</body>
</html>