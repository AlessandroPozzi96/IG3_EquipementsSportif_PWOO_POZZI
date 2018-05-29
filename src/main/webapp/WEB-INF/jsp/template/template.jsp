<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>${title}</title>

    <link rel="icon" href="<spring:url value='/images/haltere.png' />">
    <link type="text/css" href="<spring:url value='/css/bootstrap.min.css' />" rel="Stylesheet">
    <link type="text/css" href="<spring:url value='/css/style.css' />" rel="Stylesheet">
    <script src="<spring:url value='/js/bootstrap.min.js' />" ></script>
    <script src="<spring:url value='/js/jQuery.min.js' />" ></script>
    <script src="<spring:url value='/js/holder.min.js' />" ></script>

</head>
<body>
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
        <h5 class="my-0 mr-md-auto">EquipementsSportifs</h5>
        <security:authorize access="hasRole('USER')">
        <h5 class="my-3 mr-md-auto font-weight-normal"><security:authentication property="principal.username" /></h5>
        </security:authorize>
        <security:authorize access="hasRole('ADMIN')">
            <h5 class="my-3 mr-md-auto font-weight-normal">Salutations, administrateur <security:authentication property="principal.username" /> !</h5>
        </security:authorize>
        <nav class="my-2 my-md-0 mr-md-3">
            <a class="p-2 text-dark" href="<spring:url value='/' />">Home</a>
            <a class="p-2 text-dark" href="<spring:url value='/catalogue' />">Catalogue</a>
            <a class="p-2 text-dark" href="<spring:url value='/compte' />">Compte</a>
            <a class="p-2 text-dark" href="<spring:url value='/contact' />">Contact</a>
            <security:authorize access="isAuthenticated()">
                <a class="p-2 text-dark" href="<spring:url value='/logout' />">Log out</a>
            </security:authorize>
        </nav>
        <p class="lead"> ${panier.nbArticlesPanier} article(s) dans votre <a class="btn btn-outline-primary" href="<spring:url value='/panier' />">panier</a></p>
        <security:authorize access="isAnonymous()">
            <p class="lead"><a class="btn btn-outline-primary" href="<spring:url value='/registration' />">Sign up</a><a class="btn btn-outline-primary" href="<spring:url value='/login' />">Sign in</a></p>
        </security:authorize>
    </div>
    <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
        <div class="container">
            <tiles:insertAttribute name = "main-content" />
            <footer class="pt-4 my-md-5 pt-md-5 border-top">
                <div class="row">
                    <div class="col-12 col-md">
                        <img class="mb-2" src="<spring:url value='/images/haltere.png' />" alt="" width="24" height="24">
                        <small class="d-block mb-3 text-muted">&copy; 2017-2018</small>
                    </div>
                    <div class="col-6 col-md">
                        <h5>Features</h5>
                        <ul class="list-unstyled text-small">
                            <li><a class="text-muted" href="#">Cool stuff</a></li>
                        </ul>
                    </div>
                    <div class="col-6 col-md">
                        <h5>Resources</h5>
                        <ul class="list-unstyled text-small">
                            <li><a class="text-muted" href="#">Resource</a></li>
                        </ul>
                    </div>
                    <div class="col-6 col-md">
                        <h5>About</h5>
                        <ul class="list-unstyled text-small">
                            <li><a class="text-muted" href="#">Team</a></li>
                            <li><a class="text-muted" href="#">Locations</a></li>
                            <li><a class="text-muted" href="#">Privacy</a></li>
                            <li><a class="text-muted" href="#">Terms</a></li>
                        </ul>
                    </div>
                </div>
            </footer>
        </div>
    </div>
    <script>
        Holder.addTheme('thumb', {
            bg: '#55595c',
            fg: '#eceeef',
            text: 'Thumbnail'
        });
    </script>
</body>
</html>