package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*
*用来创建这个类的实例
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    /*
    * 注入menuservice
    * */
    @Autowired
   private MenuService menuService;

    @RequestMapping("/findAll")
    public @ResponseBody List<Menu> queryAll(){
        List<Menu> menus = menuService.findAll();
        for (Menu menu : menus) {
          //  System.out.println(menu);
        }
        return menus;
    }
}
