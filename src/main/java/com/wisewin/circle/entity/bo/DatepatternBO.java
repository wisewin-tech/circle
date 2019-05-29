package com.wisewin.circle.entity.bo;

import java.util.Date;

/**
 * Date模式
 */
public class DatepatternBO {

    private Integer id; //Date模式id
    private Integer userId;//用户id
    private Date createTime;// 创建时间
    private Date updateTime; //修改时间
    private String nameurl; //图片地址
    private Double  rank; //排序

    //添加默认模式图片
    public DatepatternBO(Integer userId, String nameurl, Double rank) {
        this.userId = userId;
        this.nameurl = nameurl;
        this.rank = rank;
    }

    public  DatepatternBO(){}


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

    public String getNameurl() {
        return nameurl;
    }

    public void setNameurl(String nameurl) {
        this.nameurl = nameurl;
    }

    public Double getRank() {
        return rank;
    }

    public void setRank(Double rank) {
        this.rank = rank;
    }
}
