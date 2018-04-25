<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 18-1-25
  Time: 下午2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>home</title>
    <script src="${pageContext.request.contextPath}/components/jquery-module/jquery-mini/jquery-1.9.1.min.js" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/js/npm.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/laydate/laydate.js" type="text/javascript"></script>
    <style>
        body{
            margin: 0 auto;
            font-family: "Ubuntu Light";
        }
        ul li{
            list-style: none;
            font-family: Ubuntu;
        }
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="panel" style="text-align:center;width: 1000px;height:auto;margin-right:auto;margin-left:auto;">
    <div class="panel-body" style="width:100%;height:auto;margin-top:40px;">
        <h3 class="panel-title"> 海风在摇曳</h3><br/>
        <ol>
            <li class="list-group">
                凡是新的事情在起头总是这样一来的，起初热心的人很多，而不久就冷淡下去，撒手不做了，因为他已经明白，不经过一番苦工是做不成的，而只有想做的人，才忍得过这番痛苦。——陀思妥耶夫斯基
            </li>

            <li class="list-group">
                富贵不能淫，贫贱不能移，威武不能屈。——孟子
            </li>
        </ol>
        <ul class="list-group">
            <li><a href="${pageContext.request.contextPath}/REST/emps">HTTP REST</a> </li>
            <li><a href="${pageContext.request.contextPath}/user/userList.action">用户列表</a> </li>
            <li><a href="${pageContext.request.contextPath}/user/forwardUser.action">用户添加</a> </li>
            <li><a href="${pageContext.request.contextPath}/user/forwardLogin.action">用户登录</a> </li>
            <li><a href="${pageContext.request.contextPath}/file/ForWard.action">文件上传测试</a> </li>
        </ul>
        <p>
            耐心是一切聪明才智的基础。——柏拉图
        </p>
    </div>
</div>
</body>
</html>
