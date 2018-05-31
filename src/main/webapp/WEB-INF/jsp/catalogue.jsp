<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<spring:message code='lang' var="lang"/>

    <h1 class="display-4"><spring:message code="catalog"/></h1>

<div class="row" >
    <c:forEach items="${categoriesArticles}" var="categorie">
        <div class="col-sm-6">
            <a class="badge badge-secondary" href='<spring:url value="/articles?id=${categorie.id}" />'>
                <img src='<spring:url value="${categorie.url_image}"/>' class="img-thumbnail rounded mx-auto d-block">
                <c:set var="translation" value="${translationCategorieDAO.findByTranslationCategoriePK_IdCategorie_FKAndTranslationCategoriePK_LangageID_FK(categorie.id, lang)}" />
                <p class="lead p-lg-0"><c:out value="${translation.libelle}" /></p>
            </a>
        </div>
    </c:forEach>
</div>
<p class="lead"><a class="badge badge-info" href='<spring:url value="/"/>'><spring:message code="backToHome"/></a></p>
