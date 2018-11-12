<%@ page isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script>
    $(function () {
        //在后台控制器中还得有根据id查询的方法
        $("#AlbumForm").form('load','${pageContext.request.contextPath}/album/findone?id=${param.id}');

    });


</script>
<div style="text-align: center">
    <form id="AlbumForm" class="easyui-form" method="post" action="">
        <input type="hidden" name="id" class="easyui-textbox" value="${param.id}">
        <div style="margin-top: 20px;">
            专辑名称：<input name="title" type="text" class="easyui-textbox" readonly="true">
        </div>
        <div style="margin-top: 10px;">
            上传时间：<input name="publishDate" class="easyui-textbox" readonly="true">
        </div>

        <div style="margin-top: 10px;">
           专辑封面 ：<img src="${param.coverImg}" readonly="true">
            
        </div>

        <div style="margin-top: 10px;">
            专辑集数：<input name="counts" type="text" class="easyui-textbox" readonly="true">
        </div>

        <div style="margin-top: 10px;">
            专辑星级：<input name="score" type="text" class="easyui-textbox" readonly="true">
        </div>

        <div style="margin-top: 10px;">
            专辑作者：<input name="author" type="text" class="easyui-textbox" readonly="true">
        </div>
        <div style="margin-top: 10px;">
            专辑播音：<input name="broadCast" type="text" class="easyui-textbox" readonly="true">
        </div>
        <div style="margin-top: 10px;">
            专辑简介：<input name="brief" type="text" class="easyui-textbox" readonly="true">
        </div>

        <div style="margin-top: 10px;">
            专辑状态：<input name="status" type="text" class="easyui-textbox" readonly="true">
        </div>
    </form>
</div>