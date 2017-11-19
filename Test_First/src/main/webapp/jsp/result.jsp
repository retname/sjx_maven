<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="false" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
     <title>sdfaf</title>
     <head>


         <script type="text/javascript" src="/jsp/js/jquery.min.js"></script>
         <script type="text/javascript">
         </script>
     </head>

<body style="width: 100%;">

    <div id="mydiv" style="margin-left: 45%">

        <h4>完成投票：${subject.title}</h4>
        <h5>${subject.viewTimes}次查看，共有${subject.totalVotes}人投票</h5>
        <table>
            <c:forEach items="${opts}" var="item">
                <tr>
                    <td>${item.optContent}</td>
                    <td>${item.vote}票${(item.vote/subject.totalVotes*1.0*100)}%</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="backone">返回首页</a>

   </div>




</body>
</html>
