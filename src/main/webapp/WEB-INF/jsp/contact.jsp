<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<spring:url value="" var="localeFr">
    <spring:param name="locale" value="fr" />
</spring:url>
<spring:url value="" var="localeEn">
    <spring:param name="locale" value="en" />
</spring:url>


<h1 class="display-4">Contact</h1>
<p class="lead"><spring:message code="contactMessage1"/></p>
<p class="lead"><spring:message code="contactMessage2"/></p>
<p class="lead"><spring:message code="contactMessage3V1"/><a href="mailto:etu31410@henallux.be" class="badge badge-info"><spring:message code="customerService"/></a>.</p>

<p class="lead lg-auto-2"><a href="${localeFr}">FR</a> | <a href="${localeEn}">EN</a></p>


