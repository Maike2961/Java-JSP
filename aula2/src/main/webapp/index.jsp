<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Utilizando o JSPTL</title>
</head>
<body>
	<c:set var="now" value="<%=new java.util.Date() %>"/>
	<c:out value="${now}"></c:out>
	<p>
		Formatando Hora:
		<fmt:formatDate type="time" value="${now}"/>
	</p>
	
	<p>
		Formatando Data:
		<fmt:formatDate type="date" value="${now}"/>
	</p>
	
	<p>
		Formatando Hora e Data:
		<fmt:formatDate type="both" value="${now}"/>
	</p>
	
	<p>
		Formatando Data para Dia, mês, ano:
		<fmt:formatDate pattern="dd-MM-yyyy" value="${now}"/>
	</p>
	
	
</body>
</html>