<%@ include file="include/importTags.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
</head>
<body>
    <h1 class="header-panel">Connectez-vous ! </h1>
    <security:authorize access="!isAuthenticated()">
        <form:form id="formLogin"
                   method="POST"
                   action="${contextPath}/login"
                   modelAttribute="userEntity">
            <spring:bind path="username">
                <form:input type="text" path="username" class="form-control" placeholder="Username"
                            autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
            </spring:bind>
            </br>
            <spring:bind path="password">
                <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
            </spring:bind>
            </br>
            <form:button>Login</form:button>
        </form:form>
    </security:authorize>
    <security:authorize access="isAuthenticated()">
        <p class="infoText">Vous êtes déjà authentifié !</p>
        <p><a href='<spring:url value="/logout"/>'>Déconnexion</a></p>
    </security:authorize>
    <p><a href='<spring:url value="/"/>'>Retour à l'accueil</a></p>
<%--<p>${message}</p>--%>
</body>
</html>