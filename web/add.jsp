<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生管理系统-新增学生</title>
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
    <input type="hidden" name="flag" value="insert">
    <h1>学生管理系统-新增学生</h1>
    姓名：<input type="text" name="sname"><br><br>
    年龄：<input type="text" name="sage"><br><br>
    性别：<input type="radio" name="ssex" value="男">男
    <input type="radio" name="ssex" value="女">女<br><br>
    邮箱：<input type="text" name="semail"><br><br>
    照片：<input type="file" name="sphoto"><br><br>
    <input type="submit" value="保存">
</form>
</body>
</html>
