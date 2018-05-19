<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Catalogue Page</title>
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
    </br>
    <spring:bind path="password">
        <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
        <form:errors path="password"></form:errors>
    </spring:bind>
    </br>
        <spring:bind path="mail">
            <form:input type="text" path="mail" class="form-control" placeholder="Mail"
                        autofocus="true"></form:input>
            <form:errors path="mail"></form:errors>
        </spring:bind>
        </br>
        <spring:bind path="nom">
            <form:input type="text" path="nom" class="form-control" placeholder="Nom"
                        autofocus="true"></form:input>
            <form:errors path="nom"></form:errors>
        </spring:bind>
        </br>
        <spring:bind path="prenom">
            <form:input type="text" path="prenom" class="form-control" placeholder="Prénom"
                        autofocus="true"></form:input>
            <form:errors path="prenom"></form:errors>
        </spring:bind>
        </br>
        <spring:bind path="codePostale">
            <form:input type="" path="codePostale" class="form-control" placeholder="CodePostale"
                        autofocus="true"></form:input>
            <form:errors path="codePostale"></form:errors>
        </spring:bind>
    <form:button>Save user</form:button>
        <form:button type="reset">Reset</form:button>
    </form:form>
</body>
</html>