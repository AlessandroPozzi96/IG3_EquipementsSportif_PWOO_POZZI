<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<spring:message code='lang' var="lang"/>
<c:set var="translation" value="${translationArticleDAO.findByTranslationArticlePK_CodeBarre_FKAndTranslationArticlePK_LangageID_FK(param.codeBarre, lang)}" />

<h1 class="display-4">${translation.libelle}</h1>
<p class="lead" ><c:out value="${translation.description}" /> </p>
<h3 class="mb-lg-auto-4" ><spring:message code="priceL"/> : <c:out value="${article.prix}€" /> </h3>
<div class="row" >
    <c:forEach items="${images}" var="image">
        <div class="col-sm-6">
            <img src='<spring:url value="${image.url}"/>' class="img-fluid rounded mx-auto d-block">
        </div>
    </c:forEach>
</div>
<form:form id="formArticle"
           method="POST"
           action="${contextPath}/article"
           modelAttribute="panier">
    </br>
    <c:if test="${not empty tailles}" >
        </br>
        <form:label path="taille"><spring:message code="size"/> :</form:label>
        <form:select path="taille" class="custom-select">
            <form:options items="${tailles}" itemValue="taille_fk" itemLabel="taille_fk" />
        </form:select>
        </br>
    </c:if>
    <c:if test="${not empty couleurs}" >
        </br>
        <form:label path="couleur"><spring:message code="color"/> :</form:label>
        <form:select path="couleur" class="custom-select">
            <form:options items="${couleurs}" itemValue="couleur_fk" itemLabel="couleur_fk" />
        </form:select>
        </br>
    </c:if>
    </br>
    <form:button class="btn btn-lg btn-info btn-block" type="submit"><spring:message code="addToCaddy"/></form:button>
    <form:button class="btn btn-lg btn-info btn-block" type="reset"><spring:message code="reset"/></form:button>
</form:form>
</br>
<p class="lead"><a class="badge badge-info" href='<spring:url value="/catalogue"/>'><spring:message code="catalog"/></a></p>
<p class="lead"><a class="badge badge-info" href='<spring:url value="/"/>'><spring:message code="backToHome"/></a></p>
