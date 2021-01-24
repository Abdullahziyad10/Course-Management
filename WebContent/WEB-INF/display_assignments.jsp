<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Display Assignments</title>
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
		Assignments
	</h2>
	<table>
		<tr>
			<th>Assignments</th>
			<th>Submissions</th>
			<th>Latest Submission</th>
		</tr>
		<c:forEach items="${assignmentList}" var="item">
			<tr>
				<td><a
					href="DisplaySubmissions?courseid=${course.id}&assignmentid=${item.id}">${item.name}</a></td>
				<td>${item.submissions_counts}</td>
				<td><fmt:formatDate value="${item.latest_submissions}"
						pattern="MM/dd/yyyy hh:mm a" /></td>
			</tr>
		</c:forEach>
	</table>
	<h3>
		<a href="CreateAssignment?courseid=${course.id}">Create Assignment</a>
	</h3>
</body>
</html>