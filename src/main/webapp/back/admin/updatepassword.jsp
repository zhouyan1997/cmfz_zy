<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<script>
    $(function(){
        $("#btn").click(function(){
            $("#passwordForm").form('submit',{
                url:'${pageContext.request.contextPath}/admin/update',
                onSubmit:function(){
                    var form = $("#passwordForm").form('validate');
                    if(form){
                        var pwd1 = $("#password1").val();
                        var pwd2 = $("#password2").val();
                        if(pwd1==pwd2){
                            return true;
                        }else{
                            $("#password2").textbox('setValue',"");
                            //missingMessage,当文本框未填写时出现的提示信息
                            $("#password2").textbox({missingMessage:'两次密码不一致,请重新填写',validateOnCreate:true,})
                            return false;
                        }
                    }else{
                        return false;
                    }
                },
                success:function(results){
                    var parseJSON = $.parseJSON(results);
                    if(parseJSON.result){
                        $("#updateDialog").dialog('close');
                        $.messager.show({title:'提示',msg:parseJSON.message,})
                    }else{
                        $("#password").textbox('setValue',"");
                        $("#password1").textbox('setValue',"");
                        $("#password2").textbox('setValue',"");
                        $.messager.show({title:'警告',msg:parseJSON.message,})
                    }
                    location.href="${pageContext.request.contextPath}/back/admin/login.jsp"
                }
            });
        })
    });
</script>
<div style="text-align: center">
    <img src="${pageContext.request.contextPath}/back/img/header_logo.gif" />
    <form class="easyui-form" method="post" id="passwordForm">
        <div style="margin-top: 30px;">
        请输入旧密码：<input id="password" name="password" type="text" class="easyui-textbox" data-options="validateOnBlur:true,validateOnCreate:false,required:true">
        </div>
        <div style="margin-top: 15px;">
        输入新密码：<input id="password1" name="password1"type="text" class="easyui-textbox" data-options="validateOnBlur:true,validateOnCreate:false,required:true" >
        </div>
        <div style="margin-top: 15px;">
        确认新密码：<input id="password2" name="password2"type="text" class="easyui-textbox">
        </div>
        <div style="margin-top: 15px;">
            <input  value="保存" id="btn" class="easyui-linkbutton" data-options="width:60,height:30"/>
        </div>

    </form>

</div>