<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<h1 class="display-4">${article.libelle_fr}</h1>
<p class="lead" ><c:out value="${article.description_fr}" /> </p>
<p class="lead" >Prix : <c:out value="${article.prix}" /> </p>
<div class="row" >
    <c:forEach items="${images}" var="image">
        <div class="col-sm-6">
            <img src='<spring:url value="${image.url}"/>' class="img-fluid rounded mx-auto d-block" alt="'<spring:url value="${image.description_fr}"/>'">
        </div>
    </c:forEach>
</div>
<form:form id="formArticle"
           method="POST"
           action="${contextPath}/article"
           modelAttribute="nbArticles">
    </br>
    <form:input type="number" path="nbArticles" value="1" min="1" class="form-control" placeholder="Quantité :"
                autofocus="true"></form:input>
    <form:errors path="nbArticles"></form:errors>
    <c:if test="${not empty tailles}" >
        </br>
        <form:select path="taille">
            <form:options items="${tailles}" itemValue="taille_fk" itemLabel="taille_fk" />
        </form:select>
        </br>
    </c:if>
    <c:if test="${not empty couleurs}" >
        </br>
        <form:select path="couleur">
            <form:options items="${couleurs}" itemValue="couleur_fk" itemLabel="couleur_fk" />
        </form:select>
        </br>
    </c:if>
    </br>
    <form:button class="btn btn-lg btn-primary btn-block" type="submit">Commander</form:button>
    <form:button class="btn btn-lg btn-primary btn-block" type="reset">Réinitialiser</form:button>
</form:form>

<p class="lead">Retour au <a class="badge badge-primary" href='<spring:url value="/catalogue"/>'> catalogue</a></p>
<p class="lead"><a class="badge badge-primary" href='<spring:url value="/"/>'>Retour à l'accueil</a></p>
