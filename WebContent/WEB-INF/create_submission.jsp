<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Create Submission</title>
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
		<a href="DisplayCourses">Course Management</a> > <a
			href="DisplayAssignments?courseid=${course.id}">${course.name}</a> >
		<a
			href="DisplaySubmissions?courseid=${course.id}&assignmentid=${assignment.id}">${assignment.name}</a>
		> Create Submission
	</h2>
	<form action="CreateSubmission" method="post">
		<table>
			<tr>
				<th>Student Name</th>
				<td><input type="text" name="student_name" required=""></td>
			</tr>
			<tr>
				<th>Answer</th>
				<td><textarea name="answer" required=""></textarea></td>
			</tr>
			<input type="hidden" name="courseid" value="${course.id}" />
			<input type="hidden" name="assignmentid" value="${assignment.id}" />
			<tr>
				<td colspan="2"><button type="submit">Create</button></td>
			</tr>
		</table>
	</form>
</body>
</html>