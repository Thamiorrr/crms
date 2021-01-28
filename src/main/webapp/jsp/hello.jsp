<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2021/1/26
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
     $('male').removeAttr("checked");

        $('famale').attr("checked", "checked");

</script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="radio" name="gender" value="男" checked id="male"/>
<input type="radio" name="gender" value="女" id="famale"/>

    <p>输入姓名aaaaaaa</p>
    <form method = "post",action="post.first">
        <input type = "text" name="姓名">
        <input type = "submit" value="提交">
    </form>>
    <a href="customer">Hello Servlet</a>
    <a href="customer">Hello Servlet</a>


</body>

</html>
