<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h1 class="display-4">Compte</h1>
<security:authorize access="isAnonymous()">
    <p class="lead">Veuillez vous <a href="<spring:url value="/login"/>">connecter</a></p>
</security:authorize>
<security:authorize access="isAuthenticated()">
    <h2 class="h-auto">Informations personnelles :</h2>
    <div class="table-responsive">
        <table class="table table-striped table-sm">
            <thead>
            <tr>
                <th>NOM</th>
                <th>CONTENU</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Username</td>
                <td><security:authentication property="principal.username" /></td>
            </tr>
            <tr>
                <td>Nom</td>
                <td><security:authentication property="principal.nom" /></td>
            </tr>
            <tr>
                <td>Prénom</td>
                <td><security:authentication property="principal.prenom" /></td>
            </tr>
            <tr>
                <td>Mail</td>
                <td><security:authentication property="principal.mail" /></td>
            </tr>
            <tr>
                <td>Localité</td>
                <td><security:authentication property="principal.localite" /></td>
            </tr>
            <tr>
                <td>Rue</td>
                <td><security:authentication property="principal.rue" /></td>
            </tr>
            <tr>
                <td>Code postal</td>
                <td><security:authentication property="principal.codePostal" /></td>
            </tr>
            <tr>
                <td>Numéro de téléphone</td>
                <td><security:authentication property="principal.numTelephone" /></td>
            </tr>
            <tr>
                <td>Date de naissance</td>
                <td><security:authentication property="principal.dateNaissance" /></td>
            </tr>
            <tr>
                <td>Homme</td>
                <td><security:authentication property="principal.male" /></td>
            </tr>
            </tbody>
        </table>
    </div>
</security:authorize>


