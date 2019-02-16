package com.wisewin.circle.entity.bo;


import com.wisewin.circle.common.base.BaseModel;

import java.math.BigDecimal;

public class DiscountBO  extends BaseModel{

  private Integer id;
  private Integer roomTypeId;  //房间类型id
  private Integer memberRankId;//折扣id
  private BigDecimal discount;   //折扣
  private BigDecimal price;     //折扣价格


  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getRoomTypeId() {
    return roomTypeId;
  }

  public void setRoomTypeId(Integer roomTypeId) {
    this.roomTypeId = roomTypeId;
  }

  public Integer getMemberRankId() {
    return memberRankId;
  }

  public void setMemberRankId(Integer memberRankId) {
    this.memberRankId = memberRankId;
  }

  public BigDecimal getDiscount() {
    return discount;
  }

  public void setDiscount(BigDecimal discount) {
    this.discount = discount;
  }


}
