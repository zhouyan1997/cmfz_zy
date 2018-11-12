package com.baizhi.service;

import com.baizhi.entity.Banner;
import com.baizhi.entity.Guru;

import java.util.List;

public interface GuruService {
    //添加上师信息
    public void add (Guru guru);
    //根据id删除上师信息
    public void remove(String id);
    //删除多条信息
    void  removeAll(String[] ids);
    //修改上师信息
    public void motify(Guru guru);
    //分页查询
    public List<Guru> findBypage(Integer page, Integer rows);
    //根据id查询一条数据
    public Guru findone(String id);
    //查询总条数
    Long findTotals();
}
