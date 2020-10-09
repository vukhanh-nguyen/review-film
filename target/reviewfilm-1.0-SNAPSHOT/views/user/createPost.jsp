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
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tạo bài viết - Review Film</title>
    <link href="../css/style.css" rel="stylesheet">
    <link rel="shortcut icon" href="/img/LOGOMAIN.ico" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous">
    </script>
</head>
<body>
<div class="">
    <!-- CSS heading wrap ở file home.scss -->
    <div class="heading-wrap">
        <div class="row">
            <div class="col-8">
                <img src="../img/logo.png" alt="">
            </div>
            <div class="col-4">
                <div class="navigation">
                    <a href="<c:url value='/dang-nhap'/>" class="cbutton cbutton--blue cbutton--medium">Đăng Nhập</a>
                    <a href="<c:url value='/dang-ky'/>" class="cbutton cbutton--blue cbutton--small">Đăng Ký</a>
                </div>
            </div>
        </div>
    </div>
    <div class="content-wrap">
        <div class="row mb-5">
            <a href="<c:url value='/trang-chu'/>" class="cbutton cbutton--blue cbutton--big">Danh sách bài viết</a>
        </div>
        <div class="row">
            <div class="col-12">
                <div class="new-post">
                    <div class="new-post__title">
                        Tạo bài viết mới
                    </div>
                    <form id="createPostForm" class="new-post__form">
                        <label class="new-post__label" for="title">Tiêu đề bài viết</label>
                        <input class="input" type="text" id="title" name="title">
                        <label class="new-post__label" for="filmName">Tên bộ phim</label>
                        <input class="input" type="text" id="filmName" name="filmName">
                        <label class="new-post__label" for="postRate">Đánh giá</label>
                        <input class="input" type="text" id="postRate" name="postRate">
                        <label class="new-post__label" for="postReview">Nhận xét</label>
                        <input class="input" type="text" id="postReview" name="postReview">
                    </form>
                    <div class="new-post__btn">
                        <a href="#" class="cbutton cbutton--blue cbutton--small">Khôi phục</a>
                        <a href="#" class="cbutton cbutton--green cbutton--small">Lưu</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">

    var editor = "";
    $(document).ready(function () {
        editor = CKEDITOR.replace('postReview')
    });

    $('#AddOrUpdateProduct').click(function (e) {
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
                console.log(result);
                //window.location.href = "${editBlog}?id=" + result.id + "&message=insert_success";
            },
            error: function (error) {
               //window.location.href = "${listBlog}?page=1&limit=10&message=error_system";
                console.log(error);
            }
        });
    }
</script>
</body>
</html>
