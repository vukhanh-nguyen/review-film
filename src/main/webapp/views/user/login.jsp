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
    <title>Sign in - Review Film</title>
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
    <c:if test="${not empty message}">
        <c:if test="${message == 'fail'}">
            <div class="alert alert-danger alert-custom">
                FAIL
            </div>
        </c:if>
        <c:if test="${message == 'success'}">
            <div class="alert alert-success alert-custom">
                Success
            </div>
        </c:if>
    </c:if>
    <div id="formContent">
        <!-- Logo -->
        <div class="logo-wrap">
            <a href="<c:url value="/home"/>">
                <img class="logo" src="<c:url value="/images/logo.png"/>" alt="">
            </a>
        </div>
        <!-- Tabs Titles -->
        <!-- Icon -->
        <div class="title">
            <h2 class="h3-heading-primary my-5">Login</h2>
        </div>
        <!-- Login Form -->
        <form action="<c:url value="/login"/>" id="formLogin" method="POST">
            <input class="input" type="text" id="username" class="m-2" name="username" placeholder="Username">
            <input class="input" type="password" id="password" class="m-2" name="password" placeholder="Password">
            <div id="formFooter">
            </div>
            <input type="submit" class="mb-5 cbutton cbutton--blue cbutton--big" value="LOGIN">
            <h2 class="h3-heading-secondary">You don't have an account ?</h2>
            <a href="<c:url value="/register"/>" class="cbutton cbutton--blue cbutton--big">Register</a>
        </form>
    </div>
</div>
</body>
</html>
