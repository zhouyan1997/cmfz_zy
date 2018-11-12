package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.utils.Md5SaltTool;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    //管理员登陆后台管理系统
    @RequestMapping("/login")
    public String login(String name, String password, HttpServletRequest request){
        Admin admin = adminService.queryName(name);
        String name1 = DigestUtils.md5Hex(admin.getSalt()+password);
        Admin login = adminService.login(name, name1);
        if(login!=null){
            request.getSession().setAttribute("login",login);
            return "redirect:/back/main/main.jsp";
        }
            return "redirect:/back/admin/login.jsp";
    }

    @RequestMapping("/update")
    public @ResponseBody Map<String,Object> update(String password,String password1,HttpServletRequest request){
        System.out.println("aaa");
        Admin login = (Admin) request.getSession().getAttribute("login");
        Map<String,Object> map=new HashMap<String,Object>();
        Admin query = adminService.queryName(login.getName());
//        通过对象取出盐值
        String salt = query.getSalt();
//      取出加密后的盐值和密码
        String s = DigestUtils.md5Hex(salt+password);
//       给新密码 password1加密
        //String salt1 = Md5SaltTool.getSalt(4);
        String s1 = DigestUtils.md5Hex(salt + password1);
//     判断从页面中取出的密码是否与数据库中的密码相符合
        if(login.getPassword().equals(s)){
//     判断相符合之后将新密码存进去
            login.setPassword(s1);
            try {
                System.out.println(login);
//     执行修改方法
               adminService.update(login);
//     将修改之后的密码存进session中
                request.getSession().setAttribute("login",login);
                map.put("login",true);
                map.put("message","密码修改成功");
            } catch (Exception e) {
                e.printStackTrace();
                map.put("login",false);
                map.put("message","密码修改失败");
            }
        }else{
            map.put("login",false);
            map.put("message","旧密码输入失败");
        }
        return map;
    }


    @RequestMapping("/findone")
    public @ResponseBody Admin queryone(String id){
        Admin admin = adminService.queryone(id);
        System.out.println(admin);
        return admin;
    }
}