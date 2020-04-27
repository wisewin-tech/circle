package com.wisewin.circle.entity.bo;


import com.wisewin.circle.common.base.BaseModel;

import java.util.List;

public class UserMsgBO extends BaseModel {

    private Long id;
    private Long modelId;
    private String certificationStatus;//用户认证状态
    private String carStatus;//汽车认证状态
    private String describe;//我的签名
    private String sex;//性别
    private String birthday;//生日
    private String constellation;//星座
    private String education;//教育
    private String birthplace;//出生地
    private String latitude;//北纬
    private String longitude;//东经
    private String distance;//距离(米)
    private String name;//昵称

    private String phone;//手机号

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //图片
    private List<String> picture;
    //兴趣
    private List<UserMSgInterest> interest;
    //事件
    private IncidentMsgBO  incident;//


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getCertificationStatus() {
        return certificationStatus;
    }

    public void setCertificationStatus(String certificationStatus) {
        this.certificationStatus = certificationStatus;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPicture() {
        return picture;
    }

    public void setPicture(List<String> picture) {
        this.picture = picture;
    }


    public List<UserMSgInterest> getInterest() {
        return interest;
    }

    public void setInterest(List<UserMSgInterest> interest) {
        this.interest = interest;
    }

    public IncidentMsgBO getIncident() {
        return incident;
    }

    public void setIncident(IncidentMsgBO incident) {
        this.incident = incident;
    }
}
