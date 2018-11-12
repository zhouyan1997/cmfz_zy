package com.baizhi.test;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MenuTest extends BaseTest{
    /*
    *注入MenuService层
    * */
    @Autowired
    private MenuService menuService;
    @Test
    public void testqueryAll(){
        List<Menu> menus = menuService.findAll();
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }
}
