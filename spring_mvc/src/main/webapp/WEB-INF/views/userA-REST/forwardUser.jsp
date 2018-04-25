<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 18-2-3
  Time: 下午6:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>用户添加</title>
    <script src="${pageContext.request.contextPath}/components/jquery-module/jquery-mini/jquery-1.9.1.min.js" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/js/npm.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/laydate/laydate.js" type="text/javascript"></script>
    <script>
        //yyyy-MM-dd被固定了
        laydate.render({
            elem: '#testLayDate' //指定元素 id
        });
    </script>
    <style>
        .divNG1{
            margin-right:auto;margin-left:auto;width:1000px;height:auto;
        }
        .divNG2{
            text-align:center;width:100%;height:auto;margin-top:20px;
        }
    </style>
</head>
<body>
    <div class="divNG1 panel">
        <div class="divNG2 panel-body">
            <h4 class="panel-title page-header">用户信息添加</h4><br/>
            <div style="text-align:center;width:62%;margin-bottom:15px;margin-top:15px;margin-left:auto;margin-right:auto;">
                <form:form commandName="userA" action="${pageContext.request.contextPath}/user/addUser.action" cssClass="form-group" method="post">
                    <input type="text" name="name" placeholder="姓名" class="form-control"><br/>
                    <input type="password" name="password" placeholder="密码" class="form-control"><br/>
                    <input type="text" name="username" placeholder="用户名" class="form-control"><br/>
                    <!--
                    <input type="text" name="birthday" placeholder="生日" class="form-control" id="testLayDate"><br/>
                    -->
                    <input type="text" name="account" placeholder="账户" class="form-control"><br/>
                    <input type="text" name="group" placeholder="组:如中石油" class="form-control"><br/>
                    <input type="radio" name="sex" value="man" checked="checked" class="form-inline" />man
                    <input type="radio" name="sex" value="woman" class="form-inline"/>woman<br/>
                    <input type="text" name="age" placeholder="年龄" class="form-control"><br/>
                    <input type="text" name="address" placeholder="地址" class="form-control"><br/>
                    jurisdiction:<form:radiobuttons path="jurisdiction" items="${jurisdictions}" cssClass="form-inline" /><br/>
                    role:<form:checkboxes path="role" items="${roles}" /><br/>
                    <input type="submit" value="submit" class="btn btn-default"><br/>
                </form:form>
            </div>
        </div>
        <div class="divNG2 panel-footer">
            <a href="${pageContext.request.contextPath}/springmvc/home" class="btn btn-info">返回Home</a>
        </div>
    </div>
</body>
</html>
