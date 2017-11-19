<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="false" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
     <title>体检项目查询</title>
     <head>
         <script type="text/javascript" src="/jsp/js/jquery.min.js"></script>
         <script type="text/javascript">
             $('#subjects tr:even').css("backgroundColor","#888");
             $('#subjects tr:odd').css("backgroundColor","#FFFFCC");
         </script>
     </head>
<body style="width: 100%;">
        <h3 style="margin-left: 45%">体检项目查询</h3>
        <div id="logindiv" style="margin-left: 40%">
            <form com.action="/getAllPeitems" method="post" style="margin-left: 4%">
                <select id="myselect" name="myselect">
                    <option>--请选择项目类型--</option>
                    <c:forEach items="${itemtypes}" var="item">
                        <option id="${item.typeid}" value="${item.typeid}">${item.typename}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="查询" style="margin-left: 4%">
            </form>

            <div>
                <table id="subjects" style="border: solid azure">
                    <tr>
                        <td>项目名称</td>
                        <td>所属类别</td>
                        <td>是否必查</td>
                        <td>参考值</td>
                        <td>价格</td>
                        <td>说明</td>
                        <td>操作</td>
                    </tr>
                   <c:forEach items="${allpeitems}" var="item">
                        <tr>
                            <td>${item.itemname}</td>
                            <td>${selected.typename}</td>
                            <td><c:if test="${item.necessary==1}">是</c:if><c:if test="${item.necessary==0}">否</c:if></td>
                            <td>${item.ref}</td>
                            <td>${item.price}</td>
                            <td>${item.info}</td>
                            <td><a href="/forupdate?typeid=${item.itemid}">修改</a> </td>
                        </tr>
                    </c:forEach>
                </table>


            </div>
        </div>


</body>
</html>
