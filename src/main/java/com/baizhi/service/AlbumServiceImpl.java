package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService{
    @Autowired
    private AlbumDao albumDao;
//添加专辑
    @Override
    public void add(Album album) {
        album.setId(UUID.randomUUID().toString());
        albumDao.insert(album);
    }
//根据id删除专辑
    @Override
    public void remove(String id) {
        albumDao.delete(id);
    }
//删除多条专辑
    @Override
    public void removeAll(String[] ids) {
        albumDao.deleteAll(ids);
    }
//修改专辑
    @Override
    public void motify(Album album) {
        albumDao.update(album);
    }
//查询全部专辑
    @Override
    public List<Album> findAll() {
        return albumDao.queryAll();
    }
//分页查询专辑信息
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Album> findBypage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        List bypage = albumDao.findBypage(start, rows);
        return bypage;
    }
//根据id查询一张专辑
    @Override
    public Album findone(String id) {
        Album queryone = albumDao.queryone(id);
        return queryone;
    }
//查询总条数
    @Override
    @Transactional(propagation =Propagation.SUPPORTS)
    public Long findTotals() {
        return albumDao.findTotals();
    }
}
