<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Tasks</title>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
    <div class="row">
        <h5><a href="/login">Go back</a></h5>
        <h3>${pageContext.request.userPrincipal.name}, there you can see your new tasks!</h3>
    </div>
    <c:forEach var="task" items="${tasks}">
        <div class="row">
            <form action="/user/tasks/done/${task.id}" method="post">
                <h3>${task.purpose}</h3>
                <h4>Owner - ${task.owner.email}  ${task.owner.name} ${task.owner.surname}</h4>
                <h5>Description: ${task.description}</h5>
                <h5>Amount: ${task.amountOfPlants}</h5>
                <h5>Plant: ${task.plant.name}</h5>
                <h6>Plant description: ${task.plant.description}</h6>
                <button type="submit">Done</button>
            </form>
        </div>
    </c:forEach>
</div>
</body>
</html>
