<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" href="<spring:url value='/css/style.css' />" rel="Stylesheet">
</head>
<body>
<div>
    <header>
        <p id="langue">Choisissez votre langue  <a href="" ><img src='<spring:url value="/images/locale_en.ico"/>'> </a>
            <a href=""><img src='<spring:url value="/images/locale_fr.ico"/>'> </a></p>
    </header>
    <div>
        <tiles:insertAttribute name = "main-content" />
    </div>
</div>
</body>
</html>