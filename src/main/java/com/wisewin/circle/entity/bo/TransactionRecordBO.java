package com.wisewin.circle.entity.bo;


import com.wisewin.circle.common.base.BaseModel;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionRecordBO extends BaseModel{

  private Integer id;
  private Date operationTime;  //操作时间
  private BigDecimal collectMoney; //收入
  private BigDecimal giveChange;   //找出
  private Integer payment;         //支付方式
  private String cause;            //原因
  private String operator;         //操作员
  private Integer operatorId;     //操作员id
  private Integer card;           // 制卡


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getOperationTime() {
    return operationTime;
  }

  public void setOperationTime(Date operationTime) {
    this.operationTime = operationTime;
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

  public Integer getPayment() {
    return payment;
  }

  public void setPayment(Integer payment) {
    this.payment = payment;
  }

  public String getCause() {
    return cause;
  }

  public void setCause(String cause) {
    this.cause = cause;
  }

  public String getOperator() {
    return operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
  }

  public Integer getOperatorId() {
    return operatorId;
  }

  public void setOperatorId(Integer operatorId) {
    this.operatorId = operatorId;
  }

  public Integer getCard() {
    return card;
  }

  public void setCard(Integer card) {
    this.card = card;
  }

}
