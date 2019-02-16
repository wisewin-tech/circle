package com.wisewin.circle.entity.bo;

import com.wisewin.circle.common.base.BaseModel;

import java.math.BigDecimal;
import java.util.Date;


public class OrderBO extends BaseModel {
    public static final Integer NON_PAYMEN=1;//未付款
    public static final Integer ACCOUNT_PAID=2;//已付款
    public static final BigDecimal CASH_PLEDGE=new BigDecimal("100");
    public static final Integer CASH_PAYMENT=1; //现金支付
    public static final Integer POST_PAYMENT=2;  //post支付
    public static final Integer IS_MEMBER=2;
    public static final Integer NON_MEMBER=1;
    public static final Integer CLOCK_ROOM=1;//全天房
    public static final Integer HOUR_ROOM=2;//钟点房
    public static final Integer FREE_ROOM=3;//免费房
    public static final Integer IS_COOPERATION_ORGANIZATION=2;
    public static final Integer NORMAL_STATUS=1;
    public static final Integer SUBSCRIBE_STATUS=3;

    private Integer id;
    private Integer userId;  //用户id
    private String name;     //订单人名字
    private String phoneNumber;  //手机号码
    private Date createTime;     //创建时间
    private Integer payStatus;   //付款状态
    private Long number;          //订单号
    private Integer channel;      //渠道
    private String idNumber;      //证件号码
    private Integer idType;     //证件类型
    private Integer memberType;   //客户来源
    private Integer operatorId;    //操作人id
    private String ordering;      //操作人
    private Integer status;      //状态
    private Integer relation;   //1是会员2是合作机构
    private Integer relationId; //会员id或者合作机构id


    public Integer getRelation() {
        return relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getOrdering() {
        return ordering;
    }

    public void setOrdering(String ordering) {
        this.ordering = ordering;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
