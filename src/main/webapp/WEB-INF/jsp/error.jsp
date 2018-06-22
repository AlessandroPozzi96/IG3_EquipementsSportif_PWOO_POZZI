<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page isErrorPage="true" %>
    <h1 class="display-4"><spring:message code="errorMessage"/> !</h1>

    <spring:message code="exceptionName"/> : <%= exception %>
    <p class="lead"><spring:message code="invalidFields"/> (source:${contextPath})</p>
<div class="px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
    <p class="lead"><spring:message code="errorEncountered"/> : ${error.toString()}</p>
</div>