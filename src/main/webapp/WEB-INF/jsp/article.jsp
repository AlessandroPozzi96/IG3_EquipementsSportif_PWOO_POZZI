<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<h1 class="display-4">${article.libelle_fr}</h1>
<p class="lead" ><c:out value="${article.description_fr}" /> </p>
<p class="lead" >Prix : <c:out value="${article.prix}" /> </p>
<div class="row" >
    <c:forEach items="${images}" var="image">
        <div class="col-sm-6">
            <p class="lead"><img src='<spring:url value="${image.url}"/>'></p>
        </div>
    </c:forEach>
</div>
<p class="lead"><a class="badge badge-primary" href='<spring:url value="/panier"/>'>Commander</a></p>
<p class="lead">Ajouter au <a class="badge badge-primary" href='<spring:url value="/panier"/>'>panier</a></p>
<p class="lead">Retour au <a class="badge badge-primary" href='<spring:url value="/catalogue"/>'> catalogue</a></p>
<p class="lead"><a class="badge badge-primary" href='<spring:url value="/"/>'>Retour à l'accueil</a></p>

