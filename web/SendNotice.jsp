<%--
  Created by IntelliJ IDEA.
  User: TomatoMan
  Date: 2021/1/7
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>发布公告</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="css/mycss.css">
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
                        <a class="btn btn-outline-light mr-2" href="AdminMainPage.jsp">&nbsp;&nbsp;主页&nbsp;&nbsp;</a>
                    </li>
                    <li class="nav-item">
                        <div class="dropdown mr-2">
                            <button class="btn btn-outline-light" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                &nbsp;&nbsp;我的&nbsp;&nbsp;
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                                <a class="btn dropdown-item" type="button" href="AdminPage.jsp">个人信息</a>
                                <a class="btn dropdown-item" type="button" href="logout.do">退出登录</a>
                            </div>
                        </div>
                    </li>
                    <li class="nav-item">
                        <div class="dropdown mr-2">
                            <button class="btn btn-outline-light" type="button" id="dropdownMenu3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                &nbsp;&nbsp;建议&nbsp;&nbsp;
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                                <a class="btn dropdown-item" type="button" href="CheckSuggestions.jsp">查看建议</a>
                            </div>
                        </div>
                    </li>
                    <li class="nav-item">
                        <div class="dropdown mr-2">
                            <button class="btn btn-outline-light" type="button" id="dropdownMenu4" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                &nbsp;&nbsp;公告&nbsp;&nbsp;
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                                <a class="btn dropdown-item" type="button" href="SendNotice.jsp">发布公告</a>
                                <a class="btn dropdown-item" type="button" href="CheckNotice.jsp">查看公告</a>
                            </div>
                        </div>
                    </li>
                    <li class="nav-item">
                        <div class="dropdown mr-2">
                            <button class="btn btn-outline-light" type="button" id="dropdownMenu5" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                &nbsp;&nbsp;用户&nbsp;&nbsp;
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                                <a class="btn dropdown-item" type="button" href="deleteUser.jsp">删除用户</a>
                            </div>
                        </div>
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
        <div class="blurryBackground pt-lg-5">
            <div class="col-10 offset-sm-1">
                <form action="addNotice.do" method="post" class="was-validated">
                    <div class="mb-3">
                        <label for="validationTextarea">公告标题</label>
                        <div class="input-group is-invalid">
                            <input type="text" class="form-control is-invalid" name="notice_title" placeholder="请输入公告的标题" aria-describedby="validatedInputGroupPrepend" required>
                            <div class="valid-feedback">
                                公告有效
                            </div>
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="validationTextarea">公告内容</label>
                        <textarea class="form-control is-invalid" rows="10" name="notice_content" id="validationTextarea" placeholder="公告详细内容" required></textarea>
                        <div class="valid-feedback">
                            公告内容有效
                        </div>
                    </div>
                    <c:if test="${requestScope.add_question_success != null}">
                        <div class="text-center offset-5">
                            <div class="alert alert-success col-3" role="alert">
                                    ${requestScope.add_question_success}
                            </div>
                        </div>
                    </c:if>
                    <div class="text-center">
                        <button class="btn btn-primary" type="submit">提交公告</button>
                        <button class="btn btn-info" type="reset">清空内容</button>
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
