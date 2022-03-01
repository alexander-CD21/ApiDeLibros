<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
	<h1>All Books</h1>
	<table>
		   <thead>
		        <tr>
		           <th>ID</th>
		           <th>Title</th>
		           <th>Language</th>
		           <th>Number of Pages</th>
		       </tr>
		   </thead>
		   <tbody>
		         <!-- Recorre todos los libros para mostrar los detalles como en el wireframe! -->
		         <c:forEach var="libro" items="${books}">
			         <tr>
			           <th><a ><c:out value="${libro.id}"></c:out></a></th>
			           <th><a href="/book/${libro.id}"><c:out value="${libro.title}"></c:out></a></th>
			           <th><a ><c:out value="${libro.language}"></</c:out></a></th>
			           <th><a ><c:out value="${libro.numberOfPages}"></c:out></a></th>
			       	 </tr>
		       	 </c:forEach>
		       
		   </tbody>
		   
	</table>
	
	</body>
</html>