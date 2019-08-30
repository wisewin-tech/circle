package com.wisewin.circle.entity.bo;

import com.wisewin.circle.common.base.BaseModel;

/**
 * 活跃 匹配 注册 数 记录表
 * */
public class StatisticalRecords extends BaseModel {
    private Integer id;
    private Integer activeCount=0;//活跃数
    private Integer registrationCount=0;//注册数
    private Integer pairingCount=0;//配对数
    private String createTime;//当天日期

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActiveCount() {
        return activeCount;
    }

    public void setActiveCount(Integer activeCount) {
        this.activeCount = activeCount;
    }

    public Integer getRegistrationCount() {
        return registrationCount;
    }

    public void setRegistrationCount(Integer registrationCount) {
        this.registrationCount = registrationCount;
    }

    public Integer getPairingCount() {
        return pairingCount;
    }

    public void setPairingCount(Integer pairingCount) {
        this.pairingCount = pairingCount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
