package com.baizhi.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private int id;
    private String name;
    private String iconCls;
    private  String href;
    private int parent_id;
    private List<Menu> menus=new ArrayList<Menu>();

    public Menu() {
    }

    public Menu(int id, String name, String iconCls, String href, int parent_id, List<Menu> menus) {
        this.id = id;
        this.name = name;
        this.iconCls = iconCls;
        this.href = href;
        this.parent_id = parent_id;
        this.menus = menus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", href='" + href + '\'' +
                ", parent_id=" + parent_id +
                ", menus=" + menus +
                '}';
    }
}
