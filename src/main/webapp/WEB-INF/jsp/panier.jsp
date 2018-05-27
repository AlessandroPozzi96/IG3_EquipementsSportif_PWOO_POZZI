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
                    <form:form id="formLignesPanier"
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

    <security:authorize access="isAuthenticated()">
        <form action="https://bitpay.com/checkout" method="post" >
            <input type="hidden" name="action" value="checkout" />
            <input type="hidden" name="posData" value="1" /> <%--Unique identifiant pour identifier la commande--%>
            <input type="hidden" name="data" value="vfzxtMQtHHtzvH4So3ZwwI4pW9hi39neieng7MYMH4Jp0c8uHVRtn6cjq+F+VmgJsZ3fYFQAZd6thvC1PNooMcW9zuV6hIjeVMgCdWv06neRmRulqZ5GEuhNpxVzqhorgRqclpnsUFnJFMVQfkE2aCVg2rGFuX3tbJL/4bBAN+InO9EFSZlYc3UsNwekWFqzwaUfd/xcFaI1abHvYGaLSfWQ70K2P63VLQyIT2V7kjlme+z5KBXfFbUcxaNBzB79" />
            <input type="image" src="https://bitpay.com/img/button2.png" border="0" name="submit" alt="BitPay, the easy way to pay with bitcoins." >
        </form>
    </security:authorize>
    <security:authorize access="!isAuthenticated()">
        <p class="lead">Veuillez vous <a class="badge badge-primary" href="<spring:url value="/login"/>">connecter</a> pour pouvoir commander</p>
    </security:authorize>
</c:if>
<c:if test="${empty nbArticles.achatsArticles}" >
    <h2 class="h-auto">Aucun article à afficher</h2>
</c:if>

<p class="lead"><a class="badge badge-primary" href='<spring:url value="/catalogue"/>'>Catalogue</a></p>
<p class="lead"><a class="badge badge-primary" href='<spring:url value="/"/>'>Retour à l'accueil</a></p>