<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script>
    $(function () {
        $('#album').treegrid({
            height:400,
            url:'${pageContext.request.contextPath}/album/findAll',
            idField:'id',
            treeField:'title',
            animate:true,
            pagination:true,
            pageSize:1,
            fit:true,
            pageList:[1,5,10,20,50],
            columns:[[
                {title:'标题',field:'title',width:180},
                {title:'下载路径',field:'downPath',width:180},
                {title:'上传时间',field:'uploadTime',width:180},
                {title:'文件大小',field:'size',width:180},
                {title:'文件时长',field:'duration',width:180},
                {title:'操作',field:'options',width:180,
                    formatter:function(value,row,index){
                    if(row.size!=null){
                        return "<a href='${pageContext.request.contextPath}/chapter/downAudio?fileName="+row.title+"' class='options' data-options=\"iconCls:'icon-table_edit',plain:true\">下载音频</a>";
                        }
                    }
                },
            ]],
            onLoadSuccess:function () {
                $(".options").linkbutton();
            },
            toolbar:'#tt',
        });
    });
//专辑详情
    function OpenAlbum() {
        var treeField=$("#album").treegrid('getSelected');
        console.log(treeField)
        if (treeField.length<=0){
            $.messager.show({title:'提示信息',msg:'请选择一张专辑'});
        }else {
        $("#AlbumDialog").dialog({
            width:450,
            height:400,
            title:'专辑详情',
            href:'${pageContext.request.contextPath}/back/album/details.jsp?id='+treeField.id,
        })
     }
 }
//添加专辑
    function openAddAlbumDialog() {
    var treeField=$("#album").treegrid('getSelected');
   $("#addAlbumDialog").dialog({
       width:450,
       height:400,
       title:'添加专辑',
       href:'${pageContext.request.contextPath}/back/album/albumadd.jsp',
       buttons:[{ //对话框窗口的底部按钮
           iconCls:'icon-bullet_tick',
           text:'保存',
           handler:function () {
               //保存用户信息
               $('#addAlbumForm').form('submit',{
                   url:'${pageContext.request.contextPath}/album/file',
                   //操作执行成功以后，响应的一定是json'格式，返回js对象
                   success:function (result) {
                       //1.提示信息
                       $.messager.show({title:'温馨提示',msg:'添加成功！'});
                       //2.关闭对话框
                       $('#addAlbumDialog').dialog('close');
                       //3.刷新datagrid
                       $('#album').datagrid('reload');
                   }
               });
           }
       },{
           iconCls:'icon-cancel',
           text:'关闭',
           handler:function () {
               //2.关闭对话框
               $('#addAlbumDialog').dialog('close');
           }
       }]
   });
 }
//添加章节
    function openAddChapterDialog() {
        var treeField=$("#album").treegrid('getSelected');
        console.log(treeField)
        if(treeField==null){
            alert("请选中一张专辑");
        }else{
            $("#addChapterDialog").dialog({
                width:450,
                height:450,
                title:'添加章节',
                href:'${pageContext.request.contextPath}/back/album/chapteradd.jsp?id='+treeField.id,
                buttons:[{ //对话框窗口的底部按钮
                    iconCls:'icon-bullet_tick',
                    text:'保存',
                    handler:function () {
                        //保存章节信息
                        $('#addChapterForm').form('submit',{
                            url:'${pageContext.request.contextPath}/chapter/uploadAudio',
                            //操作执行成功以后，响应的一定是json'格式，返回js对象
                            success:function (result) {
                                //1.提示信息
                                $.messager.show({title:'温馨提示',msg:'添加成功！'});
                                //2.关闭对话框
                                $('#addChapterDialog').dialog('close');
                                //3.刷新datagrid
                                $('#album').datagrid('reload');
                            }
                        });
                    }
                },{
                    iconCls:'icon-cancel',
                    text:'关闭',
                    handler:function () {
                        //2.关闭对话框
                        $('#addChapterDialog').dialog('close');
                    }
                }]
            });
            $("#album_id").textbox("setValue",treeField.id);
        }
    }

</script>

<table id="album"></table>
<div id="tt">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-tip',plain:true" onclick="OpenAlbum();">专辑详情</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-table_add',plain:true" onclick="openAddAlbumDialog();">添加专辑</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-table_add',plain:true" onclick="openAddChapterDialog();">添加章节</a>
</div>
<div id="AlbumDialog"></div>
<div id="addAlbumDialog"></div>
<div id="addChapterDialog"></div>

