package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.utils.Md5SaltTool;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
//    展示所有用户的信息
    @RequestMapping("findAll")
    public @ResponseBody Map<String,Object> findAll(Integer page,Integer rows){
        Map<String, Object> map = new HashMap<String,Object>();
        List<User> bypage = userService.findBypage(page,rows);
        Long totals = userService.findTotals();
        map.put("total",totals);
        map.put("rows",bypage);
        return map;
    }
//用户注册
    @RequestMapping("/register")
    public @ResponseBody String register(User user){
        try {
            String length = Md5SaltTool.getSalt(4);
            user.setSalt(length);
            userService.register(user);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    //用户登陆
    @RequestMapping("/login")
    public @ResponseBody User login(String phone ,String password,HttpServletRequest request){

        User login = userService.login(phone, password);
        if(login!=null){
            request.getSession().setAttribute("login",login);
            return login;
        }
            return null;
    }
//    根据id删除删除
    @RequestMapping("/delete")
    public @ResponseBody String delete(String id){
        try {
            userService.remove(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    @RequestMapping("update")
    public @ResponseBody String update(User user){
        try {
            userService.motify(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user";
    }

}
