package com.baizhi.dao;

import com.baizhi.entity.Admin;

public interface AdminDao{
    /*添加*/
    public void insert(Admin admin);
    /*根据用户和密码查询*/
    public Admin query(String name,String password);
//    根据用户查询 对象
    public Admin queryName(String name);
    /*根据id查询用户*/
    public Admin queryone(String id);
    /*修改用户*/
    public void update(Admin admin);

}
