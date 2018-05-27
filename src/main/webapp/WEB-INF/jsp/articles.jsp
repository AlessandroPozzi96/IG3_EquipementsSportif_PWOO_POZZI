<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h1 class="display-4">Articles </h1>

<div class="row" >
    <c:forEach items="${articles}" var="article">
        <div class="col-sm-6">
            <a class="badge badge-secondary" href='<spring:url value="/article?codeBarre=${article.codeBarre}" />'>
                <img src='<spring:url value="${imageDAO.findByArticleEntityCodeBarre(article.codeBarre)[0].url}"/>' class="img-fluid rounded mx-auto d-block">
                <p class="lead"><c:out value="${article.libelle_fr}" /></p>
                <p class="lead" >Prix : <c:out value="${article.prix}" />€</p>
            </a>
        </div>
    </c:forEach>
</div>
<p class="lead">Mauvaise catégorie ? retournez au <a class="badge badge-primary" href='<spring:url value="/catalogue"/>'>catalogue</a> !</p>
<p class="lead"><a class="badge badge-primary" href='<spring:url value="/"/>'>Retour à l'accueil</a></p>