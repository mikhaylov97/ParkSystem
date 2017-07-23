<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Arty
  Date: 20.07.2017
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<html>
<head>
    <title>Security Page</title>
</head>
<body>
<%--<%@include file="header.jsp"%>--%>
<h2>Welcome : ${pageContext.request.userPrincipal.name}
    | <a href="<c:url value="/logout" />" > Logout</a></h2>
<div class="container">
        <sec:authorize access="hasRole('ROLE_USER')">
            <div class="row">
                Tasks: <a href="/edit">Edit profile</a>
            </div>
            <div class="row">
                +${newTasks} new: <a href="">See all</a>
            </div>
            <div class="row">
                +${declined} declines: <a href="">More info</a>
            </div>
        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <div class="row">
                Admin: <a href="/admin/addAdmin">Add new</a> <a href="/admin/delete">Delete</a> <a href="/edit">Edit profile</a>
            </div>
            <div class="row">
                Tasks: <a href="">Add new</a> <a href="/admin/accepting">Accept done</a>
            </div>
        </sec:authorize>
</div>
</body>
</html>
