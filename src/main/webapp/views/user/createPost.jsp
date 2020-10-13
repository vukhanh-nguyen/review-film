<%--
  Created by IntelliJ IDEA.
  User: VuKhanh
  Date: 10/8/2020
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="createPostAPI" value="/api-create-post"/>
<c:url var="listPosts" value="/list-posts"/>
<c:url var="createPost" value="/create-post"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Post - Review Film</title>
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
                                    <c:url var="profile" value="/profile">
                                        <c:param name="id" value="${sessionScope.LOGIN.id}"/>
                                    </c:url>
                                    <a class="dropdown-item" href="#${profile}">Profile</a>
                                    <a class="dropdown-item" href="<c:url value="/list-posts"/>">Your posts</a>
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
<div class="create-post-wrap">
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
        <a href="<c:url value='/home'/>" class="cbutton cbutton--blue cbutton--big">List Posts</a>
    </div>
    <div class="row">
        <div class="col-12">
            <div class="new-post">
                <div class="new-post__title">
                    Create New Post
                </div>
                <form id="createPostForm" class="new-post__form">
                    <label class="new-post__label" for="title">Title</label>
                    <input class="input" type="text" id="title" name="title" autocomplete="off">
                    <label class="new-post__label" for="filmName">Film Name</label>
                    <input class="input" type="text" id="filmName" name="filmName" autocomplete="off">
                    <label class="new-post__label" for="postRate">Rate</label>
                    <input class="input" type="text" id="postRate" name="postRate" autocomplete="off">
                    <label class="new-post__label" for="postReview">Review</label>
                    <textarea class="input" id="postReview" name="postReview"></textarea>
                </form>
                <div class="new-post__btn">
                    <a href="#" class="cbutton cbutton--blue cbutton--small">Reset</a>
                    <a href="#" id="createPost" class="cbutton cbutton--green cbutton--small">Save</a>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous">
</script>
<script src="https://cdn.ckeditor.com/4.15.0/standard/ckeditor.js"></script>
<script type="text/javascript">

    var editor = "";
    $(document).ready(function () {
        editor = CKEDITOR.replace('postReview')
    });

    $('#createPost').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#createPostForm').serializeArray();

        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        });

        data["postReview"] = editor.getData();
        addNewPost(data);

    });

    function addNewPost(data) {
        $.ajax({
            url: '${createPostAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${listPosts}?message=success";
            },
            error: function (error) {
                window.location.href = "${createPost}?message=fail";
            }
        });
    }
</script>
</body>
</html>
