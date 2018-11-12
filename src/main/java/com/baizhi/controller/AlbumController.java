package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Banner;
import com.baizhi.service.AlbumService;
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
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
@RequestMapping("/findAll")
    public @ResponseBody Map<String,Object> findAll(Integer page, Integer rows){
        Map<String, Object> map = new HashMap<String,Object>();
        List<Album> bypage = albumService.findBypage(page, rows);
        Long totals = albumService.findTotals();
        map.put("total",totals);
        map.put("rows",bypage);
        return map;
    }
//    根据id查询一张专辑
@RequestMapping("/findone")
public  @ResponseBody Album queryone(String id,HttpServletRequest request){
    Album queryone = albumService.findone(id);
    request.getSession().setAttribute("album",queryone);
    return queryone;
}
//
@RequestMapping("/insert")
    public @ResponseBody Map<String,Object> insert(Album album) {
    Map<String, Object> results = new HashMap<>();
    try {
        albumService.add(album);
        results.put("success", true);
    } catch (Exception e) {
        e.printStackTrace();
        results.put("success",false);
        results.put("message",e.getMessage());
    }
    return results;
}

//根据id删除专辑
    @RequestMapping("/delete")
    public @ResponseBody String delete(String id){
        try {
            albumService.remove(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
//修改专辑
    @RequestMapping("/update")
    public @ResponseBody String update(Album album){
        try {
            albumService.motify(album);
        } catch (Exception e) {
        }
        return "album";
    }
//    删除多张专辑
    @RequestMapping("/deleteAll")
    public @ResponseBody String[] deleteAll(String[] ids){
        try {
            albumService.removeAll(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ids;
    }


@RequestMapping("/query")
    public @ResponseBody List<Album> queryAll(){

        List<Album> albums = albumService.findAll();

       return albums;
    }


@RequestMapping("/file")
    public @ResponseBody void file(HttpServletRequest request, HttpServletResponse response, MultipartFile img,Album album)
        throws IOException {
    //    获取文件上传的路径
        String realPath = request.getSession().getServletContext().getRealPath("/back/banner/img");
        String fileName = img.getOriginalFilename();
        img.transferTo(new File(realPath,fileName));
         album.setCoverImg("/back/banner/img/"+fileName);
        albumService.add(album);
    }
}
