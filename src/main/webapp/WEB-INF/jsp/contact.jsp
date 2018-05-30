<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h1 class="display-4">Contact</h1>
<p class="lead"><spring:message code="contactMessage1"/></p>
<p class="lead"><spring:message code="contactMessage2"/></p>
<p class="lead"><spring:message code="contactMessage3V1"/><a href="mailto:savEquipementsSportifs@gmail.com" class="badge badge-info"><spring:message code="customerService"/></a><spring:message code="contactMessage3V2"/></p>

