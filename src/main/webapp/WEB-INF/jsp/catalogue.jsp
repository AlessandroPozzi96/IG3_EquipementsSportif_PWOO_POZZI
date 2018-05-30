<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <h1 class="display-4"><spring:message code="catalog"/></h1>

<div class="row" >
    <c:forEach items="${categoriesArticles}" var="categorie">
        <div class="col-sm-6">
            <a class="badge badge-secondary" href='<spring:url value="/articles?id=${categorie.id}" />'>
                <img src='<spring:url value="${categorie.url_image}"/>' class="img-thumbnail rounded mx-auto d-block">
                <p class="lead p-lg-0"><c:out value="${categorie.libelle_fr}" /></p>
            </a>
        </div>
    </c:forEach>
</div>
<p class="lead"><a class="badge badge-info" href='<spring:url value="/"/>'><spring:message code="backToHome"/></a></p>
