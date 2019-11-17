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
    <a href="/logout"> Logout </a>

<h1>Welcome, ${username}</h1>
	<h1>all shows are here</h1>
	
	    <c:forEach items="${shows}" var="show">
        
            <p><c:out value="${show.name}"/></p>
            <p><c:out value="${show.network}"/></p>
            <p><c:out value="${show.average_rate}"/></p>
            
            <p> <a href="/shows/${show.id}"> Show </a> </p>
  
    </c:forEach>
    <a href="/shows/new/"> Add new show </a>
</body>
</html>