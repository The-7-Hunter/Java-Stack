<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit ${show.name}</h1>
	<form:form action="/editshow" method="post" modelAttribute="show">


		<%--- <input type="hidden" name="_method" value="put"> --%>
		<p>

			<form:label path="name">Name</form:label>

			<form:errors path="name" />

			<form:input path="name" />

		</p>

		<p>

			<form:label path="network">network</form:label>

			<form:errors path="network" />

			<form:textarea path="network" />

		</p>

		<p>

			<form:hidden  path="id" />

		</p>



		<input type="submit" value="Submit" />

	</form:form>
</body>
</html>