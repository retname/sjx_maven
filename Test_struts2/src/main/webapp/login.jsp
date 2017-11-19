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
    <title>ognl</title>
</head>
<body>

   <s:form com.action="userAction" method="POST">
       <s:textfield  name="username"></s:textfield> <br/>
       <s:submit value="提交"></s:submit>
   </s:form>
</body>
</html>
