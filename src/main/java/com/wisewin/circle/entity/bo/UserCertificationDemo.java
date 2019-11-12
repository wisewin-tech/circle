package com.wisewin.circle.entity.bo;

import java.util.Date;

/**
 * @Author: Wang bin
 * @date: Created in 13:21 2019/11/12
 */
public class UserCertificationDemo {
    private Integer id;
    private String demoPicture; //姿势图片
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDemoPicture() {
        return demoPicture;
    }

    public void setDemoPicture(String demoPicture) {
        this.demoPicture = demoPicture;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "UserCertificationDemo{" +
                "id=" + id +
                ", demoPicture='" + demoPicture + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
