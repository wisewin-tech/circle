package com.wisewin.circle.entity.bo;

import com.wisewin.circle.common.base.BaseModel;

import java.math.BigDecimal;
import java.util.Date;

public class RoomChangeBO extends BaseModel{

    private Integer id;
    private String  name;  //名字
    private Integer  idType;// 证件类型
    private String  idNumber;//证件号码
    private String  phoneNumber;//手机号
    private Integer  checkIn;//入住方式1 全天房2钟点房3免费房
    private String  operator; //操作员
    private Integer relation;//1是会员2是机构其他普通用户
    private Integer relationId;//会员级别或者机构id
    private Integer meLeval;//会员级别id
    private Integer cooperationId;//合作机构id
    private String cooperationName;//合作机构名字
    private Integer channel;//渠道
    private Date  startTime;//开始时间
    private Date  endTime;//结束时间
    private BigDecimal price;//价格



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Integer checkIn) {
        this.checkIn = checkIn;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getRelation() {
        if(this.relation==null){
            return 0;
        }
        return relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }

    public Integer getRelationId() {
        if(this.relationId==null){
            return  0;
        }
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public Integer getMeLeval() {
        return meLeval;
    }

    public void setMeLeval(Integer meLeval) {
        this.meLeval = meLeval;
    }

    public Integer getCooperationId() {
        return cooperationId;
    }

    public void setCooperationId(Integer cooperationId) {
        this.cooperationId = cooperationId;
    }

    public String getCooperationName() {
        return cooperationName;
    }

    public void setCooperationName(String cooperationName) {
        this.cooperationName = cooperationName;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
