<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
</head>
<body>
    <h1>Envie de faire du sport ? </h1>
    <security:authorize access="isAnonymous()">
        <p><a href='<spring:url value="/login"/>'>Connectez-vous pour passer commande !</a></p>
    </security:authorize>
    <security:authorize access="hasRole('USER')">
        <p>Bienvenu <security:authentication property="principal.username" /> !</p>
    </security:authorize>
</body>
</html>