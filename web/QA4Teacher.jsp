<%--
  Created by IntelliJ IDEA.
  User: TomatoMan
  Date: 2021/1/7
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page import="Bean.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <%--    <meta http-equiv="refresh" content="5">--%>
    <title>问题</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="css/mycss.css">
    <script language="javascript">function fsubmit(obj){obj.submit();}</script>
</head>
<body class="myBackground">
<!-- Modal 回答问题 -->
<div class="modal fade" id="newAnswer" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">撰写回答</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form name="answer_content" action="answer.do" method="post">
                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">输入你的回答</label>
                        <textarea name="Answer_textarea_content" class="form-control" id="exampleFormControlTextarea1" rows="8"></textarea>
                    </div>
                    <input type="hidden" name="q_id" value="${requestScope.question.id}">
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="javascript:fsubmit(document.answer_content);">提交</button>
            </div>
        </div>
    </div>
</div>
<%--<!-- Modal 新增追问教师 -->--%>
<%--<div class="modal fade" id="newRKS" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--    <div class="modal-dialog">--%>
<%--        <div class="modal-content">--%>
<%--            <div class="modal-header">--%>
<%--                <h5 class="modal-title">Modal title</h5>--%>
<%--                <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                    <span aria-hidden="true">&times;</span>--%>
<%--                </button>--%>
<%--            </div>--%>
<%--            <div class="modal-body">--%>
<%--                <form name="reask_content" action="addReAns.do" method="post">--%>
<%--                    <div class="form-group">--%>
<%--                        <label>输入你的回答</label>--%>
<%--                        <textarea name="ReAnswer_content" class="form-control" rows="8"></textarea>--%>
<%--                    </div>--%>
<%--                    <input type="hidden" id="Ask_id" name="Ask_id" value="">--%>
<%--                </form>--%>
<%--            </div>--%>
<%--            <div class="modal-footer">--%>
<%--                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>--%>
<%--                <button type="button" class="btn btn-primary" onclick="javascript:fsubmit(document.reask_content);">提交</button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<!-- Modal 新增教师复答 -->
<div class="modal fade" id="newRAS" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form name="reanswer_content" action="addReAns.do" method="post">
                    <div class="form-group">
                        <label>输入你的回答</label>
                        <textarea name="ReAnswer_content" class="form-control" rows="8"></textarea>
                    </div>
                    <input type="hidden" id="Answer_id" name="Answer_id" value="">
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="javascript:fsubmit(document.reanswer_content);">提交</button>
            </div>
        </div>
    </div>
</div>
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
                        <a class="btn btn-outline-light mr-2" href="teacherMainPage.jsp">&nbsp;&nbsp;主页&nbsp;&nbsp;</a>
                    </li>
                    <li class="nav-item">
                        <div class="dropdown mr-2">
                            <button class="btn btn-outline-light" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                &nbsp;&nbsp;我的&nbsp;&nbsp;
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                                <a class="btn dropdown-item" type="button" href="TeacherPage.jsp">个人信息</a>
                                <a class="btn dropdown-item" type="button" href="TeacherAnswers.jsp">我的回答</a>
                                <a class="btn dropdown-item" type="button" href="TeacherSuggestions.jsp">我的建议</a>
                                <a class="btn dropdown-item" type="button" href="logout.do">退出登录</a>
                            </div>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light mr-2" href="TeacherOfferSuggestion.jsp">提出建议</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light" href="TeacherNotice.jsp">&nbsp;&nbsp;公告&nbsp;&nbsp;</a>
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
        <h3 class="pt-2" style="color: #e9ecef">问题<span class="badge badge-secondary ml-1">Q</span></h3>
        <div>
            <!--问题-->
            <div class="card mb-4">
                <div class="card-header">
                    提问者:&nbsp;&nbsp;${requestScope.question.stu_id}
                </div>
                <div class="card-body">
                    <h5 class="card-title">${requestScope.question.title}</h5>
                    <p class="card-text">${requestScope.question.content}</p>
                    <label class="offset-10">${requestScope.question.time}</label>
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#newAnswer">
                        我来答
                    </button>
                </div>
            </div>
            <!--教师答案-->
            <h3 class="pt-2" style="color: #bd4147">教师解答<span class="badge badge-success ml-2">Teacher Answers</span></h3>
            <div class="accordion">
                <c:forEach items="${requestScope.teacher_answers}" var="A" varStatus="status">
                    <div class="card">
                        <div class="card-header">
                            <h2 class="mb-0">
                                <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                    教师 (${A.tea_id}) 解答 #${status.count}
                                </button>
                            </h2>
                        </div>
                        <div class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                            <div class="card-body">
                                <p class="text-left">${A.teaA_content}</p>
                                <label class="offset-10">${A.teaA_time}</label>
                                <div class="separate_line"></div>
                                <c:forEach items="${requestScope.mapTeaA[A.teaA_id]}" var="teaA_down">
                                    <%--                                    <div>--%>
                                    <%--                                        <p class="text-left">${stuA_down.rAskStu_content}</p>--%>
                                    <%--                                        <p class="text-right">${stuA_down.date}</p>--%>
                                    <%--                                    </div>--%>
                                    <div>
                                        <p class="text-left">${teaA_down.rAnsTea_content}</p>
                                        <label class="offset-10">${teaA_down.date}</label>
                                    </div>
                                </c:forEach>
                            </div>
                            <div class="card-footer">
                                <c:if test="${sessionScope.user.id == requestScope.question.stu_id}">
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#newRKS" value="${A.teaA_id}" onclick="setAskValue(this)">
                                        追问
                                    </button>
                                </c:if>
                                <c:if test="${A.tea_id == sessionScope.user.id}">
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#newRAS" value="${A.teaA_id}" onclick="setAnswerValue(this)">
                                        补充
                                    </button>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <!--学生答案-->
            <h3 class="pt-2" style="color: #bd4147">学生解答<span class="badge badge-success ml-2">Student Answers</span></h3>
            <div class="accordion">
                <c:forEach items="${requestScope.student_answers}" var="A" varStatus="status">
                    <div class="card mb-2">
                        <div class="card-header">
                            <h2 class="mb-0">
                                <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                    学生 (${A.stu_id}) 解答 #${status.count}
                                </button>
                            </h2>
                        </div>

                        <div class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                            <div class="card-body">
                                <p class="text-left">${A.stuA_content}</p>
                                <label class="offset-10">${A.stuA_time}</label>
                                <div class="separate_line"></div>
                                <c:forEach items="${requestScope.mapStuA[A.stuA_id]}" var="stuA_down">
                                    <%--                                    <div>--%>
                                    <%--                                        <p class="text-left">${stuA_down.rAskStu_content}</p>--%>
                                    <%--                                        <p class="text-right">${stuA_down.date}</p>--%>
                                    <%--                                    </div>--%>
                                    <div>
                                        <p class="text-left">${stuA_down.rAnsStu_content}</p>
                                        <label class="offset-10">${stuA_down.date}</label>
                                    </div>
                                </c:forEach>
                            </div>
                            <div class="card-footer">
                                <c:if test="${sessionScope.user.id == requestScope.question.stu_id}">
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#newRKS" value="${A.stuA_id}" onclick="setAnswerValue(this)">
                                        追问
                                    </button>
                                </c:if>
                                <c:if test="${A.stu_id == sessionScope.user.id}">
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#newRAS" value="${A.stuA_id}" onclick="setAnswerValue(this)">
                                        补充
                                    </button>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

    <%--end--%>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script src="js/myjs.js"></script>
</body>
</html>

