<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
</head>
<body>
<h1 class="header-panel">Enregistrez-vous pour pouvoir commander !</h1>
<form:form id="formUser"
           method="POST"
           action="${contextPath}/registration"
           modelAttribute="user">
    <spring:bind path="username">
        <form:input type="text" path="username" class="form-control" placeholder="Username"
                    autofocus="true"></form:input>
        <form:errors path="username"></form:errors>
    </spring:bind>
    <form:button type="submit">Save user</form:button>
    <form:button type="reset">Reset</form:button>
</form:form>
</body>
</html>