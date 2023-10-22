<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Lista Estudante</h2>
	<table border="1">
		<tr>
			<th>FirstName</th>
			<th>LastName</th>
			<th>E-mail</th>
		</tr>
		
		<c:forEach var="ListStudent" items="${student_list}">
			<tr>
				<td>${ListStudent.firstName}</td>
				<td>${ListStudent.lastName}</td>
				<td>${ListStudent.email}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>