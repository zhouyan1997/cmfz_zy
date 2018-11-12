package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService {
    /*
    * 用户注册
    * */
    public void register(Admin admin);
    /*用户登陆*/
    public Admin login(String name,String password);

    /*查询盐和密码*/
    public Admin queryName(String name);
    /*修改用户密码*/
    public  void update(Admin admin);
    /*根据id查询用户*/
    public Admin queryone(String id);
}
