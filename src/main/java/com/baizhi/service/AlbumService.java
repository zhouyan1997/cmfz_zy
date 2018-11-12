package com.baizhi.service;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumService {
    //添加专辑信息
    public void add (Album album);
    //根据id删除专辑信息
    public void remove(String id);
    //删除多张专辑
    public void  removeAll(String[] ids);
    //修改专辑信息
    public void motify(Album album);
    //  查询全部专辑
    public List<Album> findAll();
    //分页查询专辑
    public List<Album> findBypage(@Param("page") Integer page,@Param("rows") Integer rows);
    //根据id查询一条数据
    public Album findone(String id);
    //查询总条数
    Long findTotals();
}
