<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
</head>
<body>
<h1>Erreur ! Champ de formulaire incorrecte</h1>
<p><a href="<spring:url value='/registration'/>">Réessayer</a></p>
</body>
</html>