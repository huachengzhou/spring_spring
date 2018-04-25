<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 18-1-27
  Time: 下午2:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>employee gedit</title>
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
</head>
<body style="margin: 0 auto;">
<div class="panel" style="margin: 0 auto;width:1200px;height: auto;">
    <form:form modelAttribute="employee" method="post" action="${pageContext.request.contextPath}/REST/updateEmployee">
        <div class="panel-body" style="margin-top: 100px;width: 100%;height: auto;text-align: center;">
            <c:if test="${employee.id==null}">
                LastName:<form:input path="lastname"/>
            </c:if>

            <c:if test="${employee.id!=null}">
                <form:hidden path="id"/>
                <input type="hidden" value="PUT" name="_method">
            </c:if>
            Email:<form:input path="email" cssClass="form-inline"/><br/>
            salary:<form:input path="salary" cssClass="form-inline"/><br/>

            gender:<form:radiobuttons path="gender" items="${genders}" cssClass="form-inline"/><br/>
            birth:<form:input path="birth" cssClass="demo-input" id="testLayDate" placeholder="请选择日期"/><br/>
            department:<form:select path="department.id" items="${departments}"
                                    itemLabel="departmentName" itemValue="id">
        </form:select>
        </div>

        <div style="width: 100%;height:100px;text-align: center;" class="panel-footer">
            <label style="float: left;margin-left: 200px;"> <a href="${pageContext.request.contextPath}/REST/emps"
                                                               class="btn btn-info">return home</a> </label><br/>
            <label style="float: right;margin-right: 200px;">
                <input type="submit" value="submit" class="btn btn-success">
            </label><br/>
        </div>
    </form:form>
</div>
</body>
</html>
