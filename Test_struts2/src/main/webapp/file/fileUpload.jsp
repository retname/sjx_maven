
<%--
  Created by IntelliJ IDEA.
  User: zhangyu
  Date: 2017/9/2
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>单文件上传</title>
</head>
<body>

      <s:form com.action="/file/uploadAction" enctype="multipart/form-data" method="POST">
          <s:file name="upload" label="选择文件"></s:file><br>
          <s:submit name="submit" value="文件上传"></s:submit>
      </s:form>

</body>
</html>
