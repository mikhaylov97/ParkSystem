<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit profile</title>
</head>
<body>
<div class="container">
    <div class="row">
        <h5><a href="/login">Go back</a></h5>
        <h3>Hello ${pageContext.request.userPrincipal.name}, there you can change your settings!</h3>
    </div>
    <form action="/edit" method="post">
        <div class="row">
            Enter new name:
            <input type="text" name="name" id="name" placeholder="Name">
        </div>
        <div class="row">
            Enter new surname:
            <input type="text" name="surname" id="surname" placeholder="Surname">
        </div>
        <div class="row">
            Enter new password:
            <input type="password" name="password" id="password" placeholder="Password">
        </div>
        <div class="row">
            <button id="submit">Отправить</button>
        </div>
    </form>
</div>
</body>
</html>
