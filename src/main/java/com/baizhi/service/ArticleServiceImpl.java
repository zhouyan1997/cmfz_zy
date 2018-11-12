package com.baizhi.service;

import com.baizhi.dao.ArticleDao;
import com.baizhi.entity.Article;
import com.baizhi.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    private ArticleDao articleDao;
    @Override
    public void add(Article article) {
        article.setId(UUID.randomUUID().toString());
        articleDao.insert(article);
    }
    @Override
    public void remove(String id) {
        articleDao.delete(id);
    }

    @Override
    public void removeAll(String[] ids) {
        articleDao.deleteAll(ids);
    }

    @Override
    public void motify(Article article) {
        articleDao.update(article);
    }

    @Override
    public List<Article> findBypage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        List<Article> bypage = articleDao.findBypage(start, rows);
        return bypage;
    }

    @Override
    public List<Article> queryAll() {
        return articleDao.queryAll();
    }

    @Override
    public Article findone(String id) {
        Article queryone = articleDao.queryone(id);
        return queryone;
    }

    @Override
    public Long findTotals() {
        articleDao.findTotals();
        return null;
    }
}
