<%@ page isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div style="text-align: center">
    <form id="addGuruForm" enctype="multipart/form-data" class="easyui-form" method="post" action="">
        <div style="margin-top: 40px;">
            上师名称：<input name="name" type="text" class="easyui-textbox">
        </div>
        <div style="margin-top: 10px;">
            上师头像：<input name="img" class="easyui-filebox" data-options="buttonText:'请选择文件',buttonAlign: 'left'">
        </div>

        <div style="margin-top: 10px;">
            上师性别：<input name="gender" type="text" class="easyui-textbox">
        </div>
    </form>
</div>