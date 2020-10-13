<%--
  Created by IntelliJ IDEA.
  User: VuKhanh
  Date: 10/10/2020
  Time: 4:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="createCommentAPI" value="/api-comment"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detail Post - Review Film</title>
    <link href="<c:url value='/css/style.css'/>" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
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
<div class="detail-post-wrap">
    <div class="row mb-5">
        <a href="<c:url value='/home'/>" class="cbutton cbutton--blue cbutton--big">List Posts</a>
    </div>
    <div class="row">
        <div class="col-2">
            <div class="box-avatar">
                <div class="box-avatar__avatar">
                    <img src="<c:url value="/images/bgLogin.jpg"/>" alt="">
                </div>
                <div class="box-avatar__name">
                    ${post.user.fullname}
                </div>
                <div class="box-avatar__action">
                    <p><span class="u-bold">Lượt post:</span> <span class="u-color-blue">${post.user.quantityPost}</span>
                    </p>
                    <p><span class="u-bold">Lượt vote:</span> <span class="u-color-green">${post.user.quantityUpvote}</span>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-7">
            <div class="box-detail-post">
                <div class="box-detail-post__heading">
                    ${post.title}
                </div>
                <div class="box-detail-post__row">
                    <div class="box-detail-post__row--left box-detail-post__row--bold">
                        Film Name
                    </div>
                    <div class="box-detail-post__row--right box-detail-post__row--thin">
                        ${post.filmName}
                    </div>
                </div>
                <div class="box-detail-post__row">
                    <div class="box-detail-post__row--left box-detail-post__row--bold">
                        Rate
                    </div>
                    <div class="box-detail-post__row--right box-detail-post__row--thin">
                        ${post.postRate}/10
                    </div>
                </div>
                <div class="box-detail-post__row">
                    <div class="box-detail-post__row--left box-detail-post__row--bold">
                        Review
                    </div>
                    <div class="box-detail-post__row--right box-detail-post__row--thin">
                        ${post.postReview}
                    </div>
                </div>
                <div class="box-detail-post__row">
                    <div class="box-detail-post__row--left">
                        <p><span class="u-bold">Lượt like:</span> <span class="u-color-green">${post.upvote}</span>
                        </p>
                        <p><span class="u-bold">Lượt dislike:</span> <span class="u-color-red">${post.downvote}</span>
                        </p>
                    </div>
                    <div class="box-detail-post__row--right">
                        <div class="box-detail-post__row--icon">
                            <i id="like" class="fas fa-thumbs-up"><span class="badge badge-success">+1</span></i>
                            <i id="dislike" class="fas fa-thumbs-down"><span class="badge badge-danger">+1</span></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-3">
            <c:if test="${sessionScope.LOGIN != null}">
                <div class="comment-box">
                    <div class="comment-box__new">
                        <input id="typeComment" style="margin-left:2rem" class="input" type="text" id="title" name="title" autocomplete="off" placeholder="Type to comment">
                        <a id="comment" href="#" class="cbutton cbutton--blue cbutton--small">Comment</a>
                    </div>
                    <c:forEach var="item" items="${comments}">
                        <div class="comment-box__item">
                            <div class="comment-box__item__logo">
                                <img src="<c:url value="/images/bgLogin.jpg"/>" alt="">
                            </div>
                            <div class="comment-box__item__content">
                                <p><span class="u-bold">${item.user.fullname}</span> <span>${item.content}</span>
                                </p>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </c:if>
            <c:if test="${sessionScope.LOGIN == null}">
                <div class="comment-box comment-box--disable">
                    <a href="<c:url value="/login"/>" class="cbutton cbutton--blue cbutton--small">LOGIN</a>
                    <p>Sign in to comment</p>
                </div>
            </c:if>

        </div>
    </div>
</div>
<script type="text/javascript">
    $('#comment').click(function (e) {
        e.preventDefault();
        var data = {};
        data["content"] = $('#typeComment').val();
        data["post_id"] = ${post.id};
        data["user_id"] = ${sessionScope.LOGIN.id};
        addComment(data);
    });

    function addComment(data) {
        $.ajax({
            url: '${createCommentAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                location.reload()
            },
            error: function (error) {
                alert("Không hợp lệ");
            }
        });
    }
</script>
</body>
</html>
