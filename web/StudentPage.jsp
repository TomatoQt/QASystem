<%--
  Created by IntelliJ IDEA.
  User: TomatoMan
  Date: 2020/12/30
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>学生个人信息</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="css/mycss.css">
    <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function() {
            'use strict';
            window.addEventListener('load', function() {
                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.getElementsByClassName('needs-validation');
                // Loop over them and prevent submission
                var validation = Array.prototype.filter.call(forms, function(form) {
                    form.addEventListener('submit', function(event) {
                        if (form.checkValidity() === false) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
            }, false);
        })();
    </script>
</head>
<body class="myBackground">
<div class="container">
    <div class="fixed-top">
        <div class="collapse" id="navbarToggleExternalContent">
            <div class="bg-dark p-4">
                <h5 class="text-white h4">${sessionScope.userType}&nbsp;&nbsp;&nbsp;${sessionScope.user.name}</h5>
                <span class="text-muted">Toggleable via the navbar brand.</span>
            </div>
        </div>
        <nav class="navbar navbar-dark bg-dark">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="d-inline-block">
                <ul class="nav">
                    <li class="nav-item">
                        <a class="btn btn-outline-light mr-2" href="StudentMainPage.jsp">&nbsp;&nbsp;主页&nbsp;&nbsp;</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light mr-2" href="newQuestion.jsp">&nbsp;&nbsp;提问&nbsp;&nbsp;</a>
                    </li>
                    <li class="nav-item">
                        <div class="dropdown mr-2">
                            <button class="btn btn-outline-light" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                &nbsp;&nbsp;我的&nbsp;&nbsp;
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                                <a class="btn dropdown-item" type="button" href="StudentPage.jsp">个人信息</a>
                                <a class="btn dropdown-item" type="button" href="StudentQuestions.jsp">我的提问</a>
                                <a class="btn dropdown-item" type="button" href="StudentAnswers.jsp">我的回答</a>
                                <a class="btn dropdown-item" type="button" href="StudentSuggestions.jsp">我的建议</a>
                                <a class="btn dropdown-item" type="button" href="logout.do">退出登录</a>
                            </div>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light mr-2" href="StudentOfferSuggestion.jsp">提出建议</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light" href="StudentNotice.jsp">&nbsp;&nbsp;公告&nbsp;&nbsp;</a>
                    </li>
                </ul>
            </div>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="请输入搜索的问题内容" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
            </form>
        </nav>
    </div>
    <%--下部主体--%>
    <div class="mt-lg-5 pt-lg-5">
        <div class="blurryBackground">
            <div class="mt-5 mb-5 ml-5 mr-5">
                <form class="needs-validation" novalidate action="updateStu.do">
                    <div class="form-row">
                        <div class="col-md-6 mb-3">
                            <label for="validationCustom01">名字</label>
                            <input type="text" class="form-control" id="validationCustom01" name="ming" required>
                            <div class="valid-feedback">
                                不错
                            </div>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="validationCustom02">姓氏</label>
                            <input type="text" class="form-control" id="validationCustom02" name="xing" required>
                            <div class="valid-feedback">
                                不错
                            </div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-6 mb-3">
                            <label for="validationCustom03">电话</label>
                            <input type="text" class="form-control" id="validationCustom03" name="phone" required>
                            <div class="invalid-feedback">
                                请输入电话
                            </div>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label for="validationCustom04">昵称</label>
                            <input type="text" class="form-control" id="validationCustom04" name="nickname" required>
                            <div class="invalid-feedback">
                                请输入昵称
                            </div>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label for="validationCustom05">性别</label>
                            <select class="custom-select" id="validationCustom05" name="sex" required>
                                <option value="1">男</option>
                                <option value="0">女</option>
                            </select>
                            <div class="invalid-feedback">
                                请选择性别
                            </div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-6 mb-3">
                            <label for="validationCustom06">邮箱</label>
                            <input type="text" class="form-control" id="validationCustom06" required name="email">
                            <div class="valid-feedback">
                                不错
                            </div>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="validationCustom07">身份证</label>
                            <input type="text" class="form-control" id="validationCustom07" name="idCard" required>
                            <div class="valid-feedback">
                                不错
                            </div>
                        </div>
                    </div>
                    <div class="text-center">
                        <button class="btn btn-primary mt-3" type="submit">确认提交</button>
                        <button class="btn btn-info mt-3" type="reset">&nbsp;&nbsp;&nbsp;&nbsp;重置&nbsp;&nbsp;&nbsp;&nbsp;</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <%--end--%>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>
