<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <link type="text/css" href="<spring:url value='/css/bootstrap.min.css' />" rel="Stylesheet">
    <link type="text/css" href="<spring:url value='/css/bootstrap-grid.min.css' />" rel="Stylesheet">
    <script src="<spring:url value='/js/bootstrap.bundle.min.js' />"></script>
    <script src="<spring:url value='/js/bootstrap.min.js' />"></script>
</head>
<body>
    <div class="container">
        <h1>Envie de faire du sport ? </h1>
        <security:authorize access="isAnonymous()">
            <p><a href='<spring:url value="/login"/>'>Connectez-vous pour passer commande !</a></p>
        </security:authorize>
        <security:authorize access="hasRole('USER')">
            <p>Bienvenu <security:authentication property="principal.username" /> !</p>
        </security:authorize>
    </div>
</body>
</html>