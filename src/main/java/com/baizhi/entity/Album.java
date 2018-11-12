package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Album {
    private String id;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date publishDate;
    private String coverImg;
    private int  counts;
    private String score;
    private String author;
    private String broadCast;
    private String brief;
    private String status;
    private List<Chapter> children;

    public Album() {
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", publishDate=" + publishDate +
                ", coverImg='" + coverImg + '\'' +
                ", counts=" + counts +
                ", score='" + score + '\'' +
                ", author='" + author + '\'' +
                ", broadCast='" + broadCast + '\'' +
                ", brief='" + brief + '\'' +
                ", status='" + status + '\'' +
                ", children=" + children +
                '}';
    }

    public Album(String id, String title, Date publishDate, String coverImg, int counts, String score, String author, String broadCast, String brief, String status, List<Chapter> children) {
        this.id = id;
        this.title = title;
        this.publishDate = publishDate;
        this.coverImg = coverImg;
        this.counts = counts;
        this.score = score;
        this.author = author;
        this.broadCast = broadCast;
        this.brief = brief;
        this.status = status;
        this.children = children;
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

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadCast() {
        return broadCast;
    }

    public void setBroadCast(String broadCast) {
        this.broadCast = broadCast;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }
}
