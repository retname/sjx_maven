<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="false" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
     <title>处理结果</title>
     <head>

         <script type="text/javascript" src="/jsp/js/jquery.min.js"></script>
         <script type="text/javascript">

             function exit() {
                 window.location.href="/exit"
             }
             
             function goon() {
                 window.location.href="/goon";
             }

         </script>

     </head>

<body style="width: 100%;">


        <h3 style="margin-left: 45%">转账成功！</h3>
        <div id="logindiv" style="margin-left: 40%">
            <input type="button" value="继续操作" onclick="goon()" style="margin-left: 8%">
            <input type="button" value="退出登陆" onclick="exit()" style="margin-left: 8%">
        </div>

</body>
</html>
