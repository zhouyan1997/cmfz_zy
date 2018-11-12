package com.baizhi.entity;

import java.util.Date;

public class User {
    private String id;
    private String phone;
    private String username;
    private String password;
    private String salt;
    private String headPic;
    private String nickName;
    private String gender;
    private String home;
    private String sign;
    private String province;
    private String city;
    private String status;
    private Date date;

    public User() {
    }

    public User(String id, String phone, String username, String password, String salt, String headPic, String nickName, String gender, String home, String sign, String province, String city, String status, Date date) {
        this.id = id;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.headPic = headPic;
        this.nickName = nickName;
        this.gender = gender;
        this.home = home;
        this.sign = sign;
        this.province = province;
        this.city = city;
        this.status = status;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", headPic='" + headPic + '\'' +
                ", nickName='" + nickName + '\'' +
                ", gender='" + gender + '\'' +
                ", home='" + home + '\'' +
                ", sign='" + sign + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
