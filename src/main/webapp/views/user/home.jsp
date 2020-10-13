<%--
  Created by IntelliJ IDEA.
  User: VuKhanh
  Date: 10/7/2020
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Review Film</title>
    <link href="<c:url value='/css/style.css'/>" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous">
    </script>
</head>
<body>
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
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <img src="https://www.cccd.edu/_assets/images/Departments/NoProfile.png" width="40" height="40" class="rounded-circle">
                                </a>
                            </li>
                        </ul>
                    </div>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-list-4" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
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
<div class="container-fluid">
    <div class="row">
        <a href="<c:url value="/create-post"/>" class="cbutton cbutton--blue cbutton--medium">Create New Post</a>
    </div>
    <div class="row">
        <div class="col-8 content-wrap">
            <!-- Toolbar -->
            <!-- Search-->
            <div class="content-wrap--left">
                <input class="input" type="text" id="search" class="m-2" name="search" placeholder="Search">
            </div>
            <!-- Filter -->
            <div class="content-wrap--right">
                <div class="select">
                    <select id="standard-select">
                        <option value="Option 1" selected>Sort by Date increase <span class="u-color-green u-bold">&uarr;</span>
                        </option>
                        <option value="Option 2">Sort by Date decrease <span class="u-color-green u-bold">&darr;</span>
                        </option>
                        <option value="Option 3">Sort by Like increase <span class="u-color-green u-bold">&uarr;</span>
                        </option>
                        <option value="Option 4">Sort by Like decrease <span class="u-color-green u-bold">&darr;</span>
                        </option>
                        <option value="Option 5">Sort by Dislike increase <span
                                class="u-color-green u-bold">&uarr;</span></option>
                        <option value="Option 6">Sort by Dislike decrease <span
                                class="u-color-green u-bold">&darr;</span></option>
                    </select>
                    <span class="focus"></span>
                </div>
            </div>
            <div class="content-collapse">
                <c:forEach var="item" items="${post}">
                    <c:url var="detailPost" value="/detail-post">
                        <c:param name="id" value="${item.id}"/>
                    </c:url>
                    <a href="${detailPost}">
                        <div class="content-collapse__item">
                            <div class=" content-collapse__item--left">
                                <div class="content-collapse__item--avatar">
                                    <img src="<c:url value="/images/bgLogin.jpg"/>" alt="">
                                </div>
                                <div class="content-collapse__item--textavatar">
                                        ${item.user.fullname}
                                </div>
                            </div>
                            <div class="content-collapse__item--right">
                                <div class="content-collapse__item--title">
                                    <span>#1 </span><span>${item.title}</span>
                                </div>
                                <div class="content-collapse__item--subtitle">
                                    <p><span class="u-bold">Date Modified:</span> <span>${item.dateModified}</span></p>
                                    <p><span class="u-bold">Like:</span> <span class="u-color-green">${item.upvote}</span>
                                    </p>
                                    <p><span class="u-bold">Dislike:</span> <span
                                            class="u-color-red">${item.downvote}</span></p>
                                </div>
                            </div>
                        </div>
                    </a>
                </c:forEach>
            </div>
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                            <span class="sr-only">Previous</span>
                        </a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                            <span class="sr-only">Next</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="col-4 rank-wrap">
            <div class="row">
                <div class="rank-wrap__title">
                    Top Reviewers
                </div>
                <div class="rank-reviewers">
                    <div class="rank-reviewers__item">
                        <div class="rank-reviewers__item--left">
                            <div class="rank-reviewers__item--avatar">
                                <img src="<c:url value="/images/logo.png"/>" alt="">
                            </div>
                        </div>
                        <div class="rank-reviewers__item--right">
                            <div class="rank-reviewers__item--title">
                                Nguyễn Vũ Khánh
                            </div>
                            <div class="rank-reviewers__item--subtitle">
                                <p><span class="u-bold">Total Posts:</span> <span
                                        class="u-color-green">50</span>
                                </p>
                                <p><span class="u-bold">Total likes:</span> <span class="u-color-red">21</span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="rank-reviewers__item">
                        <div class="rank-reviewers__item--left">
                            <div class="rank-reviewers__item--avatar">
                                <img src=".<c:url value="/images/logo.png"/>" alt="">
                            </div>
                        </div>
                        <div class="rank-reviewers__item--right">
                            <div class="rank-reviewers__item--title">
                                Nguyễn Vũ Khánh
                            </div>
                            <div class="rank-reviewers__item--subtitle">
                                <p><span class="u-bold">Số bài viết:</span> <span
                                        class="u-color-green">50</span>
                                </p>
                                <p><span class="u-bold">Lượt vote:</span> <span class="u-color-red">21</span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="rank-reviewers__item">
                        <div class="rank-reviewers__item--left">
                            <div class="rank-reviewers__item--avatar">
                                <img src="<c:url value="/images/logo.png"/>" alt="">
                            </div>
                        </div>
                        <div class="rank-reviewers__item--right">
                            <div class="rank-reviewers__item--title">
                                Nguyễn Vũ Khánh
                            </div>
                            <div class="rank-reviewers__item--subtitle">
                                <p><span class="u-bold">Số bài viết:</span> <span
                                        class="u-color-green">50</span>
                                </p>
                                <p><span class="u-bold">Lượt vote:</span> <span class="u-color-red">21</span>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="rank-wrap__title">
                    Top Posts
                </div>
                <div class="rank-posts">
                    <div class="rank-posts__item">
                        <div class="rank-posts__item--title">
                            <span>#1: </span><span>Tiêu đề bài viết</span>
                        </div>
                        <div class="rank-posts__item--subtitle">
                            <p><span class="u-bold">Lượt vote:</span> <span class="u-color-green">21</span></p>
                        </div>
                    </div>
                    <div class="rank-posts__item">
                        <div class="rank-posts__item--title">
                            <span>#1: </span><span>Tiêu đề bài viết</span>
                        </div>
                        <div class="rank-posts__item--subtitle">
                            <p><span class="u-bold">Lượt vote:</span> <span class="u-color-green">21</span></p>
                        </div>
                    </div>
                    <div class="rank-posts__item">
                        <div class="rank-posts__item--title">
                            <span>#1: </span><span>Tiêu đề bài viết</span>
                        </div>
                        <div class="rank-posts__item--subtitle">
                            <p><span class="u-bold">Lượt vote:</span> <span class="u-color-green">21</span></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
