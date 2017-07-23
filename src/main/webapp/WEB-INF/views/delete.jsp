<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Admin</title>
</head>
<body>
<div class="container">
    <div class="row">
        <h5><a href="/login">Go back</a></h5>
        <h3>${pageContext.request.userPrincipal.name}, there you can delete Admins!</h3>
    </div>
    <c:forEach var="admin" items="${admins}">
        <c:if test="${pageContext.request.userPrincipal.name ne admin.email}">
        <div class="row">
            <form action="/admin/delete/${admin.id}" method="post">
                <h3>Email: ${admin.email}</h3>
                <h5>Name: ${admin.name}</h5>
                <h5>Surname: ${admin.surname}</h5>
                <button type="submit">Delete</button>
            </form>
        </div>
        </c:if>
    </c:forEach>
</div>
</body>
</html>
