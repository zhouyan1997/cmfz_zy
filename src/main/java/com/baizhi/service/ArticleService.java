package com.baizhi.service;
import com.baizhi.entity.Article;
import java.util.List;

public interface ArticleService {
    //添加文章信息
    public void add (Article article);
    //根据id删除文章信息
    public void remove(String id);
    //删除多条信息
    void  removeAll(String[] ids);
    //修改文章信息
    public void motify(Article article);
    //分页查询文章
    public List<Article> findBypage(Integer page, Integer rows);
//    查询全部文章的信息
    public List<Article> queryAll();
    //根据id查询一条数据
    public Article findone(String id);
    //查询总条数
    Long findTotals();
}
