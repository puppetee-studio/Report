<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

登录 注册

<form action="${pageContext.request.contextPath}/login/login" method="post">

    <input id="username" name="username" placeholder="username">
    <input id="pwd" name="pwd" placeholder="password">
    <input type="submit" value="登录">

</form>

</body>

<script type="text/javascript">

</script>

</html>
