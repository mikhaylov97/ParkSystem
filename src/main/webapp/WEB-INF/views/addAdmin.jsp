<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add admin</title>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
    <div class="row">
        <h5><a href="/login"><spring:message code="go.back"/></a></h5>
        <h3>${pageContext.request.userPrincipal.name}, <spring:message code="you.can.add.new.admin"/>!</h3>
    </div>
    <form action="/admin/addAdmin" method="post">
        <div class="row">
            <spring:message code="Enter"/> email:
            <input type="text" name="email" id="email" placeholder="Email">
        </div>
        <div class="row">
            <spring:message code="enter.name"/>:
            <input type="text" name="name" id="name" placeholder="<spring:message code="name"/>">
        </div>
        <div class="row">
            <spring:message code="enter.surname"/>:
            <input type="text" name="surname" id="surname" placeholder="<spring:message code="surname"/>">
        </div>
        <div class="row">
            <spring:message code="enter.password"/>:
            <input type="password" name="password" id="password" placeholder="<spring:message code="password"/>">
        </div>
        <div class="row">
            <button id="submit"><spring:message code="send"/></button>
        </div>
    </form>
</div>
</body>
</html>
