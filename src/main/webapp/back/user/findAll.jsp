<%@ page isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script>
    /*创建datagrid*/
    $(function () {
       $("#user").datagrid({
           url:'${pageContext.request.contextPath}/user/findAll',
           columns:[[
               {title:'id',field:'id',width:100},
               {title:'手机号码',field:'phone',width:100},
               {title:'用户名',field:'username',width:80},
               {title:'密码',field:'password',width:80},
               {title:'加密盐',field:'salt',width:80},
               {title:'头像',field:'headPic',width:100},
               {title:'真实姓名',field:'nickName',width:80},
               {title:'性别',field:'gender',width:80},
               {title:'所在地',field:'home',width:150},
               {title:'签名',field:'sign',width:100},
               {title:'省份',field:'province',width:100},
               {title:'市区',field:'city',width:100},
               {title:'状态',field:'status',width:80},
               {title:'日期',field:'date',width:100},
           ]],
           view: detailview,
           detailFormatter: function(rowIndex, rowData){
               return '<table><tr>' +
                   '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}'+rowData.headPic+'" style="width:150;height:150px;"></td>' +
                   '<td style="border:0">' +
                   '<p>用户名: ' + rowData.username + '</p>' +
                   '<p>所在地: ' + rowData.home + '</p>' +
                   '<p>签名: ' + rowData.sign + '</p>' +
                   '</td>' +
                   '</tr></table>';
           },
           pagination:true,/*显示分页栏*/
           pageNumber:1,/*当前页*/
           pageSize:5,/*每页显示的记录数*/
           pageList:[5,10,15,30,50],/*在设置分页属性的时候初始化页面大小*/
           striped:true,/*是否显示斑马线效果*/
           rownumbers:true,
           singleSelect:false,
           ctrlSelect:true,
           remoteSort:false,
           multiSort:true,
           fit:true
       });
    });

</script>

<table id="user"></table>
<div id="uu">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-table_add',plain:true" onclick="openAddGuruDialog();">添加</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-table_delete',plain:true" onclick="deleteRow();">批量删除</a>
</div>
