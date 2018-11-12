package com.baizhi.test;

import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GuruTest extends BaseTest {
    @Autowired
    private GuruService guruService;
    @Test
    public void insert(){
        Guru guru=new Guru();
        guru.setName("瓜子");
        guru.setHeadPic("/back/guru/img/4.jpg");
        guru.setGender("男");
        guruService.add(guru);
    }
    @Test
    public void findAll(){
        List<Guru> bypage = guruService.findBypage(2,2);
        for (Guru guru : bypage) {
            System.out.println(guru);
        }
    }
}
