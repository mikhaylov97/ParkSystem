<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Home page</title>
    <link rel="stylesheet" href="/resources/css/title_style.css">
    <script src="/resources/js/jquery-3.1.1.min.js"></script>
    <script src="/resources/js/login-check.js"></script>
    <script src="/resources/js/auth-check.js"></script>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
    <div class="row">
        <div class="col-lg-6">Slider</div>
        <div class="col-lg-4">
            <div class="row login-area auth-block">
                <form id="auth-form" class="login-form" action="/login" method="post">
                    <div class="fields">
                        <div class="field">
                            <input id="auth-email" class="form-control" name="email" type="text" placeholder="Email" required autofocus>
                        </div>
                        <div class="field">
                            <input id="auth-password" class="form-control" name="password" type="password" placeholder="<spring:message code='password'/>" required>
                        </div>
                    </div>
                    <div class="submit">
                        <button id="submitAuthBtn" class="btn btn-primary" type="button">
                            <spring:message code="Enter.login"/> </button>
                    </div>
                    <div class="error-block-auth"></div>
                </form>
            </div>
            <div class="row login-area registration-block">
                <form id="login-form" class="login-form" action="/registration" method="post">
                    <div class="logo">
                        <h3><b><spring:message code="first.visit"/></b></h3>
                        <h5><spring:message code="momental.sign.up"/> </h5>
                    </div>
                    <div class="fields">
                        <div class="field">
                            <input id="email" class="form-control" name="email" type="text" placeholder="Email" required autofocus>
                        </div>
                        <div class="field">
                            <input id="name" class="form-control" name="name" type="text" placeholder="<spring:message code='name'/>" required>
                        </div>
                        <div class="field">
                            <input id="surname" class="form-control" name="surname" type="text" placeholder="<spring:message code='surname'/>" required>
                        </div>
                        <div class="field">
                            <input id="password" class="form-control" name="password" type="password" placeholder="<spring:message code='password'/>" required>
                        </div>
                    </div>
                    <div class="submit">
                        <button id="submitBtn" class="btn btn-primary" type="button">
                            <spring:message code="sign.up"/> </button>
                    </div>
                    <div class="error-block"></div>
                    <div class="form-footer">
                        <h5><spring:message code="signing.up.conditions"/>
                            <a href="#"><b><spring:message code="conditions"/></b></a> <spring:message code="and"/> <a href="#"><b><spring:message code="policy"/> </b></a></h5>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
