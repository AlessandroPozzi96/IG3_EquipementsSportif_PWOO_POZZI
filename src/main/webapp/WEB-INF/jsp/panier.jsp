<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h1 class="display-4">Panier </h1>

<c:if test="${not empty panier.panierHashMap}" >
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
            <c:forEach items="${panier.panierHashMap}" var="article">
                <tr>
                    <form:form id="formPanier"
                               method="POST"
                               action='${contextPath}/panier?articleJson=${panier.articleToJson(article.key)}'
                               modelAttribute="panier">
                        <td><c:out value="${article.key.codeBarre}" /></td>
                        <td><c:out value="${article.key.libelle} ${article.key.taille} ${article.key.couleur}" /></td>
                        <td><form:input type="number" value="${article.value}" min="1" path="nbArticles" class="form-control" placeholder="Quantité" />
                            <form:errors path="nbArticles" cssClass="has-error"></form:errors></td>
                        <td><c:out value="${article.key.prixUnitaire}" /></td>
                        <td><c:out value="${panier.getPrixArticle(article.key)}" /></td>
                        <td>
                            <form:button type="submit" class="btn-block btn-danger" value="supprimer" name="supprimer">Supprimer</form:button>
                            <form:button type="submit" class="btn-block btn-info" value="modifier" name="modifier">Modifier</form:button>
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
                <td>${panier.prixPanier} euros</td>
                <td></td>
            </tr>
            </tfoot>
        </table>
    </div>
    <p class="font-weight-bold" >Penser à cliquer sur le bouton <em>modifier</em> si avez avez changé la quantité !</p>
    <security:authorize access="isAuthenticated()">
        <a class="btn btn-block badge-warning" href='<spring:url value="/commande"/>'>Commander</a>
    </security:authorize>
    <security:authorize access="!isAuthenticated()">
        <p class="lead">Veuillez vous <a class="badge badge-primary" href="<spring:url value="/login"/>">connecter</a> pour pouvoir commander</p>
    </security:authorize>
</c:if>
<c:if test="${empty panier.panierHashMap}" >
    <h2 class="h-auto">Aucun panier à afficher</h2>
</c:if>

<p class="lead"><a class="badge badge-primary" href='<spring:url value="/catalogue"/>'>Catalogue</a></p>
<p class="lead"><a class="badge badge-primary" href='<spring:url value="/"/>'>Retour à l'accueil</a></p>