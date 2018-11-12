<%@ page isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div style="text-align: center">
    <form id="addCourseForm" enctype="multipart/form-data" class="easyui-form" method="post" action="">
        <div style="margin-top: 40px;">
            功课名字：<input name="title" type="text" class="easyui-textbox">
        </div>
        <div style="margin-top: 10px;">
            功课标志：<input name="flag" class="easyui-texbox" data-options="">
        </div>

        <div style="margin-top: 10px;">
            创建时间：<input name="creatTime" type="text" class="easyui-textbox">
        </div>
    </form>
</div>