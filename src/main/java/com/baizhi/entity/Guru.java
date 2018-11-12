package com.baizhi.entity;

public class Guru {
    private String id;
    private String name;
    private String headPic;
    private String gender;

    public Guru() {
    }

    public Guru(String id, String name, String headPic, String gender) {
        this.id = id;
        this.name = name;
        this.headPic = headPic;
        this.gender = gender;
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

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", headPic='" + headPic + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
