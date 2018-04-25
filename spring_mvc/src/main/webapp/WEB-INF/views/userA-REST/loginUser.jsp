<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 18-4-10
  Time: 下午3:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/components/jquery-module/jquery-mini/jquery-1.9.1.min.js" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/js/npm.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/laydate/laydate.js" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/components/login/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="login_box">
    <div class="login_l_img"><img src="${pageContext.request.contextPath}/components/login/images/login-img.png" /></div>
    <div class="login">
        <div class="login_logo"><a href="#"><img src="${pageContext.request.contextPath}/components/login/images/login_logo.png" /></a></div>
        <div class="login_name">
            <p>后台管理系统</p>
        </div>
        <form method="post" action="${pageContext.request.contextPath}/user/login.action">
            <input name="username" type="text"  value="用户名" onfocus="this.value=''" onblur="if(this.value==''){this.value='用户名'}">
            <span id="password_text" onclick="this.style.display='none';document.getElementById('password').style.display='block';document.getElementById('password').focus().select();" >密码</span>
            <input name="password" type="password" id="password" style="display:none;" onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};"/>
            <input value="登录" style="width:100%;" type="submit"><br/>
            <font color="red">${message}</font>
        </form>
    </div>
    <div class="copyright">某某有限公司 版权所有©2016-2018 技术支持电话：000-00000000</div>
</div>
</body>
</html>
