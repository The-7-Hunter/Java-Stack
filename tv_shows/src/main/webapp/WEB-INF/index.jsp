

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page isErrorPage="true" %>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <link rel="stylesheet" href="main.css">

    <title>Welcome</title>

</head>

<body>

<div id="container">

    <h1>Welcome</h1>

    <div id="leftpanel">

        <h1>Register</h1>

        <form:form method="post" action="/register" modelAttribute="userObj">

            <h4 class="avoid">

                <form:label path="username">username:</form:label>

                <form:input cssClass="fields" type="text" path="username"/>

            </h4>

            <h4 class="avoid">

                <form:label path="email">Email:</form:label>

                <form:input cssClass="fields" type="email" path="email"/>

            </h4>

​

            <h4 class="avoid">

                <form:label path="password">Password:</form:label>

                <form:password cssClass="fields" path="password"/>

            </h4>

            <h4 class="avoid">

                <form:label path="passwordConfirmation">Password Confirmation:</form:label>

                <form:password cssClass="fields" path="passwordConfirmation"/>

            </h4>

            <input class="btn" type="submit" value="Register"/>

        </form:form>

        <form:errors cssClass="red" path="userObj.*"/>

    </div>

    <div id="rightpanel">

        <h1>Login</h1>

        <form action="/login" method="post">

            <h4>Email:<input class="fields" type="email" name="email"></h4>

            <h4>Password:<input class="fields" type="password" name="password"></h4>

            <input class="btn" type="submit" value="Login">

        </form>

    </div>

</div>

</body>

</html>

