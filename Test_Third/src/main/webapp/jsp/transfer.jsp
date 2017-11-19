<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="false" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
     <title>转账界面</title>
     <head>


     </head>

<body style="width: 100%;">

        <h3 style="margin-left: 45%">转账操作</h3>
        <span style="margin-left: 45%">${error}</span>
        <div id="logindiv" style="margin-left: 40%">
            <form com.action="/transfer.do" method="post" style="margin-left: 2%">
                 转入账户：<input type="text" name="card" value="${card}"><br>
                 <div style="height: 10px"></div>
                 转账金额：<input type="text" name="balance" ><br>
                <div style="height: 10px"></div>
                <input type="submit" value="确认转账" style="margin-left: 8%">
            </form>
        </div>


</body>
</html>
