<%@ include file="include/importTags.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<spring:url value="" var="localeFr">
    <spring:param name="locale" value="fr" />
</spring:url>
<spring:url value="" var="localeEn">
    <spring:param name="locale" value="en" />
</spring:url>


<h1 id="h1" class="display-4"><spring:message code="signin"/></h1>
<security:authorize access="!isAuthenticated()">
    <form:form id="formLogin"
               method="POST"
               action="${contextPath}/login"
               modelAttribute="userEntity">
            <form:input id="login" type="text" path="username" onchange="loginValide();" class="form-control" placeholder="Ex: DarkDragon03"
                        autofocus="true"></form:input>
            <form:errors id="loginError" path="username" cssClass="has-error"></form:errors>
        <span id="loginError" class="has-error"></span>
        </br>
            <form:input id="password" type="password" path="password" onchange="passwordValide();" class="form-control" placeholder="Ex: MonMDP_Tr0pD4re!"></form:input>
            <form:errors id="passwordError" path="password" cssClass="has-error"></form:errors>
        <span id="passwordError" class="has-error"></span>
        </br>
        <form:button onclick="return (loginValide() && passwordValide());" class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="login"/></form:button>
        <form:button class="btn btn-lg btn-primary btn-block" type="reset"><spring:message code="reset"/></form:button>
    </form:form>
</security:authorize>
<security:authorize access="isAuthenticated()">
    <p class="lead"><spring:message code="alreadyAuthenticated"/> </p>
    <p class="lead"><a class="badge badge-info"href='<spring:url value="/logout"/>'><spring:message code="logout"/></a></p>
</security:authorize>
<p class="lead"><a class="badge badge-info" href='<spring:url value="/"/>'><spring:message code="backToHome"/></a></p>

<p class="lead lg-auto-2"><a href="${localeFr}">FR</a> | <a href="${localeEn}">EN</a></p>
