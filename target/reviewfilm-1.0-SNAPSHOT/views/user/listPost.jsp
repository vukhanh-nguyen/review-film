<%--
  Created by IntelliJ IDEA.
  User: VuKhanh
  Date: 10/12/2020
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List Posts - Review Film</title>
    <link href="<c:url value='/css/style.css'/>" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous">
    </script>
</head>
<body>
<!-- CSS heading wrap ở file home.scss -->
<div class="heading-wrap">
    <div class="row">
        <div class="col-8">
            <a href="<c:url value="/home"/>">
                <img class="logo" src="<c:url value="/images/logo.png"/>" alt="">
            </a>
        </div>
        <div class="col-4">
            <c:if test="${sessionScope.LOGIN != null}">
                <nav class="navbar navbar-expand-sm profile-nav">
                    <div class="collapse navbar-collapse" id="navbar-list-4">
                        <ul class="navbar-nav">
                            <li class="nav-item dropdown">
                                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                    <a class="dropdown-item" href="#">Profile</a>
                                    <a class="dropdown-item" href="#">Your posts</a>
                                    <a class="dropdown-item" href="<c:url value="/logout"/>">Log Out</a>
                                </div>
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <img src="https://www.cccd.edu/_assets/images/Departments/NoProfile.png" width="40"
                                         height="40" class="rounded-circle">
                                </a>
                            </li>
                        </ul>
                    </div>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-list-4"
                            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                </nav>
            </c:if>
            <c:if test="${sessionScope.LOGIN == null}">
                <div class="navigation">
                    <a href="<c:url value='/login'/>" class="cbutton cbutton--blue cbutton--medium">Login</a>
                    <a href="<c:url value='/register'/>" class="cbutton cbutton--blue cbutton--small">Register</a>
                </div>
            </c:if>
        </div>
    </div>
</div>
<div class="listpost-wrap">
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
    <div class="row mb-5">
        <a href="index.html" class="cbutton cbutton--blue cbutton--big">Danh sách bài viết</a>
    </div>
    <p class="heading-primary">Danh sách hoạt động</p>
    <div class="information">
        <div class="row">
            <div class="col-12">
                <div class="tabs">
                    <input id="tab-1" type="radio" name="radio-set" class="tab-selector-1" checked="checked" />
                    <label for="tab-1" class="tab-label-1">Bài viết cá nhân</label>

                    <input id="tab-2" type="radio" name="radio-set" class="tab-selector-2" />
                    <label for="tab-2" class="tab-label-2">Bài viết đã tương tác</label>
                    <div class="clear-shadow"></div>
                    <div class="content">
                        <div class="content-1">
                            <table class="table table-bordered u-center-text">
                                <thead>
                                <tr class="d-flex table-secondary">
                                    <th class="col-1" scope="col">ID</th>
                                    <th class="col-7" scope="col">Tiêu đề</th>
                                    <th class="col-2" scope="col">Trạng thái</th>
                                    <th class="col-2" scope="col"> Chỉnh sửa
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr class="d-flex">
                                    <th class="col-1" scope="row">1</th>
                                    <td class="col-7">Mark</td>
                                    <td class="col-2">Otto</td>
                                    <td class="col-2">
                                        <a href="index.html" class="cbutton cbutton--blue cbutton--small">Chỉnh sửa</a>
                                    </td>
                                </tr>
                                <tr class="d-flex">
                                    <th class="col-1" scope="row">2</th>
                                    <td class="col-7">Jacob</td>
                                    <td class="col-2">Thornton</td>
                                    <td class="col-2">
                                        <a href="index.html" class="cbutton cbutton--blue cbutton--small">Chỉnh sửa</a>
                                    </td>
                                </tr>
                                <tr class="d-flex">
                                    <th class="col-1" scope="row">3</th>
                                    <td class="col-7">Larry the Bird</td>
                                    <td class="col-2">@twitter</td>
                                    <td class="col-2">
                                        <a href="index.html" class="cbutton cbutton--blue cbutton--small">Chỉnh sửa</a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="content-2">
                            <table class="table table-bordered u-center-text">
                                <thead>
                                <tr class="d-flex table-secondary">
                                    <th class="col-1" scope="col">ID</th>
                                    <th class="col-7" scope="col">Tiêu đề</th>
                                    <th class="col-2" scope="col">Trạng thái</th>
                                    <th class="col-2" scope="col"> Chỉnh sửa
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr class="d-flex">
                                    <th class="col-1" scope="row">1</th>
                                    <td class="col-7">Mark</td>
                                    <td class="col-2">Otto</td>
                                    <td class="col-2">
                                        <a href="index.html" class="cbutton cbutton--blue cbutton--small">Chỉnh sửa</a>
                                    </td>
                                </tr>
                                <tr class="d-flex">
                                    <th class="col-1" scope="row">2</th>
                                    <td class="col-7">Jacob</td>
                                    <td class="col-2">Thornton</td>
                                    <td class="col-2">
                                        <a href="index.html" class="cbutton cbutton--blue cbutton--small">Chỉnh sửa</a>
                                    </td>
                                </tr>
                                <tr class="d-flex">
                                    <th class="col-1" scope="row">3</th>
                                    <td class="col-7">Larry the Bird</td>
                                    <td class="col-2">@twitter</td>
                                    <td class="col-2">
                                        <a href="index.html" class="cbutton cbutton--blue cbutton--small">Chỉnh sửa</a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
