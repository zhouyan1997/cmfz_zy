package com.baizhi.controller;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
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
@RequestMapping("/ban")
public class BannerController{
    @Autowired
    private BannerService bannerService;
//    分页展示页面
    @RequestMapping("/findAll")
    public @ResponseBody Map<String,Object> findAll(Integer page, Integer rows){
        Map<String,Object> results=new HashMap<String,Object>();
        List<Banner> banners=bannerService.findBypage(page,rows);

        Long totals=bannerService.findTotals();
        results.put("total",totals);
        results.put("rows",banners);
        return results;
    }
//    添加数据
    @RequestMapping("/insert")
    public @ResponseBody Map<String,Object> insert(Banner banner){
       Map<String,Object> results=new HashMap<String,Object>();
        try {
            bannerService.add(banner);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
         return  results;
    }
//    删除一条数据
    @RequestMapping("/delete")
    public @ResponseBody String delete(String id){
        try {
            bannerService.remove(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
//删除多条数据
    @RequestMapping("deleteAll")
    public @ResponseBody String[] deleteAll(String[] ids){
        try {
            bannerService.removeAll(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ids;
    }
    @RequestMapping("/update")
    public @ResponseBody String update (Banner banner){
        try {
            bannerService.motify(banner);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
//    根据id查询一条数据
    @RequestMapping("/findone")
    public  @ResponseBody Banner queryone(String id){
        Banner queryone = bannerService.findone(id);
        return queryone;
    }
    @RequestMapping("/file")
    public @ResponseBody void file(HttpServletRequest request, HttpServletResponse response, MultipartFile img,Banner banner)
        throws IOException {
//        获取上传文件的绝对路径
        System.out.println("111");
        String realPath = request.getSession().getServletContext().getRealPath("/back/banner/img");
        System.out.println("222");
        String fileName=img.getOriginalFilename();
        System.out.println(realPath+"---"+fileName);
        img.transferTo(new File(realPath,fileName));
        banner.setImgPath("/back/banner/img/"+fileName);
        bannerService.add(banner);

    }
}
