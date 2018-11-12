package com.baizhi.controller;
import com.baizhi.entity.Guru;
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
@RequestMapping("/guru")
public class GuruController {
    @Autowired
    private GuruService guruService;
    //    分页展示页面
    @RequestMapping("/findAll")
    public @ResponseBody
    Map<String,Object> findAll(Integer page, Integer rows){
        Map<String,Object> results=new HashMap<String,Object>();
        List<Guru> banners=guruService.findBypage(page,rows);
        Long totals=guruService.findTotals();
        results.put("total",totals);
        results.put("rows",banners);
        return results;
    }
    //添加上师信息
    @RequestMapping("/insert")
    public @ResponseBody Map<String,Object> insert(Guru guru){
        Map<String,Object> results=new HashMap<String,Object>();
        try {
            guruService.add(guru);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return  results;
    }
//    根据id删除上师信息
    @RequestMapping("/delete")
    public @ResponseBody String delete(String id){
        try {
            guruService.remove(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
//删除多条上师信息
    @RequestMapping("deleteAll")
  public  @ResponseBody String[] deleteAll(String[] ids){
        try {
            guruService.removeAll(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
         return ids;
    }
//    修改上师信息
    @RequestMapping("/update")
    public @ResponseBody String update(Guru guru){
        try {
            guruService.motify(guru);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "guru";
    }
//    根据id查询上师信息
@RequestMapping("/findone")
public  @ResponseBody Guru queryone(String id){
    Guru queryone = guruService.findone(id);
    return queryone;
}
//    上传上师头像
@RequestMapping("/file")
public @ResponseBody void file(HttpServletRequest request, HttpServletResponse response, MultipartFile img, Guru guru)
        throws IOException {
//        获取上传文件的绝对路径
    String realPath = request.getSession().getServletContext().getRealPath("/back/banner/img");
    String fileName=img.getOriginalFilename();
    System.out.println(realPath+"---"+fileName);
    img.transferTo(new File(realPath,fileName));
    guru.setHeadPic("/back/banner/img/"+fileName);
    guruService.add(guru);
}

}
