<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <h1 class="display-4">Catalogue </h1>
<p class="lead">Service indisponible pour le moment, veuillez nous excusez pour ce désagrément.</p>
<div class="row" >
    <c:forEach items="${categoriesArticles}" var="categorie">
        <div class="col-sm">
            <p class="lead" ><a class="badge badge-secondary" href="#">
            <c:out value="${categorie.libelle_fr}" />
        </a></p>
        </div>
    </c:forEach>
</div>
