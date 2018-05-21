<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<h1 class="header-panel">Enregistrez-vous pour pouvoir commander !</h1>
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
    <form:button>Save user</form:button>
        <form:button type="reset">Reset</form:button>
    </form:form>