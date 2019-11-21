package com.wisewin.circle.entity.bo;

import com.wisewin.circle.common.base.BaseModel;

public class ScreenParamBO extends BaseModel {
    private Long userId;
    private String model;
    private String searchDistance;//搜索距离
    private String searchSex;//搜索性别
    private String searchAge;//搜索年龄
    private String sexStatus;//真实性别开关
    private String carCertificationStatus;//汽车认证开关

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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
}
