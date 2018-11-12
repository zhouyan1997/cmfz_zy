package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.utils.Md5SaltTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class AdminServiceImpl implements  AdminService{
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin queryName(String name) {
        return adminDao.queryName(name);
    }

    @Override
    public void register(Admin admin) {
        admin.setId(UUID.randomUUID().toString());
        String length = Md5SaltTool.getSalt(4);
        admin.setSalt(length);
        adminDao.insert(admin);
    }

    @Override
    public Admin queryone(String id) {
        return adminDao.queryone(id);
    }

    @Override
    public void update(Admin admin) {
        adminDao.update(admin);
    }

    @Override
    public Admin login(String name, String password) {
        return adminDao.query(name,password);
    }
}
