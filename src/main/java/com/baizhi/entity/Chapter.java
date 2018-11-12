package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Chapter {
    private String id;
    private String title;
    private double size;
    private int number;
    private String duration;
    private String downPath;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date uploadTime;
    private  String album_id;
    private Album album;

    public Chapter() {
    }

    public Chapter(String id, String title, double size, int number, String duration, String downPath, Date uploadTime, String album_id, Album album) {
        this.id = id;
        this.title = title;
        this.size = size;
        this.number = number;
        this.duration = duration;
        this.downPath = downPath;
        this.uploadTime = uploadTime;
        this.album_id = album_id;
        this.album = album;
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

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDownPath() {
        return downPath;
    }

    public void setDownPath(String downPath) {
        this.downPath = downPath;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", size=" + size +
                ", number=" + number +
                ", duration='" + duration + '\'' +
                ", downPath='" + downPath + '\'' +
                ", uploadTime=" + uploadTime +
                ", album_id='" + album_id + '\'' +
                ", album=" + album +
                '}';
    }
}
