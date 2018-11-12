package com.baizhi.service;

import com.baizhi.dao.GuruDao;
import com.baizhi.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Controller
public class GuruServiceImpl implements  GuruService{
    @Autowired
    private GuruDao guruDao;
    @Override
    public void add(Guru guru) {
        guru.setId(UUID.randomUUID().toString());
        guruDao.insert(guru);
    }

    @Override
    public void remove(String id) {
        guruDao.delete(id);
    }

    @Override
    public void removeAll(String[] ids) {
        guruDao.deleteAll(ids);
    }

    @Override
    public void motify(Guru guru) {
        guruDao.update(guru);
    }

    @Override
    public List<Guru> findBypage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        List<Guru> bypage = guruDao.findBypage(start, rows);
        return bypage;
    }

    @Override
    public Guru findone(String id) {
        return guruDao.queryone(id);
    }

    @Override
    public Long findTotals() {
        return guruDao.findTotals();
    }
}
