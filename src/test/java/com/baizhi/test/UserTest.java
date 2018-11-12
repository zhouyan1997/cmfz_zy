package com.baizhi.test;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest extends BaseTest {
    @Autowired
    private UserService userService;
    @Test
    public void insert(){
        User user=new User();
        user.setUsername("大黄");
        user.setPassword("routlanshuo");
        userService.register(user);
    }
}
