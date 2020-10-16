<%--
  Created by IntelliJ IDEA.
  User: VuKhanh
  Date: 10/16/2020
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Change Password - Review Film</title>
    <link href="<c:url value='/css/style.css'/>" rel="stylesheet">
    <link rel="shortcut icon" href="<c:url value="/images/logo.ico"/>"/>
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
        <c:if test="${message == 'success'}">
            <div class="alert alert-success alert-custom">
                Success
            </div>
        </c:if>
        <c:if test="${message == 'fail'}">
            <div class="alert alert-danger alert-custom">
                Change password fail. Please try again
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
            <h2 class="h3-heading-primary my-5">Change password</h2>
        </div>

        <!-- Login Form -->
        <form id="changePassword">
            <input class="input" type="password" id="oldpassword" class="m-2" name="oldpassword"
                   placeholder="Old Password">
            <input class="input" type="password" id="password" class="m-2" name="newpassword"
                   placeholder="New Password">
            <input class="input" type="password" id="password-again" class="m-2" name="againpassword"
                   placeholder="New Password Again">
            <div id="formFooter">
            </div>
            <a id="change" class="cbutton cbutton--blue cbutton--big">Change</a>
            <a href="#" class="cbutton cbutton--blue cbutton--medium">Reset</a>
        </form>
    </div>
</div>
<script type="text/javascript">


    $('#change').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#changePassword').serializeArray();

        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        });

        changePassword(data);

    });

    function changePassword(data) {
        $.ajax({
            url: '<c:url value="/api-user"/>',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = '<c:url value="/change-password"/>' + "?message=success";
            },
            error: function (error) {
                window.location.href = '<c:url value="/change-password"/>' + "?message=fail";
            }
        });
    }

</script>
</body>
</html>
