<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<spring:url value="" var="localeFr">
    <spring:param name="locale" value="fr" />
</spring:url>
<spring:url value="" var="localeEn">
    <spring:param name="locale" value="en" />
</spring:url>

<h1 class="display-4"><spring:message code="adminPage"/></h1>

<p class="lead"><spring:message code="currentURL"/> :${requestScope['javax.servlet.forward.request_uri']}</p>
<p class="lead lg-auto-2"><a href="${localeFr}">FR</a> | <a href="${localeEn}">EN</a></p>
