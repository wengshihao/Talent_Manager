package com.example.talent_manager;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Chat {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo()
    private String name;
    @ColumnInfo()
    private String sex;
    @ColumnInfo()
    private String age;
    @ColumnInfo()
    private String skill;
    @ColumnInfo()
    private String company;

    @ColumnInfo()
    private String gangwei;
    @ColumnInfo()
    private String xinzi;
    @ColumnInfo()
    private String pingjia;

    public Chat(String name, String sex, String age, String skill, String company, String gangwei, String xinzi, String pingjia) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.skill = skill;
        this.company = company;
        this.gangwei = gangwei;
        this.xinzi = xinzi;
        this.pingjia = pingjia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getGangwei() {
        return gangwei;
    }

    public void setGangwei(String gangwei) {
        this.gangwei = gangwei;
    }

    public String getXinzi() {
        return xinzi;
    }

    public void setXinzi(String xinzi) {
        this.xinzi = xinzi;
    }

    public String getPingjia() {
        return pingjia;
    }

    public void setPingjia(String pingjia) {
        this.pingjia = pingjia;
    }
}
