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
        <h5><a href="/login">Go back</a></h5>
        <h3>${pageContext.request.userPrincipal.name}, there you can accept or decline tasks!</h3>
    </div>
    <c:forEach var="task" items="${tasks}">
        <div class="row">
            <form id="acceptingForm" method="post">
                <h3>Email: ${task.forester.email}</h3>
                <h5>Name: ${task.forester.name}</h5>
                <h5>Surname: ${task.forester.surname}</h5>
                <h5>Task purpose: ${task.purpose}</h5>
                <h5>Plant: ${task.plant.name}</h5>
                <button type="submit" formaction="/admin/accepting/accept/${task.id}">Accept</button>
                <button type="submit" formaction="/admin/accepting/decline/${task.id}">Decline</button>
            </form>
        </div>
    </c:forEach>
</div>
</body>
</html>
