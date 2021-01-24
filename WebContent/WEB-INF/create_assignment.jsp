<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create Assignemnt</title>
        <style>
            table {
                border: 1px solid black;
            } 

            th,td {
                border: 1px solid black;
                text-align: center; 
                vertical-align: middle;}</style>
    </head>
    <body>
        <h2><a href="DisplayCourses">Course Management</a> > 
            <a href="DisplayAssignments?courseid=${course.id}">${course.name}</a>
            > Create Assignment</h2>

        <form action="CreateAssignment" method="post">
            <table>
                <tr>
                    <th>Assignment Name</th> 
                    <td><input type="text" name="name" required="required"></td> 
                </tr>
                <input type="hidden" name="courseid" value="${course.id}"/>
                <tr>
                    <td colspan="2"><button type="submit">Create</button></td> 
                </tr>
            </table>
        </form>
</body>
</html>