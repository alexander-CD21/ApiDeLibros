<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>libro </title>
	</head>
	<body>
		<h1><c:out value="${book.title}"></c:out></h1>
		<h3>Description:<c:out value="${book.description}"></c:out></h3>
		<h3>Language:<c:out value="${book.language}"></c:out></h3>
		<h3>Number of Pages:<c:out value="${book.numberOfPages}"></c:out></h3>
		<a href="/books">Regresar</a>
	</body>
	
</html>