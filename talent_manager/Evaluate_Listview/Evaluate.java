package com.example.talent_manager.Evaluate_Listview;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Evaluate {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private byte[] bitmap;

    private String name;

    private String sex;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getApartment() {
        return apartment;
    }
    private int flag;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    private String date;

    private String apartment;

    private String image;

    private String title;

    private String content;

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public byte[] getBitmap() {
        return bitmap;
    }

    public void setBitmap(byte[] bitmap) {
        this.bitmap = bitmap;
    }

    @Ignore
    public Evaluate(){
        this.image = null;
        this.title = null;
        this.content = null;
        this.bitmap = null;
    }

    @Ignore
    public Evaluate(Evaluate evaluate) {
        this.name = evaluate.name;
        this.sex = evaluate.sex;
        this.date = evaluate.date;
        this.content = evaluate.content;
    }

    public Evaluate(String name, String sex, int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.flag = 1;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
