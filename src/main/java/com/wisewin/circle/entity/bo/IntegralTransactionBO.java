package com.wisewin.circle.entity.bo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yxw on 2018/10/23.
 */
public class IntegralTransactionBO {
    private  Integer id;
    private  Integer userId;
    private  Long orderId;
     private BigDecimal deal;//交易金额
    private  Integer oddintegral;//剩余积分
    private Date createTime;
    private  Integer state;
    private  String  payinfo;
    private  String remark;

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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getDeal() {
        return deal;
    }

    public void setDeal(BigDecimal deal) {
        this.deal = deal;
    }

    public Integer getOddintegral() {
        return oddintegral;
    }

    public void setOddintegral(Integer oddintegral) {
        this.oddintegral = oddintegral;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPayinfo() {
        return payinfo;
    }

    public void setPayinfo(String payinfo) {
        this.payinfo = payinfo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
