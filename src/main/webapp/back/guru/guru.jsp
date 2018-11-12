<%@ page isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script>
    /*创建datagrid*/
    $(function () {
       $("#guru").datagrid({
           url:'${pageContext.request.contextPath}/guru/findAll',
           columns:[[
               {title:'cks',field:"cks",checkbox:true},
               {title:'id',field:'id',width:150},
               {title:'上师名称',field:'name',width:150},
               {title:'上师头像',field:'headPic',width:150},
               {title:'上师性别',field:'gender',width:150},
               {title:'操作',field:'options',width:200,
                   formatter:function(value,row,index){
                       return "<a href='javascript:;' class='options' onclick=\"delRow('"+row.id+"')\" data-options=\"iconCls:'icon-table_delete',plain:true\">删除</a>&nbsp;&nbsp;" +
                           "<a href='javascript:;' class='options' onclick=\"updateRow('"+row.id+"')\" data-options=\"iconCls:'icon-table_edit',plain:true\">修改</a>";
                   }
               }
           ]],
           onLoadSuccess:function () {
               $(".options").linkbutton();
           },
            toolbar:'#gg',
           view: detailview,
           detailFormatter: function(rowIndex, rowData){
               return '<table><tr>' +
                   '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}'+rowData.headPic+'" style="width:150;height:150px;"></td>' +
                   '<td style="border:0">' +
                   '<p>上师名称: ' + rowData.name + '</p>' +
                   '<p>上师头像: ' + rowData.headPic + '</p>' +
                   '<p>上师性别: ' + rowData.gender + '</p>' +
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
//   1.添加上师信息
    function openAddGuruDialog() {
        $('#addGuruDialog').dialog({
            buttons:[{ //对话框窗口的底部按钮
                iconCls:'icon-save',
                text:'保存',
                handler:function () {
                    //保存用户信息
                    $('#addGuruForm').form('submit',{
                        url:'${pageContext.request.contextPath}/guru/file',//controller控制器的路径
                        //操作执行成功以后，响应的一定是json'格式，返回js对象
                        success:function (result) {
                            //1.提示信息
                            $.messager.show({title:'温馨提示',msg:'添加成功！'});
                            //2.关闭对话框
                            $('#addGuruDialog').dialog('close');
                            //3.刷新datagrid
                            $('#guru').datagrid('reload');
                        }
                    });
                }
            },{
                iconCls:'icon-cancel',
                text:'关闭',
                handler:function () {
                    //2.关闭对话框
                    $('#addGuruDialog').dialog('close');
                }
            }]
        });
    }
//   2.根据id删除一行上师信息
    function delRow(id){
        //获取当前点击id发送ajax请求删除id这个人的信息
        $.post("${pageContext.request.contextPath}/guru/delete",{"id":id},function (result) {//响应成功之后回调
            //刷新datagrid数据
            $("#guru").datagrid('reload');//刷新当前datagrid
        });
    }
//    3.删除多条上师信息
    function deleteRow() {
        var rows = $("#guru").datagrid('getSelections');
        if(rows.length<=0){
            $.messager.show({title:'提示信息',msg:'请选择'});
        }else{
            var ids = [];
            for (var i = 0; i <rows.length ; i++) {
                console.log(rows[i].id);
                ids.push(rows[i].id);
            }
            console.log(ids);
            //发送ajax请求
            $.ajax({
                url:"${pageContext.request.contextPath}/guru/deleteAll",
                type:"POST",
                traditional:true,//传递数据类型的数据时必须设置这个属性为true
                data:{ids:ids},
                success:function(result){
                    //消息提示
                    $.messager.show({title:'提示',msg:"删除成功!!!"});
                    //刷新datagrid
                    $("#guru").datagrid('reload');
                },
                error:function(){
                    //消息提示
                    $.messager.show({title:'提示',msg:"删除失败!!!"});
                    //刷新datagrid
                    $("#guru").datagrid('reload');
                }
            })
        }
    }
    function delAll() {
        var rows = $("#gg").datagrid('getSelections');
        if(rows.length<=0){
            $.messager.show({title:'提示消息',msg:'请选择要删除的数据'});
        }else{
            var ids=[];
            for (var i = 0; i < rows.length ; i++) {
                ids.push(rows[i].id);
            }
            $.ajax({
                url:'${pageContext.request.contextPath}/guru/delAll',
                type:'post',
                traditional:true,
                data:{ids:ids},
                success:function(result){
                    //消息提示
                    $.messager.show({title:'提示消息',msg:'删除成功'});
                    //刷新页面‘
                    $("#guru").datagrid('reload');
                },
                error:function(){
                    //消息提示
                    $.messager.show({title:'提示消息',msg:'删除失败'});
                    //刷新datagrid
                    $("#guru").datagrid('reload');
                }
            })
        }
    }
//    4.修改上师信息
    function updateRow(id) {
        $('#updateGuruDialog').dialog({
            href:'${pageContext.request.contextPath}/back/guru/update.jsp?id='+id,
            buttons:[
                {
                    iconCls:'icon-bullet_tick',
                    text:'修改',
                    handler:function () {
                        $('#updateGuruForm').form('submit',{
                            url:'${pageContext.request.contextPath}/guru/update',
                            success:function (result) {
                                //1.提示信息
                                $.messager.show({title:'温馨提示',msg:'修改成功！'});
                                //2.关闭对话框
                                $('#updateGuruDialog').dialog('close');
                                //3.刷新datagrid
                                $('#guru').datagrid('reload');
                            }
                        })
                    }
                },
                {
                    iconCls:'icon-cancel',
                    text:'取消',
                    handler:function(){
                        //2.关闭对话框
                        $('#updateGuruDialog').dialog('close');
                    }

                }
            ]
        });
    }

</script>

<table id="guru"></table>
<div id="gg">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-table_add',plain:true" onclick="openAddGuruDialog();">添加</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-table_delete',plain:true" onclick="deleteRow();">批量删除</a>
</div>
<%--修改数据的对话框--%>
<div id="updateGuruDialog" data-options="width:400,height:300,title:'修改轮播图信息'"></div>
<%--添加数据的对话框--%>
<div id="addGuruDialog" data-options="width:400,height:300,title:'添加上师信息',href:'${pageContext.request.contextPath}/back/guru/add.jsp'"></div>