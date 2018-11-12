package com.baizhi.controller;
import com.baizhi.entity.Article;
import com.baizhi.entity.Guru;
import com.baizhi.service.ArticleService;
import com.baizhi.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    //    分页展示页面
    @RequestMapping("/findAll")
    public @ResponseBody
    Map<String,Object> findAll(Integer page, Integer rows){
        Map<String,Object> results=new HashMap<String,Object>();
        List<Article> articles=articleService.findBypage(page,rows);
        Long totals=articleService.findTotals();
        results.put("total",totals);
        results.put("rows",articles);
        return results;
    }
    //添加文章信息
    @RequestMapping("/insert")
    public @ResponseBody Map<String,Object> insert(Article article){
        Map<String,Object> results=new HashMap<String,Object>();
        try {
            articleService.add(article);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return  results;
    }
//    根据id删除文章信息
    @RequestMapping("/delete")
    public @ResponseBody String delete(String id){
        try {
            articleService.remove(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
//删除多篇文章信息
    @RequestMapping("deleteAll")
  public  @ResponseBody String[] deleteAll(String[] ids){
        try {
            articleService.removeAll(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
         return ids;
    }
//    修改文章信息
    @RequestMapping("/update")
    public @ResponseBody String update(Article article){
        try {
            articleService.motify(article);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "guru";
    }
//    根据id查询文章
@RequestMapping("/findone")
public  @ResponseBody Article queryone(String id){
    Article queryone = articleService.findone(id);
    return queryone;
}

//    上传文章图片
@RequestMapping("/file")
public @ResponseBody void file(HttpServletRequest request, HttpServletResponse response, MultipartFile img, Article article)
        throws IOException {
//        获取上传文件的绝对路径
    String realPath = request.getSession().getServletContext().getRealPath("/back/banner/img");
    String fileName=img.getOriginalFilename();
    System.out.println(realPath+"---"+fileName);
    img.transferTo(new File(realPath,fileName));
    article.setImgPath("/back/banner/img/"+fileName);
    articleService.add(article);
    }

}
