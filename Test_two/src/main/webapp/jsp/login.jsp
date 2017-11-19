<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="false" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
     <title>登陆界面</title>
     <head>


     </head>

<body style="width: 100%;">

        <h3 style="margin-left: 45%">系统登录</h3>
        <span style="margin-left: 45%">${error}</span>
        <div id="logindiv" style="margin-left: 40%">
            <form com.action="/islogin" method="post" style="margin-left: 2%">
                 账号：<input type="text" name="account_number" ><br>
                 <div style="height: 10px"></div>
                 密码：<input type="password" name="password" ><br>
                <div style="height: 10px"></div>
                <input type="submit" value="提交" style="margin-left: 8%">&nbsp;<input type="reset" value="重置">
            </form>
        </div>


</body>
</html>
