<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit profile</title>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
    <div class="row">
        <h5><a href="/login"><spring:message code="go.back"/></a></h5>
        <h3>${pageContext.request.userPrincipal.name}, <spring:message code="you.can.change.setings"/>!</h3>
    </div>
    <form method="post">
        <div class="row">
            <spring:message code="enter.new.name"/>:
            <input type="text" name="name" id="name" placeholder="<spring:message code='name'/>">
        </div>
        <div class="row">
            <spring:message code="enter.new.surname"/>:
            <input type="text" name="surname" id="surname" placeholder="<spring:message code='surname'/>">
        </div>
        <div class="row">
            <spring:message code="enter.new.password"/>:
            <input type="password" name="password" id="password" placeholder="<spring:message code='password'/>">
        </div>
        <sec:authorize access="hasRole('ROLE_USER')">
            <div class="row">
                <button formaction="/user/edit"><spring:message code="send"/></button>
            </div>
        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER_ADMIN')">
            <div class="row">
                <button formaction="/admin/edit"><spring:message code="send"/></button>
            </div>
        </sec:authorize>
    </form>
</div>
</body>
</html>
