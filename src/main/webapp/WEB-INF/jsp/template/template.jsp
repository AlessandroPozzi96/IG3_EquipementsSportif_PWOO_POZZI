<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" href="<spring:url value='/css/bootstrap.min.css' />" rel="Stylesheet">
    <link type="text/css" href="<spring:url value='/css/bootstrap-grid.min.css' />" rel="Stylesheet">
    <script src="<spring:url value='/js/bootstrap.bundle.min.js' />"></script>
    <script src="<spring:url value='/js/bootstrap.min.js' />"></script>
</head>
<body>
<div>
    <div class="container">
        <header class="dropdown-header">
            <p class="panel-info">Choisissez votre langue  <a class="btn-link" href="" ><img src='<spring:url value="/images/locale_en.ico"/>'> </a>
                <a class="btn-link" href=""><img src='<spring:url value="/images/locale_fr.ico"/>'> </a></p>
        </header>
        <tiles:insertAttribute name = "main-content" />
    </div>
</div>
</body>
</html>