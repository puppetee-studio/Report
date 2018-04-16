<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% pageContext.setAttribute("ctx", request.getContextPath());%>
<html>
<head>
    <title>管理系统</title>
</head>
<body>

首页

<form action="${ctx}/upload/file" method="post" enctype="multipart/form-data">

    <input type="text" id="fileName" name="fileName"/>
    <input type="file" name="file" id="file"/>
    <input type="submit" value="upload">

</form>

</body>
</html>
