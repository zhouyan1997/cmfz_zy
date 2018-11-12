<%@ page isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script>

</script>
<div style="text-align: center">
    <form id="addBannerForm" enctype="multipart/form-data" class="easyui-form" method="post" action="">
        <div style="margin-top: 40px;">
            名字：<input name="title" type="text" class="easyui-textbox">
        </div>
        <div style="margin-top: 10px;">
            文件：<input name="img" class="easyui-filebox" data-options="buttonText:'请选择文件',buttonAlign: 'left'">
        </div>

        <div style="margin-top: 10px;">
            描述：<input name="decs" type="text" class="easyui-textbox">
        </div>

        <div style="margin-top: 10px;">
            状态：<input name="status" type="text" class="easyui-textbox">
        </div>

        <div style="margin-top: 10px;">
            时间：<input name="date" type="text" class="easyui-datebox">
        </div>
    </form>
</div>