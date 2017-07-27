<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Declined tasks</title>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
    <div class="row">
        <h5><a href="/login"><spring:message code="go.back"/></a></h5>
        <h3>${pageContext.request.userPrincipal.name}, <spring:message code="you.can.see.declines"/>!</h3>
    </div>
    <c:forEach var="task" items="${declines}">
    <div class="row">
        <form action="/user/tasks/done/${task.id}" method="post">
            <h3>${task.purpose}</h3>
            <h4><spring:message code="owner"/> - ${task.owner.email}  ${task.owner.name} ${task.owner.surname}</h4>
            <h5><spring:message code="description"/>: ${task.description}</h5>
            <h5><spring:message code="amount"/>: ${task.amountOfPlants}</h5>
            <h5><spring:message code="plant"/>: ${task.plant.name}</h5>
            <h6><spring:message code="plant.description"/>: ${task.plant.description}</h6>
            <button type="submit"><spring:message code="done"/></button>
        </form>
    </div>
    </c:forEach>
</body>
</html>
