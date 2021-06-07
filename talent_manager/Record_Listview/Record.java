package com.example.talent_manager.Record_Listview;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Record implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String GZJX;
    private String JHWCL;
    private String SKWCL;
    private String XSFYL;
    private String XKHKZ;
    private String SCXXSJ;
    //private String KQQK;
    private String CQ;
    private String KG;


    public String getGZJX() {
        return GZJX;
    }

    public void setGZJX(String GZJX) {
        this.GZJX = GZJX;
    }

    public String getJHWCL() {
        return JHWCL;
    }

    public void setJHWCL(String JHWCL) {
        this.JHWCL = JHWCL;
    }

    public String getSKWCL() {
        return SKWCL;
    }

    public void setSKWCL(String SKWCL) {
        this.SKWCL = SKWCL;
    }

    public String getXSFYL() {
        return XSFYL;
    }

    public void setXSFYL(String XSFYL) {
        this.XSFYL = XSFYL;
    }

    public String getXKHKZ() {
        return XKHKZ;
    }

    public void setXKHKZ(String XKHKZ) {
        this.XKHKZ = XKHKZ;
    }

    public String getSCXXSJ() {
        return SCXXSJ;
    }

    public void setSCXXSJ(String SCXXSJ) {
        this.SCXXSJ = SCXXSJ;
    }





    public String getCQ() {
        return CQ;
    }

    public void setCQ(String CQ) {
        this.CQ = CQ;
    }

    public String getKG() {
        return KG;
    }

    public void setKG(String KG) {
        this.KG = KG;
    }

    public String getQJ() {
        return QJ;
    }

    public void setQJ(String QJ) {
        this.QJ = QJ;
    }

    public String getCDZT() {
        return CDZT;
    }

    public void setCDZT(String CDZT) {
        this.CDZT = CDZT;
    }

    private String QJ;
    private String CDZT;


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

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    private String date;

    private String apartment;


    private String content;

    public byte[] getBitmap() {
        return bitmap;
    }

    public void setBitmap(byte[] bitmap) {
        this.bitmap = bitmap;
    }

    public Record(){
        this.content = null;
        this.bitmap = null;
    }

    @Ignore
    public Record(Record record) {
        this.name = record.name;
        this.sex = record.sex;
        this.date = record.date;
        this.content = record.content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
