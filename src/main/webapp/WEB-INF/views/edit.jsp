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
        <h5><a href="/login">Go back</a></h5>
        <h3>Hello ${pageContext.request.userPrincipal.name}, there you can change your settings!</h3>
    </div>
    <form method="post">
        <div class="row">
            Enter new name:
            <input type="text" name="name" id="name" placeholder="Name">
        </div>
        <div class="row">
            Enter new surname:
            <input type="text" name="surname" id="surname" placeholder="Surname">
        </div>
        <div class="row">
            Enter new password:
            <input type="password" name="password" id="password" placeholder="Password">
        </div>
        <sec:authorize access="hasRole('ROLE_USER')">
            <div class="row">
                <button formaction="/user/edit">Отправить</button>
            </div>
        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER_ADMIN')">
            <div class="row">
                <button formaction="/admin/edit">Отправить</button>
            </div>
        </sec:authorize>
    </form>
</div>
</body>
</html>
