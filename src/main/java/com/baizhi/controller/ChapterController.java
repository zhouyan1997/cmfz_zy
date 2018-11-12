package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
//    分页展示章节信息
    @RequestMapping("/findAll")
    public @ResponseBody Map<String,Object> findAll(Integer page,Integer rows){
        Map<String,Object> map=new HashMap<String,Object>();
        List<Chapter> bypage = chapterService.findBypage(page, rows);
        Long totals = chapterService.findTotals();
        map.put("total",totals);
        map.put("rows",bypage);
        return map ;
    }
//添加章节信息
    @RequestMapping("/insert")
    public @ResponseBody Map<String,Object> insert(Chapter chapter){
        Map<String,Object> results=new HashMap<String,Object>();
        try {
            chapterService.add(chapter);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
//    删除章节信息
    @RequestMapping("/delete")
    public @ResponseBody String delete(String id){
        try {
            chapterService.remove(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
//    删除章节的全部信息
    @RequestMapping("/deleteAll")
    public @ResponseBody String[] deleteAll(String[] ids){
        try {
            chapterService.removeAll(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ids;
    }
//    修改章节信息
    @RequestMapping("/update")
    public @ResponseBody String update(Chapter chapter){
        try {
            chapterService.motify(chapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
//    根据id查询一条文章
    @RequestMapping("/queryone")
    public @ResponseBody Chapter queryone(String id){
        Chapter queryone = chapterService.findone(id);
        return queryone;
    }


    //音频时长
    public int getAudioLength(String realPath) throws TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException, IOException {
        File file=new File(realPath);
        int s=0;
        MP3File f = (MP3File)AudioFileIO.read(file);
        MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();
        s =audioHeader.getTrackLength();
        return s;
    }

    //音频上传
    @RequestMapping("/uploadAudio")
    public void uploadAudio(HttpServletRequest request,HttpServletResponse response, MultipartFile mp3,Chapter chapter)
            throws Exception{
        String realPath = request.getSession().getServletContext().getRealPath("/back/album/audio");
        mp3.transferTo(new File(realPath,mp3.getOriginalFilename()));
        //音频的保存路径
        chapter.setDownPath("/back/album/audio"+mp3.getOriginalFilename());
        //文件名
        chapter.setTitle(mp3.getOriginalFilename());
        //自动解析文件大小
        chapter.setSize(mp3.getSize()/1024/1024);
        //获取文件时长
        realPath+="/"+mp3.getOriginalFilename();
         int audioLength = getAudioLength(realPath);
        //保存文件时长
        chapter.setDuration(audioLength/60+"分");
        chapterService.add(chapter);
        response.getWriter().print("success");
    }

//    音频下载
    @RequestMapping("/downAudio")
    public void downLoadFile(String fileName,HttpServletRequest request,HttpServletResponse response)
         throws Exception{
    // 首先必须找到文件所在路径
        String realPath = request.getSession().getServletContext().getRealPath("/back/album/audio");
    //其次使用输入流读取文件
        FileInputStream fis = new FileInputStream(new File(realPath, fileName));
    //  设置响应头
        response.setHeader("content-disposition","attachment;fileName="+URLEncoder.encode(fileName,"UTF-8"));
    //  响应到客户端使用输出流
      OutputStream os= response.getOutputStream();
    //使用IO中IOUtils工具的copy方法拷贝文件
        org.apache.commons.io.IOUtils.copy(fis,os);
    //  关闭流
        org.apache.commons.io.IOUtils.closeQuietly(fis);

        org.apache.commons.io.IOUtils.closeQuietly(os);
    }
}
