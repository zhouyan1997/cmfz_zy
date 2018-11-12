<%@ page isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script>
$(function () {
$("#updateBannerForm").form('load','${pageContext.request.contextPath}/ban/findone?id=${param.id}');
//在后台控制器中还得有根据id查询的方法
})
</script>
<div style="text-align: center">
    <form id="updateBannerForm" class="easyui-form" method="post">
        <input type="hidden" name="id" class="easyui-textbox" value="${param.id}">
        <div style="margin-top: 40px;">
            名字：<input name="title" type="text" class="easyui-textbox">
        </div>

        <div style="margin-top: 10px;">
            路径：<input name="imgPath" type="text" class="easyui-textbox">
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