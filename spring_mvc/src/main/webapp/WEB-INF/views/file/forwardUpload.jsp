<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 18-4-17
  Time: 上午10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
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
    <script>
        $(document).ready(function () {
            var btn = $("#Btn");
            var processForm = document.forms.namedItem("ProcessForm");
            btn.click(function () {
                var action = "${pageContext.request.contextPath}/file/upload.action";
                var file = $(":file")[0];
                var form = new FormData(action);
                form.append("file",file);
                form.append("author","zhou")
                var xhr = new XMLHttpRequest();
                xhr.open("post",action,true);
                xhr.onload(function () {
                    alert("上传完成");
                });
                //监听progress事件
                xhr.upload.addEventListener("progress", progressFunction, false);
                xhr.send(form);
            });
        });

        function progressFunction(evt) {
            var progressBar = document.getElementById("progressBar");
            var percentageDiv = document.getElementById("percentage");
            if (evt.lengthComputable) {
                progressBar.max = evt.total;
                progressBar.value = evt.loaded;
                percentageDiv.innerHTML = Math.round(evt.loaded / evt.total * 100) + "%";
                if(evt.loaded==evt.total){
                    alert("上传完成100%");
                }
            }
        }
    </script>
</head>
<body>
<div class="panel" style="text-align:center;width: 1000px;height:auto;margin-right:auto;margin-left:auto;">
    <div class="panel-body" style="width:100%;height:auto;margin-top:200px;">
        <form enctype="multipart/form-data" name="ProcessForm" method="post">
            <input type="file" name="file"><br/>
            <button id="Btn">提交</button><br/>
        </form>
    </div>
    <div class="panel-body" style="width:100%;height:auto;margin-top:200px;">
        <progress id="progressBar" value="0" max="100"></progress>
        <span id="percentage"></span>
    </div>
</div>
</body>
</html>
