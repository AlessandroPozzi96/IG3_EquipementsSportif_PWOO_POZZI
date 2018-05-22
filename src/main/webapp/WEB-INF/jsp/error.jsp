<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page isErrorPage="true" %>
    <h1 class="display-4">Sorry an exception occured!</h1>

    Exception is: <%= exception %> ${exception}
    <p class="lead">Champ non valide${contextPath}</p>