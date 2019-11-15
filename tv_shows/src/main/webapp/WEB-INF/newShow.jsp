<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hey I am new show form</h1>
	<form:form action="/newshow" method="post" modelAttribute="show">
		<p>
			<form:label path="name">Name</form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</p>
		<p>
			<form:label path="network">Network</form:label>
			<form:errors path="network" />
			<form:textarea path="network" />
		</p>
		<p>
			<form:label path="average_rate">average_rate</form:label>
			<form:errors path="average_rate" />
			<form:input type="number" path="average_rate" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>