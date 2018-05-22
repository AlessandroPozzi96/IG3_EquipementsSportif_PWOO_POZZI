<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

    <h1 class="display-4">Enregistrement</h1>
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
        <spring:bind path="confirmPassword">
            <form:input type="password" path="confirmPassword" class="form-control" placeholder="Confirm Password"></form:input>
            <form:errors path="confirmPassword"></form:errors>
        </spring:bind>
        </br>
        <spring:bind path="nom">
            <form:input type="text" path="nom" class="form-control" placeholder="Nom de famille"></form:input>
            <form:errors path="nom"></form:errors>
        </spring:bind>
        </br>
        <spring:bind path="prenom">
            <form:input type="text" path="prenom" class="form-control" placeholder="Prenom"></form:input>
            <form:errors path="prenom"></form:errors>
        </spring:bind>
        </br>
        <spring:bind path="mail">
            <form:input type="email" path="mail" class="form-control" placeholder="Mail"></form:input>
            <form:errors path="mail"></form:errors>
        </spring:bind>
        </br>
        <spring:bind path="localite">
            <form:input type="text" path="localite" class="form-control" placeholder="Localite"></form:input>
            <form:errors path="localite"></form:errors>
        </spring:bind>
        </br>
        <spring:bind path="rue">
            <form:input type="text" path="rue" class="form-control" placeholder="Rue"></form:input>
            <form:errors path="rue"></form:errors>
        </spring:bind>
        </br>
        <spring:bind path="codePostal">
            <form:input type="number" path="codePostal" class="form-control" placeholder="Code postal"></form:input>
            <form:errors path="codePostal"></form:errors>
        </spring:bind>
        </br>
        <spring:bind path="numTelephone">
            <form:input type="tel" path="numTelephone" class="form-control" placeholder="Numéro de telephone"></form:input>
            <form:errors path="numTelephone"></form:errors>
        </spring:bind>
        </br>
        <spring:bind path="DateNaissance">
            <form:input type="date" path="DateNaissance" class="form-control" placeholder="Date de naissance"></form:input>
            <form:errors path="dateNaissance"></form:errors>
        </spring:bind>
        </br>
        <spring:bind path="Male">
            <p class="lead">Homme :</p>
            <form:radiobutton path="Male" value="true" />
            <p class="lead">Femme :</p>
            <form:radiobutton path="Male" value="false" />
            <form:errors path="Male"></form:errors>
        </spring:bind>
        </br>
        <form:button class="btn btn-lg btn-primary btn-block" type="submit">Save user</form:button>
        <form:button class="btn btn-lg btn-primary btn-block" type="reset">Reset</form:button>
    </form:form>
<p class="lead"><a href='<spring:url value="/"/>'>Retour à l'accueil</a></p>