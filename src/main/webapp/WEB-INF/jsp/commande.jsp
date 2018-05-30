<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<h1 class="display-4">Commande</h1>
<p class="lead">Vous êtes sur le point de commander ${panier.nbArticlesPanier} article(s) pour un total de ${panier.prixPanier}€</p>
<p class="lead">Afin de procéder au payement, veuiller utiliser notre partenaire BitPay (Payement disponible uniquement en BitCoins)</p>
<form action="https://bitpay.com/checkout" method="post" >
    <input type="hidden" name="action" value="checkout" />
    <input type="hidden" name="posData" value="1" /> <%--Unique identifiant pour identifier la commande--%>
    <input type="hidden" name="data" value="vfzxtMQtHHtzvH4So3ZwwI4pW9hi39neieng7MYMH4Jp0c8uHVRtn6cjq+F+VmgJsZ3fYFQAZd6thvC1PNooMcW9zuV6hIjeVMgCdWv06neRmRulqZ5GEuhNpxVzqhorgRqclpnsUFnJFMVQfkE2aCVg2rGFuX3tbJL/4bBAN+InO9EFSZlYc3UsNwekWFqzwaUfd/xcFaI1abHvYGaLSfWQ70K2P63VLQyIT2V7kjlme+z5KBXfFbUcxaNBzB79" />
    <input type="image" src="https://bitpay.com/img/button2.png" border="0" name="submit" alt="BitPay, the easy way to pay with bitcoins." >
</form>

