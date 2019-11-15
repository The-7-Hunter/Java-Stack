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
	<h1>
		I am Show number
		<c:out value="${show.id}" />
	</h1>
	<p>
		<c:out value="${show.name}" />
	</p>
	<p>
		<c:out value="${show.network}" />
	</p>
	<p>
		<c:out value="${show.average_rate}" />
	</p>

	<a href="/shows/${show.id}/edit"> Edit Show </a>
	<p></p>
	<a href="/shows/${show.id}/delete"> Delete Show </a>


</body>
</html>