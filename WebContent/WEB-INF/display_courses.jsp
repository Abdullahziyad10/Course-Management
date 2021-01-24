<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Course Management</title>
<style>
table {
	border: 1px solid black;
}

th, td {
	border: 1px solid black;
	text-align: center;
	vertical-align: middle;
}
</style>
</head>
<body>
	<h2>
		<a href="DisplayCourses">Course Management</a>
	</h2>
	<table>
		<tr>
			<th>Courses</th>
			<th>Assignments</th>
		</tr>
		<c:forEach items="${courseList}" var="item">
			<tr>
				<td><a href="DisplayAssignments?courseid=${item.id}">${item.name}</a>
				<td>${item.assignment_count}</td>
			</tr>
		</c:forEach>
	</table>
	
		<h3>
		<a
			href="CreateCourse">Create
			Course</a>
	</h3>
</body>
</html>