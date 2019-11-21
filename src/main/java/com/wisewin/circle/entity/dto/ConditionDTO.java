package com.wisewin.circle.entity.dto;

/**
 * 用户查询条件
 */
public class ConditionDTO {
    private String whereIs;  //自己的距离
    private String model;    //模式
    private String searchDistance;  //搜索的距离
    private String searchSex;     //搜索的性别
    private String searchAge;    //搜索的年龄
    private String sexStatus;    //搜索真实性认证开关
    private String carCertificationStatus; //搜索车辆认证开关
    private String sex;//自己的性别
    private String driver;
    private String join;


    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getJoin() {
        return join;
    }

    public void setJoin(String join) {
        this.join = join;
    }

    public String getWhereIs() {
        return whereIs;
    }

    public void setWhereIs(String whereIs) {
        this.whereIs = whereIs;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
