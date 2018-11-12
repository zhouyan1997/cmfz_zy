<%@ page isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script>
$(function () {
$("#updateCourseForm").form('load','${pageContext.request.contextPath}/guru/findone?id=${param.id}');
//在后台控制器中还得有根据id查询的方法
})
</script>
<div style="text-align: center">
    <form id="updateCourseForm" class="easyui-form" method="post">
        <input type="hidden" name="id" class="easyui-textbox" value="${param.id}">
        <div style="margin-top: 40px;">
            上师名称：<input name="name" type="text" class="easyui-textbox">
        </div>

        <div style="margin-top: 10px;">
            上师头像：<input name="headPic" type="text" class="easyui-textbox">
        </div>

        <div style="margin-top: 10px;">
            上师性别：<input name="gender" type="text" class="easyui-textbox">
        </div>

    </form>
</div>