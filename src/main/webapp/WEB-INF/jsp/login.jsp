<%@ include file="include/importTags.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h1 class="display-4"><spring:message code="signin"/></h1>
<security:authorize access="!isAuthenticated()">
    <form:form id="formLogin"
               method="POST"
               action="${contextPath}/login"
               modelAttribute="userEntity">
            <form:input type="text" path="username" class="form-control" placeholder="Username"
                        autofocus="true"></form:input>
            <form:errors path="username" cssClass="has-error"></form:errors>
        </br>
            <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
            <form:errors path="password" cssClass="has-error"></form:errors>
        </br>
        <form:button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="login"/></form:button>
        <form:button class="btn btn-lg btn-primary btn-block" type="reset"><spring:message code="reset"/></form:button>
    </form:form>
</security:authorize>
<security:authorize access="isAuthenticated()">
    <p class="lead"><spring:message code="alreadyAuthenticated"/> </p>
    <p class="lead"><a class="badge badge-info"href='<spring:url value="/logout"/>'><spring:message code="logout"/></a></p>
</security:authorize>
<p class="lead"><a class="badge badge-info" href='<spring:url value="/"/>'><spring:message code="backToHome"/></a></p>