<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<jsp:include page="/menu.jsp"></jsp:include>
	<table border="1">
		<tr class="head">
			<td>studentid</td>
			<td>name</td>
			<td>major_id</td>
			<td>phone</td>
			<td>address</td>
			<td>hobby</td>
			<td>Skill</td>
			<td></td>
		</tr>
		<c:forEach items="${studentlist }" var="student">
			<tr>
				<td><a href="studentDetail.nk?studentID=${student.studentID }">
						${student.studentID }</a></td>
				<td>${student.name }</td>
				<td>${student.major_id }</td>
				<td>${student.phone }</td>
				<td>${student.address }</td>
				<td>${student.hobby }</td>
				<td>${student.skill }</td>
				<td><a href="deleteStudent.nk?studentID=${student.studentID }">삭제</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>