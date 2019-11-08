<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/app.js"></script>
<title>Home Page</title>
</head>
<body>
	<h1>
		Hey there I am
		<c:out value="${Name}" />
	</h1>

	<c:out value="${2+2+3}" />


	<a href="/date"> Display Date </a>
	<p> ------------- </p>
	<a href="/time"> Display Time </a>
</body>
</html>