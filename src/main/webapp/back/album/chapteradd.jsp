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
    <form id="addChapterForm" enctype="multipart/form-data" class="easyui-form" method="post" action="">
        <div style="margin-top: 20px;">
            上传音频：<input name="mp3" class="easyui-filebox" data-options="required:true,validType:'audio',buttonText:'请选择文件',buttonAlign: 'left'">
        </div>
        <div style="margin-top: 10px;">
            章节集数：<input name="number" class="easyui-textbox">
        </div>
        <div style="margin-top: 10px;">
            所属专辑：<select id="albumId" name="album_id"></select>
        </div>
    </form>
</div>