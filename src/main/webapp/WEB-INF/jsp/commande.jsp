<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

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
            <td>${panier.prixPanier}€</td>
        </tr>
        </tfoot>
    </table>
</div>
<form action="https://bitpay.com/checkout" method="post" >
    <input type="hidden" name="action" value="checkout" />
    <input type="hidden" name="posData" value="1" /> <%--Unique identifiant pour identifier la commande--%>
    <input type="hidden" name="data" value="vfzxtMQtHHtzvH4So3ZwwI4pW9hi39neieng7MYMH4Jp0c8uHVRtn6cjq+F+VmgJsZ3fYFQAZd6thvC1PNooMcW9zuV6hIjeVMgCdWv06neRmRulqZ5GEuhNpxVzqhorgRqclpnsUFnJFMVQfkE2aCVg2rGFuX3tbJL/4bBAN+InO9EFSZlYc3UsNwekWFqzwaUfd/xcFaI1abHvYGaLSfWQ70K2P63VLQyIT2V7kjlme+z5KBXfFbUcxaNBzB79" />
    <input type="image" src="https://bitpay.com/img/button2.png" border="0" name="submit" alt="BitPay, the easy way to pay with bitcoins." >
</form>

