<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生管理系统-修改学生</title>
    <style>
        form{
            width: 400px;
            height: 400px;
            border: 1px black solid;
            text-align: center;
            margin: auto;
        }
    </style>
</head>
<body>
<form action="studentServlet" method="post" enctype="multipart/form-data">
    <input type="hidden" name="flag" value="update">
    <input type="hidden" name="sid" value="${student.sid}">
    <h1>学生管理系统-修改学生</h1>
    姓名：<input type="text" name="sname" value="${student.sname}"><br><br>
    年龄：<input type="text" name="sage" value="${student.sage}"><br><br>
    性别：<input type="radio" name="ssex" value="男" ${student.ssex eq '男'?'checked':''}>男
    <input type="radio" name="ssex" value="女" ${student.ssex eq '女'?'checked':''}>女<br><br>
    邮箱：<input type="text" name="semail" value="${student.semail}"><br><br>
    照片：<input type="file" name="sphoto">
    <img src="http://localhost:8080/school/student/${student.sphoto}" width="80" alt="图片不存在">
    <input type="hidden" name="oldSphoto" value="${student.sphoto}"><br><br>
    <input type="submit" value="保存">
</form>
</body>
</html>
