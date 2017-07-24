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
        <h5><a href="/login">Go back</a></h5>
        <h3>${pageContext.request.userPrincipal.name}, there you can add new Task!</h3>
    </div>
    <form action="/admin/addTask" method="post">
        <div class="row">
            Enter purpose:
            <input type="text" name="purpose" id="purpose" placeholder="Purpose">
        </div>
        <div class="row">
            Enter description of the task:
            <textarea name="description" cols="30" rows="10" required></textarea>
        </div>
        <div class="row">
            Enter amount of plants:
            <input type="text" name="number" id="number" placeholder="Amount">
        </div>
        <div class="row">
            Choose plant:
            <select name="plantId" required>
                <c:forEach var="plant" items="${plants}">
                <option value="${plant.id}">${plant.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="row">
            Choose worker:
            <select name="workerId" required>
                <c:forEach var="worker" items="${workers}">
                    <option value="${worker.id}">${worker.email}</option>
                </c:forEach>
            </select>
        </div>
        <div class="row">
            <button id="submit">Добавить</button>
        </div>
    </form>
</div>
</body>
</html>
