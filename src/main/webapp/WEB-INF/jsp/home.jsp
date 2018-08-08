<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<spring:url value="" var="localeFr">
    <spring:param name="locale" value="fr" />
</spring:url>

<spring:url value="" var="localeEn">
    <spring:param name="locale" value="en" />
</spring:url>

    <h1 class="display-4"><spring:message code="homeMessage"/></h1>
<br>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img class="first-slide" src="<spring:url value='/images/blessure.jpg' />" alt="First slide">
            <div class="container">
                <div class="carousel-caption text-left">
                    <h1 class="text-white bg-dark"><spring:message code="riskOfInjury"/> </h1>

                    <p><a class="btn btn-lg btn-primary" href="http://localhost:8082/equipementsSportif/article?codeBarre=4" role="button"><spring:message code="buyShoes" /> </a></p>
                </div>
            </div>
        </div>
        <div class="carousel-item">
            <img class="second-slide" src="<spring:url value='/images/ocean.jpg' />" alt="Second slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1 class="text-dark"><spring:message code="promotion"/> </h1>
                    <p class=""><spring:message code="2SameArticles"/> </p>
                    <p class=""><spring:message code="3SameArticles"/></p>
                    <p class=""><spring:message code="4SameArticles"/></p>
                    <p class=""><spring:message code="5SameArticles"/></p>
                    <p class="text-white bg-dark"><spring:message code="5AndMoreSameArticles"/></p>
                </div>
            </div>
        </div>
        <div class="carousel-item">
            <img class="third-slide" src="<spring:url value='/images/ringBoxe.jpg' />" alt="Third slide">
            <div class="container">
                <div class="carousel-caption text-right">
                    <p class="text-white bg-dark"><spring:message code="citation"/> </p>
                    <p><a class="btn btn-lg btn-primary" href="http://localhost:8082/equipementsSportif/articles?id=6" role="button"><spring:message code="startNow"/> </a></p>
                </div>
            </div>
        </div>
    </div>
    <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<h2 class="display-4"><spring:message code="motivation"/></h2>
<br>
<div class="first-slide embed-responsive embed-responsive-16by9">
    <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/mcwpL52M7To?rel=0" allowfullscreen></iframe>
</div>

<p class="lead lg-auto-2"><a href="${localeFr}">FR</a> | <a href="${localeEn}">EN</a></p>