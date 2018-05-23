<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <h1 class="display-4">Envie de faire du sport ? Equipez-vous !</h1>
    <security:authorize access="isAnonymous()">
        <p class="lead"><a class="badge badge-primary" href='<spring:url value="/login"/>'>Connectez-vous </a> pour passer commande !</p>
        <p class="lead">Ou <a class="badge badge-primary" href='<spring:url value="/registration"/>'>enregistrez-vous </a> si ce n'est pas déjà fait !</p>
    </security:authorize>
    <security:authorize access="hasRole('USER')">
        <p class="lead">Bienvenu <security:authentication property="principal.username" /> !</p>
        <p class="lead"><a class="badge badge-primary" href='<spring:url value="/logout"/>'>Déconnexion</a></p>
    </security:authorize>