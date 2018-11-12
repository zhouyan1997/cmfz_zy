<%@ page isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script>
    $(function () {
        $("#albumId").combobox({
            required:'true',
            url:'${pageContext.request.contextPath}/album/query',
            //为下拉列狂绑定数值
            valueField:'id',
            //基本字段名称
            textField:'title',
            //设置为ture时，输入的值只能是下拉列表框的内容
            limitToList:true,
            //下拉面板最大高度
            panelMaxHeight:120,
            //定义用户是否可以直接输入文本到字段中
            editable:false,
            width:150,
        });
    })
</script>
<div style="text-align: center">
    <form id="addArticleForm" enctype="multipart/form-data" class="easyui-form" method="post" action="">
        <div style="margin-top: 40px;">
            主题：<input name="title" type="text" class="easyui-textbox">
        </div>
        <div style="margin-top: 10px;">
            图片：<input name="img" class="easyui-filebox" data-options="buttonText:'请选择文件',buttonAlign: 'left'">
        </div>

        <div style="margin-top: 10px;">
            文章：<input name="content" type="text" class="easyui-textbox">
        </div>

        <div style="margin-top: 10px;">
            时间：<input name="publishDate" type="text" class="easyui-datebox">
        </div>

        <div style="margin-top: 10px;">
           所属上师：<input name="guru_id" type="text" class="easyui-textbox">
        </div>

        <div style="margin-top: 10px;">
            状态：<input name="status" type="text" class="easyui-textbox">
        </div>

    </form>
</div>