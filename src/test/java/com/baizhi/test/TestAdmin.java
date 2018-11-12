package com.baizhi.test;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.utils.Md5SaltTool;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestAdmin extends BaseTest {
    @Autowired
    private AdminService adminService;
    @Test
    public void register(){
        Admin admin=new Admin();
        adminService.register(admin);
        String salt = Md5SaltTool.getSalt(4);
        System.out.println(salt);
        String s = DigestUtils.md5Hex(salt + 123);
        System.out.println(s);
    }
    @Test
    public void login(){
        Admin login = adminService.login("蛋黄", "123456");
        System.out.println(login);
    }

    @Test
    public void updatepassword(){
        Admin admin=new Admin();
        admin.setId("4");
        admin.setPassword("456789");
        adminService.update(admin);
    }
    @Test
    public void testqueryone(){
        Admin queryone = adminService.queryone("0a894556-2a15-4ef8-a1b1-efb086aa883c");
        System.out.println(queryone);

    }

    @Test
    public void testsalt(){


    }
}
