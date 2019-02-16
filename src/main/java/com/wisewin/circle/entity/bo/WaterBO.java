package com.wisewin.circle.entity.bo;

import com.wisewin.circle.common.base.BaseModel;

import java.math.BigDecimal;

public class WaterBO  extends BaseModel{

    public static final Integer NETWORK_PAY=1;
    public static final Integer POST_PAY=2;
    public static final Integer CASH_PAY=3;
   // 支付方式1网络支付,2pos支付,3现金
    private Integer payment;  //支付方式
    private BigDecimal collectMoney; //收入金额
    private BigDecimal giveChange;//  找出金额
    private Integer card;       //制卡数


    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public BigDecimal getCollectMoney() {
        return collectMoney;
    }

    public void setCollectMoney(BigDecimal collectMoney) {
        this.collectMoney = collectMoney;
    }

    public BigDecimal getGiveChange() {
        return giveChange;
    }

    public void setGiveChange(BigDecimal giveChange) {
        this.giveChange = giveChange;
    }

    public Integer getCard() {
        return card;
    }

    public void setCard(Integer card) {
        this.card = card;
    }
}
