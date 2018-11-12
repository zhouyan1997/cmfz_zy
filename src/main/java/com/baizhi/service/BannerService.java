package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerService {
    //添加
    public void add (Banner banner);
    //删除
    public void remove(String id);
    //删除多条信息
    void  removeAll(String[] ids);
    //修改
    public void motify(Banner banner);
   //分页查询
   public  List<Banner> findBypage(Integer page,Integer rows);
    //根据id查询一条数据
    public Banner findone(String id);
   //查询总条数
    Long findTotals();
}
