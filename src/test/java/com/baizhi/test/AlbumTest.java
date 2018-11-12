package com.baizhi.test;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class AlbumTest extends BaseTest{
    @Autowired
    private AlbumService albumService;
    @Test
    public void insert(){
        Album album=new Album();
        album.setId("1");
        album.setTitle("甘露明珠");
        album.setCoverImg("/back/album/img/A-1.jpg");
        album.setPublishDate(new Date());
        album.setAuthor("第十五世香根活佛");
        album.setBrief("法律是苏联红军基本就开始");
        album.setScore("*****");
        album.setBroadCast("王猛师兄");
        album.setCounts(31);
        album.setStatus("y");
        albumService.add(album);
    }
    @Test
    public void findAll(){
        List<Album> bypage = albumService.findBypage(1,2);
        for (Album album : bypage) {
            System.out.println(album);
        }

    }
    @Test
    public void queryone(){
        Album queryone = albumService.findone("1");
        System.out.println(queryone);

    }

}
