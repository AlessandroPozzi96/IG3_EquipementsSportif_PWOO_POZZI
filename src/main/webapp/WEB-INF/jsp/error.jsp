<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page isErrorPage="true" %>
    <h1 class="display-4">Sorry an exception occured!</h1>

    Exception is: <%= exception %>
    <p class="lead">Champ(s) non valide(s) (source:${contextPath})</p>
<div class="px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
    <p class="lead">Erreur recontré : ${error.toString()}</p>
</div>