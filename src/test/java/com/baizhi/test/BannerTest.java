package com.baizhi.test;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class BannerTest extends BaseTest{
    @Autowired
    private BannerService bannerService;
    @Test
    public void testsave(){
        Banner banner=new Banner();
        banner.setTitle("显宗法师像");
        banner.setImgPath("back/banner/img/2");
        banner.setDecs("显宗法师像");
        banner.setStatus("");
        banner.setDate(new Date());
        bannerService.add(banner);
    }
    @Test
    public void testfindAll(){
        List<Banner> bypage = bannerService.findBypage(2,2);
        for (Banner banner : bypage) {
            System.out.println(banner);
        }
    }
    @Test
    public void delete() {
        bannerService.remove("e68344fa-1aea-4d61-98aa-1ae9de124adc");
    }
    @Test
    public void update(){
        Banner banner= new Banner();
        banner.setId("2c144d49-6cd5-4d46-84da-0b08da6c74a7");
        banner.setTitle("经院转经轮");
        banner.setImgPath("back/banner/img/5");
        banner.setDecs("经院转经轮");
        banner.setStatus("y");
        banner.setDate(new Date());
        bannerService.motify(banner);
    }
}
