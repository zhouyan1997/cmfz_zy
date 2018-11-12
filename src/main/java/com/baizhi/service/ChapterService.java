package com.baizhi.service;

import com.baizhi.entity.Article;
import com.baizhi.entity.Chapter;

import java.util.List;

public interface ChapterService {
    //添加章节信息
    public void add (Chapter chapter);
    //根据id删除章节信息
    public void remove(String id);
    //删除多条章节信息
    void  removeAll(String[] ids);
    //修改章节信息
    public void motify(Chapter chapter);
    //查询全部章节
    public List<Chapter> findAll();
    //分页查询文章
    public List<Chapter> findBypage(Integer page, Integer rows);
    //根据id查询一条数据
    public Chapter findone(String id);
    //查询总条数
    Long findTotals();
}
