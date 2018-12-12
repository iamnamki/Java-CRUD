<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<jsp:include page="/menu.jsp"></jsp:include>
	<form action="studentDetail.nk" method="post">
		StudentID : <input type="number" name="studentID" value="${student.studentID}"><br>
		Name : <input type="text" name="name" value="${student.name}"><br>
		Major_id : <select name="major_id">
		<c:forEach var="major" items="${majorlist }">
				<option value="${major.major_id }" }>
				${major.major_id } - ${major.major_title } </option>
			</c:forEach></select> <br>
		Phone : <input type="text" name="phone" value="${student.phone}"><br>
		Address : <input type="text" name="address" value="${student.address}"><br>
		Hobby : <input type="text" name="hobby" value="${student.hobby}"><br>
		Skill : <input type="text" name="skill" value="${student.skill}"><br>
		<input type="submit" value="수정하기">
	</form>
</body>
</html>