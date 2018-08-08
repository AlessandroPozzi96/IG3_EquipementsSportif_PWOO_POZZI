<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<h1 class="display-4"><spring:message code="adminPage"/></h1>

<p class="lead"><spring:message code="currentURL"/> :${requestScope['javax.servlet.forward.request_uri']}</p>
//test