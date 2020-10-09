
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
<div class="">
    <div class="heading-wrap">
        <div class="row">
            <div class="col-8">
                <img src="<c:url value="/images/logo.png"/>" alt="">
            </div>
            <div class="col-4">
                <div class="navigation">
                    <a href="<c:url value='/dang-nhap'/>" methods="GET" class="cbutton cbutton--blue cbutton--medium">Đăng Nhập</a>
                    <a href="<c:url value='/dang-ky'/>" METHODS="GET" class="cbutton cbutton--blue cbutton--small">Đăng Ký</a>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid">
        <div class="row">
            <a href="createpost.html" class="cbutton cbutton--blue cbutton--medium">Tạo bài viết mới</a>
        </div>
        <div class="row">
            <div class="col-8 content-wrap">
                <!-- Toolbar -->
                <!-- Search-->
                <div class="content-wrap--left">
                    <input class="input" type="text" id="search" class="m-2" name="search" placeholder="Nhập để tìm kiếm">
                </div>
                <!-- Filter -->
                <div class="content-wrap--right">
                    <div class="select">
                        <select id="standard-select">
                            <option value="Option 1" selected>Sắp xếp theo ngày tăng dần</option>
                            <option value="Option 2">Sắp xếp theo ngày giảm dần</option>
                            <option value="Option 3">Sắp xếp theo lượt like tăng dần</option>
                            <option value="Option 4">Sắp xếp theo lượt like giảm dần</option>
                            <option value="Option 5">Sắp xếp theo lượt dislike tăng dần</option>
                            <option value="Option 6">Sắp xếp theo lượt dislike giảm dần</option>
                        </select>
                        <span class="focus"></span>
                    </div>
                </div>
                <div class="content-collapse">
                    <c:forEach var="item" items="${post}">
                        <div class="content-collapse__item">
                            <div class=" content-collapse__item--left">
                                <div class="content-collapse__item--avatar">
                                    <img src="<c:url value="/images/bgLogin.jpg"/>" alt="">
                                </div>
                                <div class="content-collapse__item--textavatar">
                                    Họ và tên
                                </div>
                            </div>
                            <div class="content-collapse__item--right">
                                <div class="content-collapse__item--title">
                                    <span>#1 </span><span>${item.title}</span>
                                </div>
                                <div class="content-collapse__item--subtitle">
                                    <p><span class="u-bold">Ngày:</span> <span>${item.dateModified}</span></p>
                                    <p><span class="u-bold">Lượt like:</span> <span class="u-color-green">${item.upvote}</span></p>
                                    <p><span class="u-bold">Lượt dislike:</span> <span class="u-color-red">${item.downvote}</span></p>
                                </div>
                            </div>
                        </div>
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
                        Top người bình luận
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
                        Top bài viết
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
</div>
</body>
</html>
