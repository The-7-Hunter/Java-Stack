<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>
		<a href="/books/all"> Back </a>
	</h2>
	
	<h1>Title:</h1>
	<p>
		<c:out value="${book.title}" />
	</p>
	<h1>Description:</h1>
	<p>
		<c:out value="${book.description}" />
	</p>
	<h1>Language:</h1>
	<p>
		<c:out value="${book.language}" />
	</p>
	<h1>Pages:</h1>
	<p>
		<c:out value="${book.numberOfPages}" />
	</p>
	<a href="/books/${book.id}/edit"> Edit </a>


</body>
</html>