<%@ page isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script>
    //修改管理员密码
    function updateAdminDialog() {
       $("#updateDialog").dialog({
           href:'${pageContext.request.contextPath}/back/admin/updatepassword.jsp'
       });
    }

</script>
    	<div style="font-size: 24px;color:#FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">
            欢迎您:${sessionScope.login.name } &nbsp;
            <%--修改管理员登陆密码的对话框--%>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-brick_edit'" onclick="updateAdminDialog();">修改密码</a>&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/back/admin/login.jsp" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a>
        </div>
        <%--修改用户的对话框--%>
        <div id="updateDialog" data-options="width:400,height:300,title:'修改密码'"></div>






