<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 18-1-25
  Time: 下午12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
    <meta http-equiv="Refresh" content="4;url=${pageContext.request.contextPath}/springmvc/home">
    <style>
        body {
            margin: 0 auto;
            background: #2e6da4;
        }
    </style>
    <script src="${pageContext.request.contextPath}/components/jquery-module/jquery-mini/jquery-1.9.1.min.js" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/js/npm.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/laydate/laydate.js" type="text/javascript"></script>
    <script>
        function myFunction() {
            var odiv = document.getElementById('odiv');
            var d = new Date();
            var t = d.toLocaleTimeString();
            odiv.innerText = t;
        }
        (function () {
            setInterval("myFunction()", 1);
        }());
    </script>
</head>
<body>
<div class="panel" style="width:1000px;height:auto;text-align:center;margin-left:auto;margin-right:auto;">
    <div class="panel-body" style="width:100%;height: auto;">

        <p class="panel-footer">
        <h1 class="panel-title"><%= session.getId()%></h1><br/>
        <img width="768" height="412" src="${pageContext.request.contextPath}/files/456.jpg" class="img-rounded">
        </p>

        <%--<jsp:forward page="WEB-INF/views/home.jsp" />--%>
        <a href="${pageContext.request.contextPath}/springmvc/home">home</a>
    </div>

    <div class="panel-footer" style="width:100%;height: auto;">
        正在跳转中 time:<label id="odiv"/>
    </div>

</div>
</body>
</html>
