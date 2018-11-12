package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDao extends IDao<User>{
        public User queryByPhone(String phone, String password);
}
