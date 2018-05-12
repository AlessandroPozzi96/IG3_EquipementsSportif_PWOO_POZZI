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
    <div>
        <tiles:insertAttribute name = "main-content" />
    </div>
</div>
</body>
</html>