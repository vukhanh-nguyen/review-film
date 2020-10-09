<%--
  Created by IntelliJ IDEA.
  User: VuKhanh
  Date: 10/8/2020
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="APIRegister" value="/api-register"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng ký - Review Film</title>
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
            <h3 class="h3-heading-primary my-5">Đăng ký Mới</h3>
        </div>
        <!-- Login Form -->
        <form id = "registerForm" action="#" method="post">
            <input class="input" type="text" id="username" class="m-2" name="username" placeholder="Tên Đăng Nhập">
            <input class="input" type="password" id="password" class="m-2" name="password" placeholder="Mật Khẩu">
            <input class="input" type="password" id="passwordAgain" class="m-2" name="passwordAgain" placeholder="Nhập Lại Mật Khẩu">
            <input class="input" type="text" id="name" class="m-2" name="fullname" placeholder="Tên đầy đủ">
            <input class="input" type="email" id="email" class="m-2" name="email" placeholder="Email">
            <input class="input" type="text" id="phone" class="m-2" name="phone" placeholder="Số điện thoại">
            <input class="input" type="date" id="dateOfBirth" class="m-2" name="dateOfBirth" placeholder="Ngày sinh">
            <div id="formFooter">
            </div>
            <a id="registerNew" class="mb-5 cbutton cbutton--blue cbutton--big">Đăng ký</a>
            <h2 class="h3-heading-secondary ">BẠN ĐÃ CÓ TÀI KHOẢN ?</h2>
            <a href="./login.html" class="cbutton cbutton--blue cbutton--big">Đăng Nhập</a>
        </form>
    </div>
</div>
<script>
    $('#registerNew').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#registerForm').serializeArray();
        $.each(formData, function (i, v) {
            if (v.name !== "passwordAgain"){
                data[""+v.name+""] = v.value;
            }
        });
        register(data);
    });
    function register(data) {
        $.ajax({
            url: location.origin + "/api-register",
            //url: ${APIRegister},
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                console.log(result);
            },
            error: function (error) {
                window.location.href = '<c:url value="/trang-chu"/>';
                console.log(error);
            }
        });
    }
</script>
</body>
</html>
