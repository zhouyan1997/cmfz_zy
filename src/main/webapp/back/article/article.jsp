<%@ page isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script>
    /*创建datagrid*/
    $(function () {
       $("#article").datagrid({
           url:'${pageContext.request.contextPath}/article/findAll',
           columns:[[
               {title:'cks',field:"cks",checkbox:true},
               {title:'id',field:'id',width:100},
               {title:'文章主题',field:'title',width:100},
               {title:'文章图片',field:'imgPath',width:150},
               {title:'文章内容',field:'content',width:150},
               {title:'发布日期',field:'publishDate',width:100},
               {title:'上师',field:'guru_id',width:100},
               {title:'状态',field:'status',width:100},
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
            toolbar:'#aa',
           view: detailview,
           detailFormatter: function(rowIndex, rowData){
               return '<table><tr>' +
                   '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}'+rowData.imgPath+'" style="width:150;height:150px;"></td>' +
                   '<td style="border:0">' +
                   '<p>文章主题: ' + rowData.title + '</p>' +
                   '<p>文章图片: ' + rowData.imgPath + '</p>' +
                   '<p>发布日期: ' + rowData.publishDate + '</p>' +
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
//   1.添加文章信息
    function openAddArticleDialog() {
        $('#addArticleDialog').dialog({
            buttons:[{ //对话框窗口的底部按钮
                iconCls:'icon-save',
                text:'保存',
                handler:function () {
                    //保存用户信息
                    $('#addArticleForm').form('submit',{
                        url:'${pageContext.request.contextPath}/article/file',//controller控制器的路径
                        //操作执行成功以后，响应的一定是json'格式，返回js对象
                        success:function (result) {
                            //1.提示信息
                            $.messager.show({title:'温馨提示',msg:'添加成功！'});
                            //2.关闭对话框
                            $('#addArticleDialog').dialog('close');
                            //3.刷新datagrid
                            $('#article').datagrid('reload');
                        }
                    });
                }
            },{
                iconCls:'icon-cancel',
                text:'关闭',
                handler:function () {
                    //2.关闭对话框
                    $('#addArticleDialog').dialog('close');
                }
            }]
        });
    }
//   2.根据id删除文章信息
    function delRow(id){
        //获取当前点击id发送ajax请求删除id这个人的信息
        $.post("${pageContext.request.contextPath}/article/delete",{"id":id},function (result) {//响应成功之后回调
            //刷新datagrid数据
            $("#article").datagrid('reload');//刷新当前datagrid
        });
    }
//    3.删除多条上师信息
    function deleteRow() {
        var rows = $("#article").datagrid('getSelections');
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
                url:"${pageContext.request.contextPath}/article/deleteAll",
                type:"POST",
                traditional:true,//传递数据类型的数据时必须设置这个属性为true
                data:{ids:ids},
                success:function(result){
                    //消息提示
                    $.messager.show({title:'提示',msg:"删除成功!!!"});
                    //刷新datagrid
                    $("#article").datagrid('reload');
                },
                error:function(){
                    //消息提示
                    $.messager.show({title:'提示',msg:"删除失败!!!"});
                    //刷新datagrid
                    $("#article").datagrid('reload');
                }
            })
        }
    }
    function delAll() {
        var rows = $("#aa").datagrid('getSelections');
        if(rows.length<=0){
            $.messager.show({title:'提示消息',msg:'请选择要删除的数据'});
        }else{
            var ids=[];
            for (var i = 0; i < rows.length ; i++) {
                ids.push(rows[i].id);
            }
            $.ajax({
                url:'${pageContext.request.contextPath}/article/delAll',
                type:'post',
                traditional:true,
                data:{ids:ids},
                success:function(result){
                    //消息提示
                    $.messager.show({title:'提示消息',msg:'删除成功'});
                    //刷新页面‘
                    $("#article").datagrid('reload');
                },
                error:function(){
                    //消息提示
                    $.messager.show({title:'提示消息',msg:'删除失败'});
                    //刷新datagrid
                    $("#article").datagrid('reload');
                }
            })
        }
    }
//    4.修改文章信息
    function updateRow(id) {
        $('#updateArticleDialog').dialog({
            href:'${pageContext.request.contextPath}/back/article/update.jsp?id='+id,
            buttons:[
                {
                    iconCls:'icon-bullet_tick',
                    text:'修改',
                    handler:function () {
                        $('#updateArticleForm').form('submit',{
                            url:'${pageContext.request.contextPath}/article/update',
                            success:function (result) {
                                //1.提示信息
                                $.messager.show({title:'温馨提示',msg:'修改成功！'});
                                //2.关闭对话框
                                $('#updateArticleDialog').dialog('close');
                                //3.刷新datagrid
                                $('#article').datagrid('reload');
                            }
                        })
                    }
                },
                {
                    iconCls:'icon-cancel',
                    text:'取消',
                    handler:function(){
                        //2.关闭对话框
                        $('#updateArticleDialog').dialog('close');
                    }

                }
            ]
        });
    }

</script>
<table id="article"></table>
<div id="aa">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-table_add',plain:true" onclick="openAddArticleDialog();">添加</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-table_delete',plain:true" onclick="deleteRow();">批量删除</a>
</div>
<%--修改数据的对话框--%>
<div id="updateArticleDialog" data-options="width:400,height:300,title:'修改文章信息'"></div>
<%--添加数据的对话框--%>
<div id="addArticleDialog" data-options="width:400,height:300,title:'添加文章信息',href:'${pageContext.request.contextPath}/back/article/add.jsp'"></div>