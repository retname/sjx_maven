<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="false" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
     <title>全部主题</title>
     <head>

         <style type="text/css">
               td{text-align: center;border: solid azure 1px}
         </style>
         <script type="text/javascript" src="/jsp/js/jquery.min.js"></script>
         <script type="text/javascript">

           $(function () {
               $.ajax({
                   type:"post",
                   url:"/findAllSubjects.do",
                   success:function (data) {
                       $.each(data,function (i,dom) {
                           $("#subjects").append(
                               "<tr>"+
                               "<td>"+dom.id+"</td>"+
                               "<td><a href='findAllOpts?id="+dom.id+"+'>"+dom.title+"</a></td>"+
                               "<td>"+dom.totalVotes+'/'+dom.viewTimes+"</td>"+
                               "<td>"+new Date(dom.createDate)+"</td>"+
                               "</tr>"

                           )
                           $('#subjects tr:even').css("backgroundColor","#888");
                           $('#subjects tr:odd').css("backgroundColor","#FFFFCC");
                       })
                   }
               })

           })



         </script>
     </head>

<body style="width: 100%;">

   <div id="mydiv" style="margin-left: 45%">
       <h2>全部主题》》</h2>
   </div>

   <div>
       <table id="subjects"  style="border: solid azure 1px;margin-left:40%">
           <tr>
               <td>序号</td>
               <td>主题</td>
               <td>投票/查看</td>
               <td>创建时间</td>
           </tr>
         <%--  <c:forEach items="${subs}" var="item">
               <tr>
                   <td>${item.id}</td>
                   <td>${item.title}</td>
                   <td>${item.totalVotes}/${item.viewTimes}</td>
                   <td>${item.createDate}</td>
                   <td></td>
               </tr>
           </c:forEach>--%>
       </table>
   </div>



</body>
</html>
