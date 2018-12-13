<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<h1 class="display-4"><spring:message code="signup"/> </h1>
</br>
<form:form id="formUser"
           method="POST"
           action="${contextPath}/registration"
           modelAttribute="user">
    <div class="form-group">
        <form:label path="username"><spring:message code="username"/></form:label>
        <form:input type="text" path="username" class="form-control" placeholder="Ex: Arthur007"
                    autofocus="true"></form:input>
        <form:errors path="username" cssClass="has-error"></form:errors>
    </div>

    <div class="form-group">
        <form:label path="password"><spring:message code="password"/></form:label>
        <form:input type="password" path="password" class="form-control" placeholder="Ex: MoN_MDP45*"></form:input>
        <form:errors path="password" cssClass="has-error"></form:errors>
    </div>
    </br>
    <div class="form-group">
        <form:label path="confirmPassword"><spring:message code="confirmPassword"/></form:label>
        <form:input type="password" path="confirmPassword" class="form-control" placeholder="Ex: MoN_MDP45*"></form:input>
        <form:errors path="confirmPassword" cssClass="has-error"></form:errors>
    </div>
    </br>
    <div class="form-group">
        <form:label path="nom"><spring:message code="lastName"/></form:label>
        <form:input type="text" path="nom" class="form-control" placeholder="Ex: Miller"></form:input>
        <form:errors path="nom" cssClass="has-error"></form:errors>
    </div>
    </br>
    <div class="form-group">
        <form:label path="prenom"><spring:message code="firstName"/></form:label>
        <form:input type="text" path="prenom" class="form-control" placeholder="Ex: John"></form:input>
        <form:errors path="prenom" cssClass="has-error"></form:errors>
    </div>

       <div class="form-group">
           <form:label path="mail"><spring:message code="mail"/></form:label>
           <form:input type="text" path="mail" class="form-control" placeholder="Ex: mickelSnow@hotmail.com"></form:input>
           <form:errors path="mail" cssClass="has-error"></form:errors>
       </div>

    <div class="form-group">
        <form:label path="localite"><spring:message code="locality"/></form:label>
        <form:input type="text" path="localite" class="form-control" placeholder="Ex: Namur"></form:input>
        <form:errors path="localite" cssClass="has-error"></form:errors>
    </div>

    <div class="form-group">
        <form:label path="rue"><spring:message code="street"/></form:label>
        <form:input type="text" path="rue" class="form-control" placeholder="Ex: Rue du cheval Noir"></form:input>
        <form:errors path="rue" cssClass="has-error"></form:errors>
    </div>

    <div class="form-group">
        <form:label path="codePostal"><spring:message code="zipcode"/></form:label>
        <form:input type="number" path="codePostal" min="0" class="form-control" placeholder="Ex: 7800"></form:input>
        <form:errors path="codePostal" cssClass="has-error"></form:errors>
    </div>

    <div class="form-group">
        <form:label path="numTelephone"><spring:message code="numberphone"/></form:label>
        <form:label path="numTelephone"><spring:message code="notMandatory"/></form:label>
        <form:input type="number" path="numTelephone" size="13" minLength="9" maxLength="14"  class="form-control"
                    placeholder="Ex: 0475118526"></form:input>
        <form:errors path="numTelephone" cssClass="has-error"></form:errors>
    </div>

    <div class="form-group">
        <form:label path="dateNaissance"><spring:message code="birthDate"/></form:label>
        <form:input type="date" path="DateNaissance" class="form-control" placeholder="Ex: 07/03/1992"></form:input>
        <form:errors path="dateNaissance" cssClass="has-error"></form:errors>
    </div>
    <div class="form-group">
        <form:label path="Male"><spring:message code="sex"/> : </form:label>
        </br>
        <spring:bind path="Male">
            <form:label path="Male"><spring:message code="male"/></form:label>
            <form:radiobutton path="Male" value="true" checked="checked"/>
            <form:label path="Male"><spring:message code="female"/></form:label>
            <form:radiobutton path="Male" value="false" />
        </spring:bind>
    </div>
    </br>
    <form:button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="saveUser"/> </form:button>
    <form:button class="btn btn-lg btn-primary btn-block" type="reset"><spring:message code="reset"/> </form:button>
</form:form>
<p class="lead"><a class="badge badge-primary" href='<spring:url value="/"/>'><spring:message code="backToHome"/> </a></p>

<p class="lead lg-auto-2"><a href="${localeFr}">FR</a> | <a href="${localeEn}">EN</a></p>

<spring:url value="" var="localeFr">
    <spring:param name="locale" value="fr" />
</spring:url>
<spring:url value="" var="localeEn">
    <spring:param name="locale" value="en" />
</spring:url>
