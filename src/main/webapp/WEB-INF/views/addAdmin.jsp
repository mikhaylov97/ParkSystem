<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add admin</title>
</head>
<body>
<div class="container">
    <div class="row">
        <h5><a href="/login">Go back</a></h5>
        <h3>${pageContext.request.userPrincipal.name}, there you can add new Admin!</h3>
    </div>
    <form action="/admin/addAdmin" method="post">
        <div class="row">
            Enter email:
            <input type="text" name="email" id="email" placeholder="Email">
        </div>
        <div class="row">
            Enter name:
            <input type="text" name="name" id="name" placeholder="Name">
        </div>
        <div class="row">
            Enter surname:
            <input type="text" name="surname" id="surname" placeholder="Surname">
        </div>
        <div class="row">
            Enter password:
            <input type="password" name="password" id="password" placeholder="Password">
        </div>
        <div class="row">
            <button id="submit">Отправить</button>
        </div>
    </form>
</div>
</body>
</html>
