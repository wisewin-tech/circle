package com.wisewin.circle.entity.bo;


import com.wisewin.circle.common.base.BaseModel;

import java.math.BigDecimal;
import java.util.Date;

public class ReserveMoneyBO extends BaseModel {
  public static final Integer  ADD_MONEY=1;//增加
  public static final Integer  SUBTRACT_MONEY=2;//减少

  private Integer id;
  private Integer touchIn;  // 增减金额
  private Date createTime;  //操作时间
  private BigDecimal money; //金额
  private BigDecimal reserveMoney;  //当前总金额
  private String remark;     //备注
  private String operator;   //操作人
  private Integer operatorId;//操作人id
  private Integer hotel;     //酒店id


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getTouchIn() {
    return touchIn;
  }

  public void setTouchIn(Integer touchIn) {
    this.touchIn = touchIn;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public BigDecimal getMoney() {
    return money;
  }

  public void setMoney(BigDecimal money) {
    this.money = money;
  }

  public BigDecimal getReserveMoney() {
    return reserveMoney;
  }

  public void setReserveMoney(BigDecimal reserveMoney) {
    this.reserveMoney = reserveMoney;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
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

  public Integer getHotel() {
    return hotel;
  }

  public void setHotel(Integer hotel) {
    this.hotel = hotel;
  }
}
