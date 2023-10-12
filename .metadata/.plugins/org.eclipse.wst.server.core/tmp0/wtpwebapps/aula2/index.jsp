<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Utilizando o JSPTL</title>
</head>
<body>
	<c:set var="salary" scope="session" value="${2000*2}"/>
	O salário é: <c:out value="${salary}"/>
	<c:if test="${salary >= 2000}">
		<p>
			<c:out value="${'Salário maior ou igual a 2000'}"/>
		</p>
	</c:if>
	<c:if test="${salary < 2000}">
		<p>
			<c:out value="${'Salário menor do que 2000'}"/>
		</p>
	</c:if>
</body>
</html>