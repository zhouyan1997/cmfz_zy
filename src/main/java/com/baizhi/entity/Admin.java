package com.baizhi.entity;

import java.beans.Transient;

public class Admin {
    private String id;
    private String name;
    private String password;
    private String salt;
    private String code;
    public Admin() {
    }

    public Admin(String id, String name, String password, String salt, String code) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.salt = salt;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Transient
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
