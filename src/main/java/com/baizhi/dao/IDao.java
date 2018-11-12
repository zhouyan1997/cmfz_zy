package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IDao<T> {
    //   添加
    public void insert(T t);
    //    根据id删除
    public void delete(String id);
    //    删除多条
    public void deleteAll(String[] ids);
    //    修改
    public void update(T t);
    //    查询全部
    public List<T> queryAll();
    //    根据id查询一个
    public T queryone(String id);

    //  分页查询 star:起始条件；rows：每一页显示的记录数
    public List<T> findBypage(@Param("start")Integer start, @Param("rows")Integer rows);
    //  查询总记录数
    public Long findTotals();
}
