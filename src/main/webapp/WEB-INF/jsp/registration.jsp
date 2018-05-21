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
        <form:button class="btn btn-lg btn-primary btn-block" type="submit">Save user</form:button>
        <form:button class="btn btn-lg btn-primary btn-block" type="reset">Reset</form:button>
    </form:form>