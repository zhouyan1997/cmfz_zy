<%@ page isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script>

</script>
<div style="text-align: center">
    <form id="addAlbumForm" enctype="multipart/form-data" class="easyui-form" method="post" action="">
        <div style="margin-top: 20px;">
            专辑名称：<input name="title" type="text" class="easyui-textbox">
        </div>
        <div style="margin-top: 10px;">
            上传时间：<input name="publishDate" class="easyui-datebox">
        </div>

        <div style="margin-top: 10px;">
           专辑封面 ：<input name="img" type="text" class="easyui-filebox" data-options="buttonText:'请选择文件',buttonAlign: 'left'">
        </div>

        <div style="margin-top: 10px;">
            专辑集数：<input name="counts" type="text" class="easyui-textbox">
        </div>

        <div style="margin-top: 10px;">
            专辑星级：<input name="score" type="text" class="easyui-textbox">
        </div>

        <div style="margin-top: 10px;">
            专辑作者：<input name="author" typtext" class="easyui-textbox">
        </div>
        <div style="margin-top: 10px;">
            专辑播音：<input name="broadCast" type="text" class="easyui-textbox">
        </div>
        <div style="margin-top: 10px;">
            专辑简介：<input name="brief" type="text" class="easyui-textbox">
        </div>

        <div style="margin-top: 10px;">
            专辑状态：<input name="status" type="text" class="easyui-textbox">
        </div>
    </form>
</div>