package com.baizhi.service;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterDao chapterDao;

    @Override
    public void add(Chapter chapter) {
        chapter.setId(UUID.randomUUID().toString());
        chapter.setUploadTime(new Date());
        chapterDao.insert(chapter);
    }

    @Override
    public void remove(String id) {
    chapterDao.delete(id);
    }

    @Override
    public void removeAll(String[] ids) {
    chapterDao.deleteAll(ids);
    }

    @Override
    public void motify(Chapter chapter) {
    chapterDao.update(chapter);
    }

    @Override
    public List<Chapter> findAll() {
        return chapterDao.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Chapter> findBypage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        List<Chapter> bypage = chapterDao.findBypage(start, rows);
        return bypage;
    }

    @Override
    public Chapter findone(String id) {
        return chapterDao.queryone(id);
    }

    @Override
    public Long findTotals() {
        return chapterDao.findTotals();
    }
}
