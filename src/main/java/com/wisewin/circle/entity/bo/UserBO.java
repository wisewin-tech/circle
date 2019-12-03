package com.wisewin.circle.entity.bo;

import com.wisewin.circle.entity.bo.common.base.BaseModel;

import java.util.Date;
import java.util.Map;

public class UserBO extends BaseModel {
    private Long id; //用户
    private String phone; //手机
    private String password;
    private Date createTime;//注册时间
    private Double latitude; //纬度
    private Double longitude; //经度
    private String certificationStatus; //认证状态（yes为已经认证|no为未认证|not未审核|audit审核中）
    private String carStatus;//汽车认证状态（yes为已经认证|no为未认证|not未审核|audit审核中）
    private String userStatus;//yes为被拉黑|no为未拉黑
    private String robotStatus;//yes为机器人，no为用户
    private Map<String,String> frist;
    private String driver;//yes/no 是否是司机
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
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

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getRobotStatus() {
        return robotStatus;
    }

    public void setRobotStatus(String robotStatus) {
        this.robotStatus = robotStatus;
    }

    public Map<String, String> getFrist() {
        return frist;
    }

    public void setFrist(Map<String, String> frist) {
        this.frist = frist;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
