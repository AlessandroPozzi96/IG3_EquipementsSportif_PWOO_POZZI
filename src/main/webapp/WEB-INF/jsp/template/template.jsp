<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" href="<spring:url value='/images/haltere.jpg' />">
    <link type="text/css" href="<spring:url value='/css/bootstrap.min.css' />" rel="Stylesheet">
    <link type="text/css" href="<spring:url value='/css/bootstrap-grid.min.css' />" rel="Stylesheet">
    <link type="text/css" href="<spring:url value='/css/style.css' />" rel="Stylesheet">
    <script type="javascript" src="<spring:url value='/js/bootstrap.bundle.min.js' />" rel="script"></script>
    <script type="javascript" src="<spring:url value='/js/bootstrap.min.js' />" rel="script"></script>
    <script type="javascript" src="<spring:url value='/js/jQuery.min.js' />" rel="script"></script>
    <script type="javascript" src="<spring:url value='/js/popper.min.js' />" rel="script"></script>

</head>
<body>
<div>
        <header class="dropdown-header">
            <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
                <a class="navbar-brand" href="<spring:url value='/'/>">Accueil</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Link</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="#">Disabled</a>
                        </li>
                    </ul>
                    <form class="form-inline mt-2 mt-md-0">
                        <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </div>
            </nav>
            <p id="langue">Choisissez votre langue  <a class="btn-link" href="" ><img src='<spring:url value="/images/locale_en.ico"/>'> </a>
                <a class="btn-link" href=""><img src='<spring:url value="/images/locale_fr.ico"/>'> </a></p>
        </header>
        <main role="main">
            <div class="container">
                <tiles:insertAttribute name = "main-content" />
            </div>
        </main>
        <!-- FOOTER -->
        <footer class="container">
            <p class="float-right"><a href="#">Back to top</a></p>
            <p>&copy; 2017-2018 EquipementsSportif Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
        </footer>
</div>
</body>
</html>