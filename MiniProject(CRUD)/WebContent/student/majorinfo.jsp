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
			<td>Major_id</td>
			<td>Major_title</td>
			<td></td>
		</tr>
		<c:forEach items="${majorlist }" var="major">
			<tr>
				<td><a href="majorDetail.nk?major_id=${major.major_id }">${major.major_id }</a></td>
				<td>${major.major_title }</td>
				<td><a href="deleteMajor.nk?major_id=${major.major_id }">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>