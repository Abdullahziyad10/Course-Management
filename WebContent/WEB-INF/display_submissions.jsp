<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Display Submissions</title>
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
		> Submissions
	</h2>
	<table>
		<tr>
			<th>Student Name</th>
			<th>Answer</th>
			<th>Submitted Date</th>
		</tr>
		<c:forEach items="${submissionList}" var="item">
			<tr>
				<td>${item.student_name}</td>
				<td>${item.answer}</td>
				<td><fmt:formatDate value="${item.submitted_datetime}"
						pattern="MM/dd/yyyy hh:mm a" /></td>
			</tr>
		</c:forEach>
	</table>
	<h3>
		<a
			href="CreateSubmission?courseid=${course.id}&assignmentid=${assignment.id}">Create
			Submission</a>
	</h3>

</body>
</html>