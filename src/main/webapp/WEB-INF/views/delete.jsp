<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Admin</title>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
    <div class="row">
        <h5><a href="/login"><spring:message code="go.back"/></a></h5>
        <h3>${pageContext.request.userPrincipal.name}, <spring:message code="you.can.delete.admins"/>!</h3>
    </div>
    <c:forEach var="admin" items="${admins}">
        <c:if test="${pageContext.request.userPrincipal.name ne admin.email}">
        <div class="row">
            <form action="/admin/delete/${admin.id}" method="post">
                <h3>Email: ${admin.email}</h3>
                <h5><spring:message code="name"/>: ${admin.name}</h5>
                <h5><spring:message code="surname"/>: ${admin.surname}</h5>
                <button type="submit"><spring:message code="delete"/></button>
            </form>
        </div>
        </c:if>
    </c:forEach>
</div>
</body>
</html>
