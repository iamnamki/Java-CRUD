<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC >
<html>
<script type="text/javascript">
	function retrieve() {
		var major_id = document.getElementById("major_id").value;
		var name = document.getElementById("name").value;
		var param = "major_id=" + major_id + "&name=" + name;
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById("here").innerHTML = this.responseText;
			}
		};
		xhttp.open("GET", "studentselectlist.nk?" + param);
		xhttp.send();
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<jsp:include page="/menu.jsp"></jsp:include>
	Name :
	<input type="text" name="name" id="name" placeholder="이름" value="">
	Major_id :
	<select name="major_id" id="major_id">
		<option value="0">직책 선택</option>
		<c:forEach var="majorlist" items="${majorlist }">
			<option value="${majorlist.major_id }">${majorlist.major_id }-${majorlist.major_title }</option>
		</c:forEach>
	</select>
	<button onclick="retrieve();">버튼</button>
	<hr>
	<div id=here>
		<table border="1">
			<tr class="head">
				<td>StudentID</td>
				<td>Name</td>
				<td>Major_id</td>
				<td>Skill</td>
				<td>Major_title</td>
			</tr>
			<c:forEach items="${studentlist }" var="student">
				<tr>
					<td><a
						href="selectByCondition.nk?studentID=${student.studentID }">
							${student.studentID } </a></td>
					<td>${student.name }</td>
					<td>${student.major_id }</td>
					<td>${student.skill }</td>
					<td>${student.major_title }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>