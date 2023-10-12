<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page import="java.io.*,java.util.*,java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Utilizando o JSPTL com mysql</title>
</head>
<body>
	<sql:setDataSource 
	var="snapshot"
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/contato?useSSL=false&serverTimezone=UTC"
	user="root"
	password=""
	/>
	
	<sql:query dataSource="${snapshot}" var="result">
		select id, nome, email from agenda
	</sql:query>
	
	<table border="1" style="width: 100%">
	<tr>
		<th> Id </th>
		<th>Funcionário</th>
		<th>E-mail</th>
	</tr>
	<c:forEach var="registro" items="${result.rows}">
		<tr>
			<td><c:out value="${registro.id}"></c:out></td>
			<td><c:out value="${registro.nome}"></c:out></td>
			<td><c:out value="${registro.email}"></c:out></td>
		</tr>
	</c:forEach>
	
	</table>
</body>
</html>