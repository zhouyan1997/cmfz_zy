package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Article {
    private String id;
    private String title;
    private String imgPath;
    private String content;
    /*用来转换日期格式*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date publishDate;
    private String guru_id;
    private String status;
    private Guru guru;

    public Article() {
    }

    public Article(String id, String title, String imgPath, String content, Date publishDate, String guru_id, String status, Guru guru) {
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.content = content;
        this.publishDate = publishDate;
        this.guru_id = guru_id;
        this.status = status;
        this.guru = guru;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getGuru_id() {
        return guru_id;
    }

    public void setGuru_id(String guru_id) {
        this.guru_id = guru_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Guru getGuru() {
        return guru;
    }

    public void setGuru(Guru guru) {
        this.guru = guru;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", content='" + content + '\'' +
                ", publishDate=" + publishDate +
                ", guru_id='" + guru_id + '\'' +
                ", status='" + status + '\'' +
                ", guru=" + guru +
                '}';
    }
}
