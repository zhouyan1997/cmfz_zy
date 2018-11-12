<%@ page isELIgnored="false" language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/IconExtension.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/datagrid-detailview.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/form.validator.rules.js"></script>
    <script>
        $(function () {
            var name='${sessionScope.login.name}';
            if(name==""){
                location.href='${pageContext.request.contextPath}/back/admin/login.jsp';
            }
           /*页面加载完成之后显示菜单数据*/
            $.post("${pageContext.request.contextPath}/menu/findAll",function (menu) {
                /*通过easyui-accordion的添加方法追加菜单*/
                $.each(menu,function (index ,f) {
                    var content = "<div style='text-algin:center;'>";
                    /*遍历二级菜单*/
                    $.each(f.menus, function (idx, m) {
                        content += "<a onclick=\"addTabs('" + m.name + "','" + m.iconCls + "','" + m.href + "')\" style='width:95%;margin:10px 0px; border-radius: 5px;border: 1px #blue dotted ' class='easyui-linkbutton' data-options=\"plain:true,iconCls:'" + m.iconCls + "'\">" + m.name + "</a><br>";
                    });
                    content += "</div>"
                    /*添加菜单*/
                    $("#menu").accordion('add', {
                        title: f.name,
                        iconCls: f.iconCls,
                        content: content
                    })
                });
            });
        });

    /*点击按钮追加选项卡*/
    function addTabs(title,iconCls,href) {
        if(!$("#tabs").tabs("exists",title)){
            $("#tabs").tabs('add',{
                title:title,
                iconCls:iconCls,
                closable:true,
                fit:true,
                href:'${pageContext.request.contextPath}/'+href,
            });
        }else {
            $("#tabs").tabs("select",title)
        }
}
</script>
</head>

<body class="easyui-layout">
    <%--头部信息--%>
    <div data-options="region:'north',split:false,href:'${pageContext.request.contextPath}/back/main/head.jsp'" style="height:60px;background-color:  #5C160C">

    </div>

    <%--菜单部分--%>
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
        <div id="menu" class="easyui-accordion" data-options="fit:true"></div>
    </div>

    <%--中部页面--%>
    <div data-options="region:'center'">
        <%--选项卡--%>
        <div id="tabs" class="easyui-tabs" data-options="fit:true">
            <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(${pageContext.request.contextPath}/back/main/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
        </div>

    </div>







    <%--尾部--%>
    <div data-options="region:'south',split:false,href:'${pageContext.request.contextPath}/back/main/footer.jsp'" style="height: 40px;background:#5C160C">
        <div style="text-align: center;font-size:15px; margin-top: 10px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>


</body>
</html>