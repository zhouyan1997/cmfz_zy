package com.baizhi.service;
import com.baizhi.entity.Banner;
import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    //用户注册
    public void register (User user);
    //根据id删除用户信息
    public void remove(String id);
    //删除多个用户
    public void  removeAll(String[] ids);
    //修改用户信息
    public void motify(User user);
    //分页查询用户信息
    public List<User> findBypage(Integer page, Integer rows);
    //用户登陆
    public User login(String phone,String password);
    //查询总条数
    Long findTotals();
}
