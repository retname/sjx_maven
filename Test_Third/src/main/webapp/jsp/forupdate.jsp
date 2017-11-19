<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="false" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
     <title>处理结果</title>
     <head>

         <script type="text/javascript" src="/jsp/js/jquery.min.js"></script>
         <script type="text/javascript">

         </script>
         <style type="text/css">

         </style>

     </head>

<body style="width: 100%;">


        <h3 style="margin-left: 45%">项目信息维护</h3>
        <div id="logindiv" style="margin-left: 40%">
            <form com.action="/doUpdate" method="post">
                <table>
                    <input type="text" name="itemid" value="${peitems.itemid}" style="display:none;">
                    <tr><td>项目名称：<input type="text" name="itemname" value="${peitems.itemname}"></td></tr>
                    <tr><td>所属类别：<select id="itemtypes" name="myselect">
                                     <c:forEach items="${itemtypes}" var="item">
                                         <option value="${item.typeid}">${item.typename}</option>
                                     </c:forEach>
                                 </select></td> </tr>
                    <tr><td>是否必查：<input type="checkbox" name="necessary" value="${peitems.necessary}"></td> </tr>
                    <tr><td>参考__值：<input type="text" name="ref" value="${peitems.ref}"></td> </tr>
                    <tr><td>价____格：<input type="text" name="price" value="${peitems.price}"></td> </tr>
                    <tr><td>说____明: <textarea name="info" id="mytextarea" coles="20" rows="2">${peitems.info}</textarea></td> </tr>
                    <tr><td><input type="submit" value="修改"> &nbsp;<input type="reset" value="重置"> &nbsp;<input type="button" value="取消"></td> </tr>

                </table>

            </form>

        </div>

</body>
</html>
