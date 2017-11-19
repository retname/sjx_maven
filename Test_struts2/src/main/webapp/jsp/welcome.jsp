<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangyu
  Date: 2017/9/2
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>


欢迎 界面！！！<s:property value="#request.session.username"></s:property>

              <s:property value="username"></s:property>

<s:debug></s:debug>

</body>
</html>
