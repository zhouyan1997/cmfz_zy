<%@ page isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script>
    /*创建datagrid*/
    $(function () {
       $("#ban").datagrid({
           url:'${pageContext.request.contextPath}/ban/findAll',
           columns:[[
               {title:'cks',field:"cks",checkbox:true},
               {title:'id',field:'id',width:150},
               {title:'名字',field:'title',width:150},
               {title:'图片路径',field:'imgPath',width:150},
               {title:'描述',field:'decs',width:150},
               {title:'状态',field:'status',width:150},
               {title:'时间',field:'date',width:150,sortable:true},
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
            toolbar:'#mm',
           view: detailview,
           detailFormatter: function(rowIndex, rowData){
               return '<table><tr>' +
                   '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}'+rowData.imgPath+'" style="width:150;height:150px;"></td>' +
                   '<td style="border:0">' +
                   '<p>主题: ' + rowData.title + '</p>' +
                   '<p>图片路径: ' + rowData.imgPath + '</p>' +
                   '<p>描述: ' + rowData.decs + '</p>' +
                   '<p>状态: ' + rowData.status + '</p>' +
                   '<p>时间: ' + rowData.date + '</p>' +
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
    //添加新的数据
    function openAddBannerDialog() {
        $('#addBannerDialog').dialog({
            buttons:[{ //对话框窗口的底部按钮
                iconCls:'icon-save',
                text:'保存',
                handler:function () {
                    //保存用户信息
                    $('#addBannerForm').form('submit',{
                        url:'${pageContext.request.contextPath}/ban/file',//controller控制器的路径
                        //操作执行成功以后，响应的一定是json'格式，返回js对象
                        success:function (result) {
                            //1.提示信息
                            $.messager.show({title:'温馨提示',msg:'添加成功！'});
                            //2.关闭对话框
                            $('#addBannerDialog').dialog('close');
                            //3.刷新datagrid
                            $('#ban').datagrid('reload');
                        }
                    });
                }
            },{
                iconCls:'icon-cancel',
                text:'关闭',
                handler:function () {
                    //2.关闭对话框
                    $('#addBannerDialog').dialog('close');
                }
            }]
        });
    }
    /*删除一行的事件*/
    function delRow(id){
        //获取当前点击id发送ajax请求删除id这个人的信息
        $.post("${pageContext.request.contextPath}/ban/delete",{"id":id},function (result) {//响应成功之后回调
            //刷新datagrid数据
            $("#ban").datagrid('reload');//刷新当前datagrid
        });
    }
    /*修改表信息*/
    function updateRow(id) {
        $('#updateBannerDialog').dialog({
            href:'${pageContext.request.contextPath}/back/banner/update.jsp?id='+id,
            buttons:[
                {
                    iconCls:'icon-bullet_tick',
                    text:'修改',
                    handler:function () {
                        $('#updateBannerForm').form('submit',{
                            url:'${pageContext.request.contextPath}/ban/update',
                            success:function (result) {
                                //1.提示信息
                                $.messager.show({title:'温馨提示',msg:'修改成功！'});
                                //2.关闭对话框
                                $('#updateBannerDialog').dialog('close');
                                //3.刷新datagrid
                                $('#ban').datagrid('reload');
                            }
                        })
                    }
                },
                {
                    iconCls:'icon-cancel',
                    text:'取消',
                    handler:function(){
                        //2.关闭对话框
                        $('#updateBannerDialog').dialog('close');
                    }

                }
            ]
        });
    }
    /*删除多行数据*/
    function deleteRow() {
        var rows = $("#ban").datagrid('getSelections');
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
                url:"${pageContext.request.contextPath}/ban/deleteAll",
                type:"POST",
                traditional:true,//传递数据类型的数据时必须设置这个属性为true
                data:{ids:ids},
                success:function(result){
                    //消息提示
                    $.messager.show({title:'提示',msg:"删除成功!!!"});
                    //刷新datagrid
                    $("#ban").datagrid('reload');
                },
                error:function(){
                    //消息提示
                    $.messager.show({title:'提示',msg:"删除失败!!!"});
                    //刷新datagrid
                    $("#dg").datagrid('reload');
                }
            })
        }
    }
    function delAll() {
        var rows = $("#mm").datagrid('getSelections');
        if(rows.length<=0){
            $.messager.show({title:'提示消息',msg:'请选择要删除的数据'});
        }else{
            var ids=[];
            for (var i = 0; i < rows.length ; i++) {
                ids.push(rows[i].id);
            }
            $.ajax({
                url:'${pageContext.request.contextPath}/ban/delAll',
                type:'post',
                traditional:true,
                data:{ids:ids},
                success:function(result){
                    //消息提示
                    $.messager.show({title:'提示消息',msg:'删除成功'});
                    //刷新页面‘
                    $("#ban").datagrid('reload');
                },
                error:function(){
                    //消息提示
                    $.messager.show({title:'提示消息',msg:'删除失败'});
                    //刷新datagrid
                    $("#ban").datagrid('reload');
                }
            })
        }
    }
</script>

<table id="ban"></table>
<div id="mm">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-table_add',plain:true" onclick="openAddBannerDialog();">添加</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-table_delete',plain:true" onclick="deleteRow();">批量删除</a>
</div>
<%--修改数据的对话框--%>
<div id="updateBannerDialog" data-options="width:400,height:300,title:'修改轮播图信息'"></div>
<%--添加数据的对话框--%>
<div id="addBannerDialog" data-options="width:400,height:300,title:'添加轮播图信息',href:'${pageContext.request.contextPath}/back/banner/add.jsp'"></div>