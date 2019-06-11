package com.wisewin.circle.entity.bo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class UserMsgBO {

    private Integer id;
    private String name; //姓名
    private Integer age; //年龄
    private String constellation;//星座
    private Date birthday;//生日
    private String work;//工作
    private String school;//学校
    private String describe;//个性签名
    private double distance;//距离
    private List<InteriorInterestBO> interest; //兴趣
    private List<String>  pictures;//照片


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public List<InteriorInterestBO> getInterest() {
        return interest;
    }

    public void setInterest(List<InteriorInterestBO> interest) {
        this.interest = interest;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }
}
