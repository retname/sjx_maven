<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

<%@taglib uri="http://www.springsecurity.org/jsp" prefix="security"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增文章</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript" src="/static/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="/static/ueditor/ueditor.all.js"></script>
    <link rel="stylesheet" href="/static/ueditor/themes/default/css/ueditor.css">
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8"
            src="/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript">
    $(function () {
        var editor=UE.getEditor("sys_content");
        if($("#myp").text()!=null&&$("#myp").text()!=""){
            $.ajax({
                url:"/getid",
                data:{"id":$("#myp").text()},
                success:function (data) {
                    if(data.sys_state==0){
                            $("#addnews").hide();
                            $("#publish").show();

                        $("#column2").text(data.sys_column);
                        $("#title2").text(data.sys_title);
                        $("#color2").text(data.sys_color);
                        $("#digest2").text(data.sys_digest);
                        $("#weight2").text(data.sys_weight);
                        $("#keywords2").text(data.sys_keywords);
                        $("#content2").text(data.sys_content);
                       /* $("#file2").src("E://zy//sjx_maven//RBAC//target//RBAC-1.0-SNAPSHOT//static//images");*/
                    }
                    editor.ready(function () {
                        editor.setContent(data.sys_content);
                    });
                    $("#sys_id").val(data.sys_id);
                    $("#mycolumn").combobox("setValue",data.sys_column);
                    $("#title").val(data.sys_title);
                    $("#sys_color").val(data.sys_color);
                    $("#sys_digest").val(data.sys_digest);
                    $("#sysweight").numberbox("setValue",data.sys_weight);
                    $("#e").val(data.sys_keywords);
                }
            })
        }


        UE.getEditor("sys_content");
        //填充下拉框
        $('#mycolumn').combobox({
            url:'/getContentForCMB',
            editable:false,
            valueField:'c_id',
            textField:'c_name'
        });

        $("#sysweight").onChange(function () {   //检验输入的权重数是否是数字
            alert(isNaN($("#sysweight").val()));
            if(isNaN($("#sysweight").val())){
                $("#sysweight").clear();
            }
        });



    })
    

    //暂存草稿
    function Temporarydraft() {
            if($("#e").val()==""||$("#mycolumn").combobox("getValue")=="请选择"||$("#sys_color").val()==""||$("#sys_digest").val()==""||$("#title").val()==""||$("#fileImport").val()==""){
                 alert("请输入必填项！！");
                 return;
            }else{
                $("#sys_state").val(5);
                $("#myfm").submit();
            }

    }
    
    function PutOut() {
        if($("#e").val()==""||$("#mycolumn").combobox("getValue")=="请选择"||$("#sys_color").val()==""||$("#sys_digest").val()==""||$("#title").val()==""||$("#fileImport").val()==""){
            alert("请输入必填项！！");
            return;
        }else{
            $("#sys_state").val(0);
            $("#myfm").submit();
        }
        
    }


</script>
</head>
<body style="margin: 1px">

<div class="easyui-layout" id="addnews" style="width:1400px;border: 1px red solid">
    <p id="myp" style="display: none">${param.id}</p>
    <form id="myfm" method="post"  action="/doAddNews"  enctype="multipart/form-data">
        <input type="text" name="sys_id" id="sys_id" style="display: none">
        <table cellpadding="6px" align="center">
            <tr >
                基本信息<hr>
            </tr>
            <tr>
                <td>所属栏目：</td>
                <td>
                    <select class="easyui-combobox" name="sys_column" style="width:200px;" id="mycolumn">
                        <option>请选择</option>
                    </select>
                    <a class="easyui-linkbutton" plain="true" icon="icon-ok"></a>
                </td>
            </tr>
            <tr>
                <td>文章标题：</td>
                <td>
                    <input  type="text" id="title" name="sys_title"   required="true" style="width: 200px"/>
                    <input  type="text" id="sys_state" name="sys_state"   style="width: 200px;display: none"/>
                    <%--  <input  id="title" name="sys_title" class="easyui-textbox" required="true" style="width: 200px"/>--%>
                </td>
                <td>权重/排序：</td>
                <td><input class="easyui-numberspinner"  id="sysweight" name="sys_weight" value="0" data-options="increment:1" min="0" style="width:120px;"></input>
                    <%--<input type="text" name="sys_weight" style="width: 80px">置顶：<input type="radio" name="zhiding">--%></td>
            </tr>
            <tr>
                <td>标题颜色：</td>
                <td>
                    <input  type="text" id="sys_color" name="sys_color"   required="true" style="width: 200px"/>
                   <%-- <input  id="vv" name="sys_color" class="easyui-textbox" required="true" style="width: 200px"/>--%>
                </td>
            </tr>
            <tr>
                <td> 文章图片：</td>
                <td>
                    <input  type="file"  id="fileImport" name="fileUp" style="width:260px;">
                </td>

                <td>关键词：</td>
                <td>
                    <input  type="text" id="e"  name="sys_keywords"  required="true" style="width: 200px"/>
                </td>
            </tr>

            <tr>
                <td>摘要：</td>
                <td><textarea id="sys_digest"  id="container1" name="sys_digest"
                              style="width: 800px;  margin: 0 auto;"></textarea></td>
            </tr>

            <tr>
                <td>内容：</td>
                <td><textarea id="sys_content" class="container2" id="container2" name="sys_content"
                              style="width: 800px; height: 200px; margin: 0 auto;"></textarea></td>
            </tr>
            <tr>
                <td></td>
                <td>
                   <%-- <input  type="submit" value="暂存草稿">--%>
                    <a href="javascript:Temporarydraft()" class="easyui-linkbutton" iconCls="icon-submit">暂存草稿</a>&nbsp;
                    <a href="javascript:PutOut()" class="easyui-linkbutton" iconCls="icon-submit">发布</a>
                    <a href="javascript:resetValue()" class="easyui-linkbutton" iconCls="icon-reset">关闭</a>
                </td>
            </tr>
        </table>
    </form>


</div>



<div class="easyui-layout" id="publish"style="width:1400px;border: 1px red solid;display: none">


    <table cellpadding="6px" align="center">
        <tr >
            新闻详情<hr>
        </tr>
        <tr>
            <td>所属栏目：</td>
            <td>
                <p id="column2"></p>
            </td>
        </tr>
        <tr>
            <td>文章标题：</td>
            <td>
                <p id="title2"></p>
                <%--  <input  id="title" name="sys_title" class="easyui-textbox" required="true" style="width: 200px"/>--%>
            </td>
            <td>权重/排序：</td>
            <td><p id="weight2"></p></td>
        </tr>
        <tr>
            <td>标题颜色：</td>
            <td>
               <p id="color2"></p>
            </td>
        </tr>
        <tr>
            <td> 文章图片：</td>
            <td>
                <img src="" id="file2" alt="默认图片"/>
            </td>

            <td>关键词：</td>
            <td>
               <p id="keywords2"></p>
            </td>
        </tr>

        <tr>
            <td>摘要：</td>
            <td><p id="digest2"></p></td>
        </tr>

        <tr>
            <td>内容：</td>
            <td><p id="content2"></p></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <a href="javascript:resetValue()" class="easyui-linkbutton" iconCls="icon-reset">返回</a>
            </td>
        </tr>
    </table>


</div>




</body>



</html>