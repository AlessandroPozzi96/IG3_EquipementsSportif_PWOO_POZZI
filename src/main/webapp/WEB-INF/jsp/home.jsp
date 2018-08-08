<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<spring:url value="" var="localeFr">
    <spring:param name="locale" value="fr" />
</spring:url>

<spring:url value="" var="localeEn">
    <spring:param name="locale" value="en" />
</spring:url>

    <h1 class="display-4"><spring:message code="homeMessage"/></h1>
<div class="embed-responsive embed-responsive-16by9">
    <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/mcwpL52M7To?rel=0" allowfullscreen></iframe>
</div>

<p class="lead lg-auto-2"><a href="${localeFr}">FR</a> | <a href="${localeEn}">EN</a></p>