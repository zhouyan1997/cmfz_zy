<%@ page isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script>
$(function () {
$("#updateArticleForm").form('load','${pageContext.request.contextPath}/article/findone?id=${param.id}');
//在后台控制器中还得有根据id查询的方法
})
</script>
<div style="text-align: center">
    <form id="updateArticleForm" class="easyui-form" method="post">
        <input type="hidden" name="id" class="easyui-textbox" value="${param.id}">
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
            上师：<input name="guru_id" type="text" class="easyui-textbox">
        </div>

        <div style="margin-top: 10px;">
            状态：<input name="status" type="text" class="easyui-textbox">
        </div>

    </form>
</div>