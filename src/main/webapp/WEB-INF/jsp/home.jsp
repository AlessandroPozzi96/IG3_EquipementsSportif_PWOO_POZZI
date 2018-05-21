<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>

<h1>Envie de faire du sport ? </h1>
<security:authorize access="isAnonymous()">
    <p><a href='<spring:url value="/login"/>'>Connectez-vous </a> pour passer commande !</p>
    <p><a href='<spring:url value="/registration"/>'>Ou enregistrez-vous </a> si ce n'est pas déjà fait !</p>
</security:authorize>
<security:authorize access="hasRole('USER')">
    <p>Bienvenu <security:authentication property="principal.username" /> !</p>
    <p><a href='<spring:url value="/logout"/>'>Déconnexion</a></p>
</security:authorize>