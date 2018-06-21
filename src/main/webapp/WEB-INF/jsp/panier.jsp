<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h1 class="display-4"><spring:message code="caddy"/> </h1>

<c:if test="${not empty panier.panierHashMap}" >
    <h2 class="h-auto"><spring:message code="articlesList"/></h2>
    <div class="table-responsive">
        <table class="table table-striped table-sm">
            <thead>
            <tr>
                <th><spring:message code="barCode"/></th>
                <th><spring:message code="articleName"/></th>
                <th><spring:message code="quantity"/></th>
                <th><spring:message code="unitPrice"/></th>
                <th><spring:message code="priceU"/></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${panier.panierHashMap}" var="article">
                <tr>
                    <form:form id="formPanier"
                               method="POST"
                               action='${contextPath}/panier?articleJson=${panier.articleToJson(article.key)}'
                               modelAttribute="panier">
                        <td><c:out value="${article.key.codeBarre}" /></td>
                        <td><c:out value="${article.key.libelle} ${article.key.taille} ${article.key.couleur}" /></td>
                        <td><form:input type="number" value="${article.value}" min="1" path="nbArticles" class="form-control" placeholder="Quantité" disabled="true"/>
                            <form:errors path="nbArticles" cssClass="has-error"></form:errors></td>
                        <td><c:out value="${article.key.prixUnitaire}" /></td>
                        <td><c:out value="${panier.getPrixArticle(article.key)}" />€</td>
                        <td>
                            <form:button type="submit" class="btn-block btn-danger" value="supprimer" name="supprimer"><spring:message code="delete"/></form:button>
                                <form:button type="submit" class="btn-block btn-info" value="ajouter" name="ajouter">+</form:button>
                                <form:button type="submit" class="btn-block btn-info" value="enlever" name="enlever">-</form:button>
                        </td>
                    </form:form>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><spring:message code="withoutPromotions"/> : ${panier.prixPanier}€</td>
                <td><spring:message code="withPromotions"/> : ${promotion.calculPromotion(panier)}€</td>
            </tr>
            </tfoot>
        </table>
    </div>
    <security:authorize access="isAuthenticated()">
        <a class="btn btn-block badge-warning" href='<spring:url value="/commande"/>'><spring:message code="order"/></a>
    </security:authorize>
    <security:authorize access="!isAuthenticated()">
        <p class="lead"><a class="badge badge-info" href="<spring:url value="/login"/>"><spring:message code="caddyNeedLogin"/></a></p>
    </security:authorize>
</c:if>
<c:if test="${empty panier.panierHashMap}" >
    <h2 class="h-auto"><spring:message code="noArticles"/></h2>
</c:if>
</br>
<p class="lead"><a class="badge badge-info" href='<spring:url value="/catalogue"/>'><spring:message code="catalog"/> </a></p>
<p class="lead"><a class="badge badge-info" href='<spring:url value="/"/>'><spring:message code="backToHome"/></a></p>