<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accepting tasks</title>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
    <div class="row">
        <h5><a href="/login"><spring:message code="go.back"/></a></h5>
        <h3>${pageContext.request.userPrincipal.name}, <spring:message code="you.can.accept.or.decline"/>!</h3>
    </div>
    <c:forEach var="task" items="${tasks}">
        <div class="row">
            <form id="acceptingForm" method="post">
                <h3>Email: ${task.forester.email}</h3>
                <h5><spring:message code="name"/>: ${task.forester.name}</h5>
                <h5><spring:message code="surname"/>: ${task.forester.surname}</h5>
                <h5><spring:message code="purpose"/>: ${task.purpose}</h5>
                <h5><spring:message code="plant"/>: ${task.plant.name}</h5>
                <button type="submit" formaction="/admin/accepting/accept/${task.id}"><spring:message code="accept"/></button>
                <button type="submit" formaction="/admin/accepting/decline/${task.id}"><spring:message code="decline"/></button>
            </form>
        </div>
    </c:forEach>
</div>
</body>
</html>
