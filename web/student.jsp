<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生管理系统-学生信息</title>
    <style>
        form{
            width: 500px;
            text-align: center;
            margin: auto;
        }
        table{
            width: 500px;
            text-align: center;
            margin: auto;
        }
        div{
            width: 500px;
            text-align: right;
            margin: auto;
        }
    </style>
    <script src="js/jquery-3.6.0.js"></script>
    <script>
        function del(sid) {
            if (confirm("您真的要删除吗？")){
                window.location.href = "studentServlet?flag=deleteStudentBySid&sid="+sid;
            }
        }

        $(function () {
            $("#checkAll").click(function () {
                var c = $("#checkAll").prop("checked");
                $(".checkOne").prop("checked",c);
            });

            $("#btn").click(function () {
                var array = [];
                $(".checkOne:checked").each(function (index,content) {
                    var sid = $(content).val();
                    array.push(sid);
                });
                if (array.length == 0){
                    alert("请选择你要删除的数据");
                }else {
                    if (confirm("你真的要删除吗？")){
                        var sids = array.join();
                        window.location.href = "studentServlet?flag=deleteAll&sids="+sids;
                    }
                }
            })
        })
    </script>
</head>
<body>
<form action="studentServlet" method="post">
    <input type="hidden" name="flag" value="getStudentBySname">
    学生姓名：<input type="text" name="sname" value="${sname}">
    <input type="submit" value="搜索">
</form>
<table border="1" cellspacing="0" cellpadding="0">
    <tr>
        <th><input type="checkbox" id="checkAll">全选</th>
        <th>学号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>邮箱</th>
        <th>照片</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach var="student" items="${studentList}">
        <tr>
            <td><input type="checkbox" class="checkOne" value="${student.sid}"></td>
            <td>${student.sid}</td>
            <td>${student.sname}</td>
            <td>${student.sage}</td>
            <td>${student.ssex}</td>
            <td>${student.semail}</td>
            <td>
                <img src="http://localhost:8080/school/student/${student.sphoto}" width="80" alt="图片损坏">
            </td>
            <td>
                <a href="studentServlet?flag=getStudentBySid&sid=${student.sid}">修改</a>
            </td>
            <td>
                <a href="javascript:del(${student.sid})">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<div>
    <input type="button" value="批量删除" id="btn">
    <a href="add.jsp">新增学生</a>
    <a href="studentServlet?flag=getStudentByPage&page=1">首页</a>
    <a href="studentServlet?flag=getStudentByPage&page=${pageUtil.prevPage}">上一页</a>
    ${pageUtil.page}/${pageUtil.countPage}
    <a href="studentServlet?flag=getStudentByPage&page=${pageUtil.nextPage}">下一页</a>
    <a href="studentServlet?flag=getStudentByPage&page=${pageUtil.countPage}">尾页</a>
</div>
</body>
</html>