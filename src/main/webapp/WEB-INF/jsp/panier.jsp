<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h1 class="display-4">Panier </h1>
<p class="lead">Service indisponible pour le moment, veuillez nous excusez pour ce désagrément.</p>
<p class="lead"><a class="badge badge-primary" href='<spring:url value="/catalogue"/>'>Catalogue</a></p>
<p class="lead"><a class="badge badge-primary" href='<spring:url value="/"/>'>Retour à l'accueil</a></p>