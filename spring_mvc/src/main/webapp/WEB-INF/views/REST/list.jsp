<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>employee list</title>

    <script src="${pageContext.request.contextPath}/components/jquery-module/jquery-mini/jquery-1.9.1.min.js" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/js/npm.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/laydate/laydate.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            $(".DELETE").click(function () {//相当于使用表单提交 get转换为post(当然相应的参数也被一同转了)
                var href = $(this).attr("href");
                $("form").attr("action",href).submit();
                return false;
            });
        });

    </script>
</head>
<body style="margin: 0 auto;">
<form action="" method="post" name="formDELETEA">
    <input type="hidden" name="_method" value="DELETE">
</form>
<div class="panel-body" style="margin-top: 80px;text-align: center;">
    <form action="" method="POST">
        <input type="hidden" name="_method" value="DELETE"/>
    </form>

    <c:if test="${empty requestScope.employees }">
        没有任何员工信息.
    </c:if>
    <c:if test="${!empty requestScope.employees }">
        <table border="1" cellpadding="10" cellspacing="0" class="table">
            <tr class="tab-pane">
                <th class="tab-content">ID</th>
                <th class="tab-content">LastName</th>
                <th class="tab-content">Email</th>
                <th class="tab-content">Gender</th>
                <th class="tab-content">Department</th>
                <th class="tab-content">Edit</th>
                <th class="tab-content">Delete</th>
            </tr>

            <c:forEach items="${requestScope.employees }" var="emp">
                <tr class="table-bordered">
                    <td class="tab-content">${emp.id }</td>
                    <td class="tab-content">${emp.lastName }</td>
                    <td class="tab-content">${emp.email }</td>
                    <td class="tab-content">${emp.gender == 0 ? 'Female' : 'Male' }</td>
                    <td class="tab-content">${emp.department.departmentName }</td>
                    <td class="tab-content"><a href="${pageContext.request.contextPath}/REST/emp/${emp.id}">Edit</a></td>
                    <td class="tab-content"><a class="DELETE" href="${pageContext.request.contextPath}/REST/removeEmp/${emp.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <br><br>

    <a href="${pageContext.request.contextPath}/REST/emp" class="btn btn-info">Add New Employee</a>
    <a href="${pageContext.request.contextPath}/springmvc/home" class="btn btn-info">返回Home</a>
</div>

</body>
</html>