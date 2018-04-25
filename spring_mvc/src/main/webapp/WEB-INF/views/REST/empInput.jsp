<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 18-1-25
  Time: 下午4:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>empInput</title>
    <script src="${pageContext.request.contextPath}/components/jquery-module/jquery-mini/jquery-1.9.1.min.js" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/js/npm.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/laydate/laydate.js" type="text/javascript"></script>
</head>
<body style="margin: 0 auto">
<div class="panel" style="text-align: center;">
    <h2 class="panel-title" style="margin-top: 80px;"><label>Add Employee</label></h2><br/>
    <div class="panel-body">

        <form:form commandName="employee" cssClass="form-group" action="${pageContext.request.contextPath}/REST/saveEmp" method="post">

            lastName:<form:input path="lastName" cssClass="form-control"/><br/>

            email:<form:input path="email" cssClass="form-control"/><br/>

            gender:<form:radiobuttons path="gender" items="${genders}" cssClass="form-inline"/><br/>

            department:<form:select path="department.id" items="${departments}" itemLabel="departmentName" itemValue="id" cssClass="form-inline"/><br/>

            <input type="submit" value="submit" class="btn"><br/>
        </form:form>

        <a href="${pageContext.request.contextPath}/REST/emps" class="btn btn-info">return home</a> <br/>
    </div>
</div>
</body>
</html>
