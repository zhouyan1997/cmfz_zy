package com.baizhi.service;

import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/*
*用来创建Service层的组件对象
* */
@Service
@Transactional
/*作用：用来控制事务的
* 修饰范围：既可以写在类上，也可以加载方法上
* */
public class MenuServiceImpl implements MenuService{
    /*注入MenuDao*/
    @Autowired
    private MenuDao menuDao;

    @Override
    public void add(Menu menu) {
        menuDao.insert(menu);
    }

    @Override
    public void remove(String id) {
        menuDao.delete(id);
    }

    @Override
    public void motify(Menu menu) {
        menuDao.update(menu);
    }
    /*菜单查询*/
    @Override
    public List<Menu> findAll() {
        return menuDao.queryAll();
    }
}
