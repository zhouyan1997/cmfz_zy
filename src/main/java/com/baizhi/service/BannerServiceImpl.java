package com.baizhi.service;

import com.baizhi.dao.BannerDao;

import com.baizhi.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;

    //分页查询
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Banner> findBypage(Integer page, Integer rows) {
       int start=(page-1)*rows;
        return bannerDao.findBypage(start,rows);
    }
//    删除多条数据
    @Override
    public void removeAll(String[] ids) {
        bannerDao.deleteAll(ids);
    }
   //查询一个
    @Override
    public Banner findone(String id) {
        Banner queryone = bannerDao.queryone(id);
        return queryone;
    }

    //查询总条数
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return bannerDao.findTotals();
    }


    //添加
    @Override
    public void add(Banner banner) {
        banner.setId(UUID.randomUUID().toString());
        bannerDao.insert(banner);
    }
   //根据id删除
    @Override
    public void remove(String id) {
        bannerDao.delete(id);
    }
    //修改
    @Override
    public void motify(Banner banner) {
        bannerDao.update(banner);
    }

}
