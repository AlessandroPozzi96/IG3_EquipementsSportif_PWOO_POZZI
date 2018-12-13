<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<spring:url value="" var="localeFr">
    <spring:param name="locale" value="fr" />
</spring:url>
<spring:url value="" var="localeEn">
    <spring:param name="locale" value="en" />
</spring:url>

<h1 class="display-4"><spring:message code="order"/></h1>

<h3 class="display-4"><spring:message code="summary"/> </h3>
<div class="table-responsive">
    <table class="table table-striped table-sm">
        <thead>
        <tr>
            <th><spring:message code="barCode"/></th>
            <th><spring:message code="articleName"/></th>
            <th><spring:message code="quantity"/></th>
            <th><spring:message code="unitPrice"/></th>
            <th><spring:message code="priceU"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${panier.panierHashMap}" var="article">
            <tr>
                    <td><c:out value="${article.key.codeBarre}" /></td>
                    <td><c:out value="${article.key.libelle} ${article.key.taille} ${article.key.couleur}" /></td>
                    <td><c:out value="${article.value}" /></td>
                    <td><c:out value="${article.key.prixUnitaire}" /></td>
                    <td><c:out value="${panier.getPrixArticle(article.key)}" />€</td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><spring:message code="total"/> : ${promotion.calculPromotion(panier)}€</td>
        </tr>
        </tfoot>
    </table>
</div>

<form method="post" action="${contextPath}/commande/pay">
    <p class="lead"><spring:message code="processPayement"/> </p>
    <button type="submit" class="btn-link"><img src='<spring:url value="/images/paypal.png"/>' class="img-thumbnail"></button>
</form>
<p class="lead lg-auto-2"><a href="${localeFr}">FR</a> | <a href="${localeEn}">EN</a></p>


