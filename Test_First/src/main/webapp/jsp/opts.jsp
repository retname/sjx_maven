<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="false" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
     <title>sdfaf</title>
     <head>


         <script type="text/javascript" src="/jsp/js/jquery.min.js"></script>
         <script type="text/javascript">

            function vote() {
                var val=$('input:radio[name="opt"]:checked').val();
                var id =$('input:text').val();
                alert(id);
                if(val==null){
                    alert("请选择投票！")
                    return;
                }
                window.location.href="/doVote?id="+id+"&optid="+val;
            }

         </script>
     </head>

<body style="width: 100%;">

    <div id="mydiv" style="margin-left: 45%">
        <input type="text" value="${subject.id}" style="display: none">
        <h4>${subject.title}</h4>
        <h5>${subject.viewTimes}次查看，共有${subject.totalVotes}人投票</h5>
        <table>
            <c:forEach items="${opts}" var="item">
                <tr>
                    <td><input type="radio" name="opt" value="${item.id}">${item.optContent}</td>
                    <td>${item.vote}票</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <input type="button" value="我要投票" onclick="vote()">&nbsp;<a href="backone">返回首页</a>

   </div>




</body>
</html>
