package com.wisewin.circle.entity.bo;


import java.util.Date;

//用户模式
public class PatternBO {

    private Integer id;  //用户模式
    private Integer userid; //用户id
    private Date updateTime; //最后修改时间
    private String describe; //描述
    private String interest; //兴起
    private String  type; //模式  DATE/BFF模式


    public PatternBO(Integer userid, String type) {
        this.userid = userid;
        this.type = type;
    }

    public PatternBO(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
