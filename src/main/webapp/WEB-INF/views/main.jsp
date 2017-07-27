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
<%@include file="header.jsp"%>
<h2><spring:message code="welcome"/> : ${pageContext.request.userPrincipal.name}
    | <a href="<c:url value="/logout" />" > <spring:message code="logout"/> </a></h2>
<div class="container">
        <sec:authorize access="hasRole('ROLE_USER')">
            <div class="row">
                <spring:message code="tasks"/> : <a href="/user/edit"><spring:message code="edit.profile"/> </a>
            </div>
            <div class="row">
                +${newTasks} <spring:message code="new.tasks"/> : <a href="/user/tasks"><spring:message code="see.all"/> </a>
            </div>
            <div class="row">
                +${newDeclines} <spring:message code="declines"/> : <a href="/user/tasks/declined"><spring:message code="more.info"/> </a>
            </div>
        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <div class="row">
                <sec:authorize access="hasRole('ROLE_SUPER_ADMIN')">
                    <spring:message code="admins"/> : <a href="/admin/addAdmin"><spring:message code="add.new"/> </a> <a href="/admin/delete"><spring:message code="delete"/> </a></sec:authorize> <a href="/admin/edit"><spring:message code="edit.profile"/> </a>
            </div>
            <div class="row">
                <spring:message code="tasks"/> : <a href="/admin/addTask"><spring:message code="add.new"/> </a> <a href="/admin/accepting"><spring:message code="accepting.done"/> </a>
            </div>
        </sec:authorize>
</div>
</body>
</html>
