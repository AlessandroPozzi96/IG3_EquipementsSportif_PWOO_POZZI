<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<spring:message code='lang' var="lang"/>
<h1 class="display-4">Articles</h1>

<div class="row" >
    <c:forEach items="${articles}" var="article">
        <div class="col-sm-6">
            <a class="badge badge-secondary" href='<spring:url value="/article?codeBarre=${article.codeBarre}" />'>
                <img src='<spring:url value="${imageDAO.findByArticleEntityCodeBarre(article.codeBarre)[0].url}"/>' class="img-fluid mx-auto d-block">
                <c:set var="translation" value="${translationArticleDAO.findByTranslationArticlePK_CodeBarre_FKAndTranslationArticlePK_LangageID_FK(article.codeBarre, lang)}" />
                <p class="lead"><c:out value="${translation.libelle}" /></p>
                <p class="lead" ><spring:message code="priceL"/> : <c:out value="${article.prix}" />€</p>
            </a>
        </div>
    </c:forEach>
</div>
<p class="lead"><a class="badge badge-info" href='<spring:url value="/catalogue"/>'><spring:message code="catalog"/></a></p>
<p class="lead"><a class="badge badge-info" href='<spring:url value="/"/>'><spring:message code="backToHome"/></a></p>