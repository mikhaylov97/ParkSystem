<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Bootstrap -->
    <link href="/resources/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/resources/css/header_style.css">
    <script src="/resources/js/jquery-3.1.1.min.js"></script>
    <script src="/resources/js/changeLang.js"></script>
</head>
<body>
    <div class="navbar">
        <div class="container active-navbar">
            <div class="row">
                <div class="col-lg-2">
                </div>
                <div class="col-lg-5">
                </div>
                <div class="col-lg-4">
                    <a href="/logout"> <spring:message code="logout"/> </a>
                </div>
                <div class="col-lg-1">
                    <a href="" id="englishRef">English</a>|<a href="" id="russianRef">Русский</a>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>