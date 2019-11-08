<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
</head>
<body>
	<p><c:out value="${error }"></c:out></p>
	<form action="/login" method="POST">
		<label for="name"> Name </label> <input type="text" name="name">
		<label for="password"> Password </label> <input type="text"
			name="password"> <input type="submit">
	</form>
</body>
</html>