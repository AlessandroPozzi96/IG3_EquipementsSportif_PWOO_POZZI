<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h1 class="display-4"><spring:message code="account"/></h1>
<security:authorize access="isAnonymous()">
    <p class="lead"><a class="badge badge-primary" href="<spring:url value="/login"/>"><spring:message code="accountMessage" /> </a></p>
</security:authorize>
<security:authorize access="isAuthenticated()">
    <h2 class="h-auto"><spring:message code="personalInformations"/> </h2>
    <div class="table-responsive">
        <table class="table table-striped table-sm">
            <thead>
            <tr>
                <th><spring:message code="name"/></th>
                <th><spring:message code="value"/></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><spring:message code="username"/></td>
                <td><security:authentication property="principal.username" /></td>
            </tr>
            <tr>
                <td><spring:message code="lastName"/></td>
                <td><security:authentication property="principal.nom" /></td>
            </tr>
            <tr>
                <td><spring:message code="firstName"/></td>
                <td><security:authentication property="principal.prenom" /></td>
            </tr>
            <tr>
                <td><spring:message code="mail"/></td>
                <td><security:authentication property="principal.mail" /></td>
            </tr>
            <tr>
                <td><spring:message code="locality"/></td>
                <td><security:authentication property="principal.localite" /></td>
            </tr>
            <tr>
                <td><spring:message code="street"/></td>
                <td><security:authentication property="principal.rue" /></td>
            </tr>
            <tr>
                <td><spring:message code="zipcode"/></td>
                <td><security:authentication property="principal.codePostal" /></td>
            </tr>
            <tr>
                <td><spring:message code="numberphone"/></td>
                <td><c:choose>
                    <c:when test="${pageContext.request.userPrincipal.principal.numTelephone == null}" >
                        <spring:message code="noNumberPhone"/>
                    </c:when>
                    <c:otherwise>
                        <security:authentication property='principal.numTelephone' />
                    </c:otherwise>
                </c:choose></td>
            </tr>
            <tr>
                <td><spring:message code="birthDate"/></td>
                <td><security:authentication property="principal.dateNaissance" /></td>
            </tr>
            <tr>
                <td><spring:message code="sex"/></td>
                <td><c:choose>
                    <c:when test="${pageContext.request.userPrincipal.principal.male == true}">
                        <spring:message code="male"/>
                    </c:when>
                    <c:otherwise>
                        <spring:message code="female"/>
                    </c:otherwise>
                </c:choose></td>
            </tr>
            </tbody>
        </table>
    </div>
    <security:authorize access="hasRole('ADMIN')" >
        <p class="lead"><a class="badge badge-info" href='<spring:url value="/admin"/>'>ADMIN</a></p>
    </security:authorize>
</security:authorize>
//test

