<%@ page isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script>

</script>
<div style="text-align: center">
    <form id="userRegisterForm" class="easyui-form" method="post" action="${pageContext.request.contextPath}/user/register">
        <div style="margin-top: 40px;">
            手机号码：<input name="phone" type="text" class="easyui-textbox">
        </div>
        <div style="margin-top: 10px;">
            用户名：<input name="username" class="easyui-textbox">
        </div>
        <div style="margin-top: 10px;">
            密&nbsp;&nbsp;码：<input name="password" class="easyui-textbox">
        </div>
        <div style="margin-top: 10px;">
            时间：<input name="publishDate" type="text" class="easyui-texbox">
        </div>
        <input type="submit" value="提交" >
    </form>
</div>
