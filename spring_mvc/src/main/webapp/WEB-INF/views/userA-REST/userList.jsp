<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 18-2-2
  Time: 下午11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/components/jquery-module/jquery-mini/jquery-1.9.1.min.js" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/js/npm.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/laydate/laydate.js" type="text/javascript"></script>
    <script>
        window.onload = function () {
            (function () {
                    //192.168.1.2   localhost
                <%--var url = "http://192.168.1.2:8080/${pageContext.request.contextPath}/showUserListJSON";--%>
                var url = "http://localhost:8080/${pageContext.request.contextPath}/user/showUserListJSON.action";
                $.post(url, function (data) {
                    ajax(data);
                    console.info(data);
                    console.log(data);
                }, "json");

                function ajax(data) {
                    for (var i = 0; i < data.length; i++) {
                        var tbody = document.getElementById('tbodyUser');
                        var tr = document.createElement("tr");
                        tbody.appendChild(tr);
                        var id = document.createElement("td");
                        var username = document.createElement("td");
                        var password = document.createElement("td");
                        var name = document.createElement("td");
                        var sex = document.createElement("td");
                        var account = document.createElement("td");
                        var age = document.createElement("td");
                        var birthday = document.createElement("td");
                        var address = document.createElement("td");
                        var group = document.createElement("td");
                        var jurisdiction = document.createElement("td");
                        var permission = document.createElement("td");
                        var role = document.createElement("td");

                        tr.appendChild(id);
                        tr.appendChild(name);
                        tr.appendChild(username);
                        tr.appendChild(password);
                        tr.appendChild(birthday);
                        tr.appendChild(address);
                        tr.appendChild(sex);
                        tr.appendChild(account);
                        tr.appendChild(group);
                        tr.appendChild(jurisdiction);
                        tr.appendChild(permission);
                        tr.appendChild(role);
                        tr.appendChild(age);

                        id.appendChild(document.createTextNode(data[i].id));
                        name.appendChild(document.createTextNode(data[i].name));
                        username.appendChild(document.createTextNode(data[i].username));
                        password.appendChild(document.createTextNode(data[i].password));
                        birthday.appendChild(document.createTextNode(data[i].birthday));
                        address.appendChild(document.createTextNode(data[i].address));
                        sex.appendChild(document.createTextNode(data[i].sex));
                        account.appendChild(document.createTextNode(data[i].account));
                        group.appendChild(document.createTextNode(data[i].group));
                        age.appendChild(document.createTextNode(data[i].age));
                        jurisdiction.appendChild(document.createTextNode(data[i].jurisdiction));
                        permission.appendChild(document.createTextNode(data[i].permission));
                        role.appendChild(document.createTextNode(data[i].role));
                    }
                };
            }());
        };
    </script>
</head>
<body>
<div style="margin-left: auto;margin-right: auto;width:1200px;height: auto;">
    <div style="height: auto;width:100%;text-align: center;margin-top:50px;">
        <table class="table table-bordered" cellpadding="2" cellspacing="2">
            <caption id="titleUser" class="tab-pane" style="text-align: center;">用户信息</caption>
            <thead>
                <tr class="table-bordered">
                    <td class="tab-content">${a1}</td>
                    <td class="tab-content">${a2}</td>
                    <td class="tab-content">${a3}</td>
                    <td class="tab-content">${a4}</td>
                    <td class="tab-content">${a5}</td>
                    <td class="tab-content">${a6}</td>
                    <td class="tab-content">${a7}</td>
                    <td class="tab-content">${a8}</td>
                    <td class="tab-content">${a9}</td>
                    <td class="tab-content">${a10}</td>
                    <td class="tab-content">${a11}</td>
                    <td class="tab-content">${a12}</td>
                    <td class="tab-content">${a13}</td>
                </tr>
            </thead>
            <tbody id="tbodyUser">

            </tbody>
        </table>
        <a class="btn-block PAGEUser" href="${pageContext.request.contextPath}/user/showUserListJSON.action?page=${page+1}">下一页</a>
        <a href="${pageContext.request.contextPath}/springmvc/home" class="btn btn-info">返回Home</a>

        <c:if test="${page} > 0"></c:if>
        <a class="btn-block PAGEUserA" href="${pageContext.request.contextPath}/user/showUserListJSON.action?page=${page-1}">上一页</a>
        <form action="" method="POST"></form>
    </div>
    <script>
        var PAGEUser = $(".PAGEUser");
        PAGEUser.click(function () {
            var href = $(this).attr("href");
            $("form").attr("action",href).submit();
            return false;
        });
    </script>
</div>
</body>
</html>
