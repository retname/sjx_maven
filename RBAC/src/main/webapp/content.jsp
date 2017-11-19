<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>内容发布</title>
    <link href="/static/css/bootstrap.min.css-v=3.3.5.css" type="text/css"  rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        var selected;   //当前点击的tree树
        var datagrid;   //easy  ui的datagrid
        var dataSelId;
        $(function () {
            Date.prototype.Format = function(fmt)
            {
                var o = {
                    "M+" : this.getMonth()+1,                 //月份
                    "d+" : this.getDate(),                    //日
                    "h+" : this.getHours(),                   //小时
                    "m+" : this.getMinutes(),                 //分
                    "s+" : this.getSeconds(),                 //秒
                    "q+" : Math.floor((this.getMonth()+3)/3), //季度
                    "S"  : this.getMilliseconds()             //毫秒
                };
                if(/(y+)/.test(fmt))
                    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
                for(var k in o)
                    if(new RegExp("("+ k +")").test(fmt))
                        fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
                return fmt;
            }

            $("#tt").tree({
                url: '${pageContext.request.contextPath}/getAllContent',
                animate:true,
                checkbox:false,
                cascadeCheck:false,
                loadFilter :
                    function(data) {
                        change(data);
                        return data;
                    },
                onClick:    //双击某一节点触发事件
                   function (data) {
                       $('#topsearch').show();
                       selected= $('#tt').tree('getSelected');
                       openDataGrid();
                   }
            });
            //多条件查询
            $('#selectmore').click(function () {
                $("#dataGrid").datagrid("load",{
                      "cname":$("#c_name").val(),
                      "state":$("input[name='state']:checked").val()
                })
            })
        });

        function goto(){
            var rows = $('#dataGrid').datagrid('getSelected')//获取当前页的数据行
            if(rows.state.sys_name=='发布'){
                openTab("查看发布","/addColumnDetail.jsp?id="+rows.sys_id);
            }else{
                openTab("编辑草稿","/addColumnDetail.jsp?id="+rows.sys_id);
            }



        }
        function openTab(text,url){
            if(parent.$("#tabs").tabs("exists",text)){
                parent.$("#tabs").tabs("select",text);
            }else{
                var content="<iframe frameborder=0 scrolling='scroll' style='width:100%;height:100%' src='${pageContext.request.contextPath}"+url+"'></iframe>";
                parent.$("#tabs").tabs("add",{
                    title:text,
                    closable:true,
                    content:content
                });
            }
        }
        function change(data){
            if(!data.length){
                data.text=data.c_name;
                data.id=data.c_id;
                if(data.children){
                    change(data.children);
                }
            }else{
                $.each(data,function (i,v){
                    change(v);
                });
            }
        }
        function openDataGrid() {
                datagrid= $("#dataGrid").datagrid({
                    width:"80%",
                    title:"管理员人员管理",
                    border:true,
                    locale:"zh_CN",
                    iconCls:'icon-save',
                    striped:true,
                    idField:"bid",
                    sortOrder:"desc",
                    collapsible:"false",
                    url:"/findAllNews?syscolumn="+selected.id,
                    singleSelect:true,//是否单选
                    pagination:true,//分页控件
                    pageList: [5,10],//可以设置每页记录条数的列表
                columns: [[
                    {field: 'sys_id', title: 'ID ',width:'100px', algin: 'center'},
                    {field: 'sys_title', title: '标题 ',width:'100px', align: 'center',formatter:function (value,rows,index){
                        return "<a  href='#' id='draft' onclick='goto()'>"+value+"</a> "
                    }},
                    {field: 'content', title: '栏目',width:'100px', align: 'center',formatter: function(value,row,index){return value.c_name;}},
                    {field: 'sys_weight', title: '权垂',width:'150px', align: 'center'},
                    {field: 'sys_hits', title: '点击数',width:'150px', align: 'center'},
                    {field: 'state', title: '状态',width:'150px', align: 'center',formatter: function(value,row,index){return value.sys_name;}},
                    {field: 'userInfo', title: '创建者',width:'100px', align: 'center',formatter: function(value,row,index){return value.username;}},
                    {field: 'sys_uptime', title: '更新时间',width:'120px', align: 'center',formatter: function(value,row,index){
                        return new Date(value).Format("yyyy-MM-dd hh:mm:ss");}},
                    /*{field:'field',title:'操作',width:'100px',align:'center',formatter:function (val,rows,rowIndex) {
                        return "<a href='#' onclick='comDel()'>删除</a>&nbsp;<a href='#'>编辑</a>";
                       }
                    }*/

                ]],
                    toolbar:[{
                        id: 'btnAdd',
                        text: "添加",
                        iconCls: 'icon-add',
                        handler: function () {
                            alert(1);
                            openTab("国内新增","/addColumnDetail.jsp")
                            //window.location.href="/addColumnDetail.jsp";
                        }
                    },{
                        id:'btnSearch',
                        iconCls:'icon-search',
                        text:'修改',
                        handler:function () {
                            $.messager.confirm('提示','功能暂未开通!');
                        }
                    },{
                        text: '删除',
                        iconCls: 'icon-remove',
                        handler: function () {
                            var row = $('#dataGrid').datagrid('getSelected');
                            if(row==null){
                                $.messager.confirm('提示','请选择一个条新闻!');
                                return;
                            }

                            $.ajax({
                                type:"post",
                                url:"/deleNews",
                                data:{"id":row.sys_id},
                                success:function (data) {
                                    if(data=="y"){
                                         $("#dataGrid").datagrid("load",{
                                            "cname":$("#c_name").val(),
                                             "state":$("input[name='state']:checked").val()
                                         })
                                    }
                                }
                            });

                        }
                    }],

            });

        }
        //重置方法
        function Reset() {
            $("input[name='state']").removeAttr("checked");
            $("#c_name").val("");
        }


    </script>
    <html>
    <head>
        <title>Title</title>
    </head>
<body>

<div class="easyui-layout" style="width:1500px;height:800px;">
    <div region="west" split="true" title="默认站点" style="width:150px;">
        <ul id="tt"> </ul>
    </div>


    <div id="content" region="center" title="" style="padding:5px;" >


        <div region="west" split="true" title="国内咨询">

            <%--顶部搜索框--%>
            <div style="display:none; width: 100%;height: 50px;border: 1px red solid;background-color: #FEFEFE" id="topsearch">
                <form action="" method="post" style="margin-left: 50px">
                    <div style="margin-top:10px">
                        <span style="font-size: 14px">标题：</span>
                        <input class="easyui-textbox" id="c_name"  name="c_name" style="width: 20%;height: 32px">
                        <a class="btn btn-primary btn-rounded" id="selectmore"  style="height: 32px">查询</a>
                        <a class="btn btn-default btn-rounded"  style="height: 32px " onclick="Reset()">重置</a>
                        <span style="font-size: 14px">状态：</span>
                        <c:forEach items="${allstate}" var="item">
                            <input type="radio" name="state" value="${item.sys_id}"> <span style="font-size: 14px">${item.sys_name}：</span>
                        </c:forEach>
                    </div>
                </form>
            </div>


            <%--中间数据展示--%>
            <div>
                <table  id="dataGrid" style="width: 500px"></table>
            </div>

        </div>



    </div>

</div>
</body>
</html>
