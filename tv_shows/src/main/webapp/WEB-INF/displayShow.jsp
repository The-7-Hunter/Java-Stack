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

	<p>
		Average Rating:
		<c:out value="${size}" />
	</p>
	<a href="/shows/${show.id}/edit"> <input type="submit"
		value="Edit Show" />
	</a>
	<p></p>
	<form:form action="/shows/${show.id}/delete" method="post"
		modelAttribute="show">

		<input type="submit" value="Delete Show" />

	</form:form>

	<h1>Ratings</h1>
	<c:forEach items="${rattings}" var="rate">

		<p>
			<c:out value="${rate.ratter}" />
		</p>
		<p>
			<c:out value="${rate.rate_value}" />
		</p>
		<p>
			<c:out value="${show.id}" />
		</p>

	</c:forEach>

	<h1>Add rate</h1>
	<form:form action="/newrate" method="post" modelAttribute="rate">
		<p>
			<form:label path="ratter">name</form:label>
			<form:errors path="ratter" />
			<form:input path="ratter" />
		</p>
		<p>
			<form:label path="rate_value">Rating Value</form:label>
			<form:errors path="rate_value" />
			<form:input type="number" path="rate_value" />
		</p>

		<form:hidden path="show" value="${show.id}" />
		<input type="submit" value="Add Rate" />

	</form:form>


</body>
</html>