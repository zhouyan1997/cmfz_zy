package com.baizhi.service;

import com.baizhi.entity.Menu;

import java.util.List;

public interface MenuService{
    void add (Menu menu);
    void remove (String id);
    void motify(Menu menu);
    List<Menu> findAll();
}
