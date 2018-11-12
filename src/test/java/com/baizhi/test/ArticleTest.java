package com.baizhi.test;

import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class ArticleTest extends BaseTest {
    @Autowired
    private ArticleService articleService;
    @Test
    public void insert(){
        Article article=new Article();
        article.setTitle("你是否有资格追随一名上师");
        article.setImgPath("/back/article/img/A1.jpg");
        article.setContent("攻广大师生解释解释吧科生的那个建瓯市挂机哦东京广播二五送二钢铁网工委管委结果被v收购角色偶就给我报价金嘎钦欧冠进球哦安徒具外婆特务叛徒安排给推荐物品");
        article.setPublishDate(new Date());
        article.setGuru_id("2");
        article.setStatus("y");
        articleService.add(article);
    }
    @Test
    public void findAll(){
        List<Article> bypage = articleService.findBypage(1, 1);
        System.out.println(bypage);
    }
    @Test
    public void queryone(){
        Article queryone = articleService.findone("1392fcf8-be6b-462e-9780-50e9bd399d95");
        System.out.println(queryone);

    }
}
