package com.wisewin.circle.entity.bo;

import com.wisewin.circle.common.base.BaseModel;

import java.util.Date;

public class ModelBO extends BaseModel {
    private Integer id;//模式
    private Integer userId;//
    private String model;//模式car汽车模式，date异性模式，friend同性模式
    private String name;//昵称
    private String describe;//说点什么
    private String  sex;//性别
    private Integer sexCount;//性别修改次数
    private Date  birthday;//生日
    private String constellation;//星座
    private Integer height;//身高(cm)
    private Integer weight;//体重（斤）
    private String education;//教育
    private String birthplace;//出生地
    private String searchDistance;//搜索距离
    private String searchSex;//搜索性别
    private String searchAge;//搜索年龄
    private String sexStatus;//真实性别开关
    private String carCertificationStatus;//汽车认证开关
    private Integer beLikeCount;//被喜欢次数
    private Integer beSuperLikeCount;//被超级喜欢次数
    private Integer superLikeCount;//超级喜欢次数
    private Date superLikeCountTime;//超级喜欢时间
    private Integer beShieldingCount;//被屏蔽次数
    private Date updateTime;//修改时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
}
