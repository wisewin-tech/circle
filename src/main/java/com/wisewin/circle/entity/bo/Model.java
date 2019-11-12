package com.wisewin.circle.entity.bo;

import org.apache.poi.hssf.record.chart.DatRecord;

import java.util.Date;

/**
 * @Author: Wang bin
 * @date: Created in 13:34 2019/11/11
 */
public class Model {
    private Integer id;
    private String model;
    private String describe;
    private String sex;
    private Integer sexCount;
    private Date birthday;
    private String constellation;
    private Integer height;
    private Integer weight;
    private String education;
    private String birthplace;
    private String searchDistance;
    private String searchSex;
    private String searchAge;
    private String sexStatus;
    private String carCertificationStatus;
    private Integer beLikeCount;
    private Integer beSuperLikeCount;
    private Integer superLikeCount;
    private Date superLikeCountTime;
    private Integer beShieldingCount;
    private Date updateTime;
    private Integer userId;
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getSexCount() {
        return sexCount;
    }

    public void setSexCount(Integer sexCount) {
        this.sexCount = sexCount;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getSearchDistance() {
        return searchDistance;
    }

    public void setSearchDistance(String searchDistance) {
        this.searchDistance = searchDistance;
    }

    public String getSearchSex() {
        return searchSex;
    }

    public void setSearchSex(String searchSex) {
        this.searchSex = searchSex;
    }

    public String getSearchAge() {
        return searchAge;
    }

    public void setSearchAge(String searchAge) {
        this.searchAge = searchAge;
    }

    public String getSexStatus() {
        return sexStatus;
    }

    public void setSexStatus(String sexStatus) {
        this.sexStatus = sexStatus;
    }

    public String getCarCertificationStatus() {
        return carCertificationStatus;
    }

    public void setCarCertificationStatus(String carCertificationStatus) {
        this.carCertificationStatus = carCertificationStatus;
    }

    public Integer getBeLikeCount() {
        return beLikeCount;
    }

    public void setBeLikeCount(Integer beLikeCount) {
        this.beLikeCount = beLikeCount;
    }

    public Integer getBeSuperLikeCount() {
        return beSuperLikeCount;
    }

    public void setBeSuperLikeCount(Integer beSuperLikeCount) {
        this.beSuperLikeCount = beSuperLikeCount;
    }

    public Integer getSuperLikeCount() {
        return superLikeCount;
    }

    public void setSuperLikeCount(Integer superLikeCount) {
        this.superLikeCount = superLikeCount;
    }

    public Date getSuperLikeCountTime() {
        return superLikeCountTime;
    }

    public void setSuperLikeCountTime(Date superLikeCountTime) {
        this.superLikeCountTime = superLikeCountTime;
    }

    public Integer getBeShieldingCount() {
        return beShieldingCount;
    }

    public void setBeShieldingCount(Integer beShieldingCount) {
        this.beShieldingCount = beShieldingCount;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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



    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", describe='" + describe + '\'' +
                ", sex='" + sex + '\'' +
                ", sexCount=" + sexCount +
                ", birthday=" + birthday +
                ", constellation='" + constellation + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", education='" + education + '\'' +
                ", birthplace='" + birthplace + '\'' +
                ", searchDistance='" + searchDistance + '\'' +
                ", searchSex='" + searchSex + '\'' +
                ", searchAge='" + searchAge + '\'' +
                ", sexStatus='" + sexStatus + '\'' +
                ", carCertificationStatus='" + carCertificationStatus + '\'' +
                ", beLikeCount=" + beLikeCount +
                ", beSuperLikeCount=" + beSuperLikeCount +
                ", superLikeCount=" + superLikeCount +
                ", superLikeCountTime=" + superLikeCountTime +
                ", beShieldingCount=" + beShieldingCount +
                ", updateTime=" + updateTime +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                '}';
    }
}
