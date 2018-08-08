<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML>
<html lang="fr">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" >
    <title>${title}</title>

    <link rel="icon" href="<spring:url value='/images/haltere.png' />">
    <link type="text/css" href="<spring:url value='/css/style.css' />" rel="Stylesheet">
    <link type="text/css" href="<spring:url value='/css/bootstrap.min.css' />" rel="Stylesheet">
    <link type="text/css" href="<spring:url value='/css/carousel.css' />" rel="Stylesheet">
    <script src="<spring:url value='/js/jQuery.min.js' />" ></script>
    <script src="<spring:url value='/js/test.js' />" ></script>

</head>
<body>
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
        <h5 class="my-0 mr-md-auto"><a class="p-2 text-dark" href="<spring:url value='/' />">EquipementsSportifs</a></h5>
        <security:authorize access="hasRole('USER')">
        <h5 class="my-3 mr-md-auto font-weight-normal"><spring:message code="helloMessageClient"/> <security:authentication property="principal.username" /> !</h5>
        </security:authorize>
        <security:authorize access="hasRole('ADMIN')">
            <h5 class="my-3 mr-md-auto font-weight-normal"><spring:message code="helloMessageAdmin"/> <security:authentication property="principal.username" /> !</h5>
        </security:authorize>
        <nav class="my-2 my-md-0 mr-md-3">
            <a class="p-2 text-dark" href="<spring:url value='/' />"><spring:message code="home"/> </a>
            <a class="p-2 text-dark" href="<spring:url value='/catalogue' />"><spring:message code="catalog"/></a>
            <a class="p-2 text-dark" href="<spring:url value='/compte' />"><spring:message code="account"/></a>
            <a class="p-2 text-dark" href="<spring:url value='/contact' />">Contact</a>
            <security:authorize access="isAuthenticated()">
                <a class="p-2 text-dark" href="<spring:url value='/logout' />"><spring:message code="logout"/></a>
            </security:authorize>
        </nav>
        <p class="lead"> ${panier.nbArticlesPanier} <spring:message code="caddyMessage"/> <a class="btn btn-outline-primary" href="<spring:url value='/panier' />"><spring:message code="caddy"/></a></p>
        <security:authorize access="isAnonymous()">
            <p class="lead">
                <a class="btn btn-outline-primary" href="<spring:url value='/registration' />"><spring:message code="signup"/></a>
                <a class="btn btn-outline-primary" href="<spring:url value='/login' />"><spring:message code="signin"/></a></p>
        </security:authorize>
    </div>
    <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
        <div class="container">
            <tiles:insertAttribute name = "main-content" />
            <footer class="pt-4 my-md-5 pt-md-5 border-top">
                <div class="row">
                    <div class="col-6 col-md">
                        <h5><spring:message code="features"/></h5>
                        <ul class="list-unstyled text-small">
                            <li><a class="text-muted" href="#">Cool stuff</a></li>
                        </ul>
                    </div>
                    <div class="col-6 col-md">
                        <h5><spring:message code="resources"/></h5>
                        <ul class="list-unstyled text-small">
                            <li><a class="text-muted" href="#">Resource</a></li>
                        </ul>
                    </div>
                    <div class="col-6 col-md">
                        <h5><spring:message code="about"/></h5>
                        <ul class="list-unstyled text-small">
                            <li><a class="text-muted" href="#">Team</a></li>
                            <li><a class="text-muted" href="#">Locations</a></li>
                            <li><a class="text-muted" href="#">Privacy</a></li>
                            <li><a class="text-muted" href="#">Terms</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-12 col-md">
                    <img class="mb-2" src="<spring:url value='/images/haltere.png' />" alt="Logo" width="24" height="24">
                    <small class="d-block mb-3 text-muted">&copy; 2017-2018</small>
                </div>
            </footer>
        </div>
    </div>
</body>
</html>