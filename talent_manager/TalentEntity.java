package com.example.talent_manager;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TalentEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String work, salary, address, year, education, demand, welfare, company;
    private int num;

    public TalentEntity(String work, String salary, String address, String year, String education,
                        String demand, String welfare, String company, int num) {
        this.work = work;
        this.salary = salary;
        this.address = address;
        this.year = year;
        this.education = education;
        this.num = num;
        this.demand = demand;
        this.company = company;
        this.welfare = welfare;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }
}
