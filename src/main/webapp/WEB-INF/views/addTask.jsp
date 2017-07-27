<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new task</title>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
    <div class="row">
        <h5><a href="/login"><spring:message code="go.back"/></a></h5>
        <h3>${pageContext.request.userPrincipal.name}, <spring:message code="you.can.add.new.task"/>!</h3>
    </div>
    <form action="/admin/addTask" method="post">
        <div class="row">
            <spring:message code="enter.purpose"/>:
            <input type="text" name="purpose" id="purpose" placeholder="<spring:message code='purpose'/>">
        </div>
        <div class="row">
            <spring:message code="enter.description"/>:
            <textarea name="description" cols="30" rows="10" required></textarea>
        </div>
        <div class="row">
            <spring:message code="enter.amount"/>:
            <input type="text" name="number" id="number" placeholder="<spring:message code="amount"/>">
        </div>
        <div class="row">
            <spring:message code="choose.plant"/>:
            <select name="plantId" required>
                <c:forEach var="plant" items="${plants}">
                <option value="${plant.id}">${plant.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="row">
            <spring:message code="choose.forester"/>:
            <select name="workerId" required>
                <c:forEach var="worker" items="${workers}">
                    <option value="${worker.id}">${worker.email}</option>
                </c:forEach>
            </select>
        </div>
        <div class="row">
            <button id="submit"><spring:message code="add"/></button>
        </div>
    </form>
</div>
</body>
</html>
