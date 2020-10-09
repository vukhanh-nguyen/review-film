<%--
  Created by IntelliJ IDEA.
  User: VuKhanh
  Date: 10/9/2020
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="APIRegister" value="/api-register"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập - Review Film</title>
    <link href="<c:url value='/css/style.css'/>" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous">
    </script>
</head>
<body>
<div class="wrapper">
    <div id="formContent">
        <!-- Logo -->
        <div class="logo-wrap">
            <img src="<c:url value="/images/logo.png"/>" alt="">
        </div>
        <!-- Tabs Titles -->
        <!-- Icon -->
        <div class="title">
            <h2 class="h3-heading-primary my-5">Đăng nhập</h2>
        </div>
        <!-- Login Form -->
        <form action="<c:url value=""/>" id="formLogin" method="POST">
            <input class="input" type="text" id="username" class="m-2" name="username" placeholder="Tên Đăng Nhập">
            <input class="input" type="password" id="password" class="m-2" name="password" placeholder="Mật Khẩu">
            <div id="formFooter">
            </div>
            <a type="submit" href="#" class="mb-5 cbutton cbutton--blue cbutton--big">Đăng nhập</a>
            <h2 class="h3-heading-secondary">bạn chưa có tài khoản ?</h2>
            <a href="./register.html" class="cbutton cbutton--blue cbutton--big">Đăng ký</a>
        </form>
    </div>
</div>
</body>
</html>
