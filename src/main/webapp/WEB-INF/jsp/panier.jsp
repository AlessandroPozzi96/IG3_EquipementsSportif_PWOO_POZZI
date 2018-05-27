<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h1 class="display-4">Panier </h1>

<c:if test="${not empty nbArticles.achatsArticles}" >
    <h2 class="h-auto">Liste de vos articles :</h2>
    <div class="table-responsive">
        <table class="table table-striped table-sm">
            <thead>
            <tr>
                <th>CODE BARRE</th>
                <th>NOM ARTICLE</th>
                <th>QUANTITE</th>
                <th>PRIX UNITAIRE</th>
                <th>PRIX</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${lignesPaniers}" var="article">
                <tr>
                    <form:form id="formPanier"
                               method="POST"
                               action="${contextPath}/panier?codeBarre=${article.codeBarre}"
                               modelAttribute="aSupprimer">
                        <td><c:out value="${article.codeBarre}" /></td>
                        <td><c:out value="${article.libelle}" /></td>
                        <td><c:out value="${article.quantite}" /></td>
                        <td><c:out value="${article.prixUnitaire}" /></td>
                        <td><c:out value="${article.prix}" /></td>
                        <td>
                            <form:button type="submit" class="btn-block btn-danger" value="Supprimer" name="supprimer">Supprimer</form:button>
                            <form:button class="btn-block btn-primary" type="submit" name="modifier" value="Modifier">Modifier</form:button>
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
                <td>${prixTot} euros</td>
                <td></td>
            </tr>
            </tfoot>
        </table>
    </div>
</c:if>
<c:if test="${empty nbArticles.achatsArticles}" >
    <h2 class="h-auto">Aucun article à afficher</h2>
</c:if>

<p class="lead"><a class="badge badge-primary" href='<spring:url value="/catalogue"/>'>Catalogue</a></p>
<p class="lead"><a class="badge badge-primary" href='<spring:url value="/"/>'>Retour à l'accueil</a></p>