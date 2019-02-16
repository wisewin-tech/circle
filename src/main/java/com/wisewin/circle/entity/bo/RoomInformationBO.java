package com.wisewin.circle.entity.bo;
import com.wisewin.circle.common.base.BaseModel;

import java.math.BigDecimal;
import java.util.Date;

public class RoomInformationBO extends BaseModel{
  public static final Integer CHECK_IN_MAIN=1;  //主要登记人
  public static final Integer CHECK_IN_ASSIST=2;//次要登记人
  private Integer id;
  private Long number; //入住编号
  private BigDecimal roomPrice;  //房间价格
  private Integer roomId;//a房间主键
  private String roomType;//房间类型
  private String name;//名字
  private String idNumber;//证件号码
  private Integer idType;//证件类型
  private String phone;//手机号
  private String address;//地址
  private String remark;//备注
  private Date startTime;  //添加时间
  private Date endTime;//抵离时间
  private Integer status;//状态
  private String operator;//操作人
  private Integer main;//主要入住
  private Integer isMember;//是否是会员
  private Integer perr; //同来人数
  private String againstTime;//抵离时间
  private BigDecimal paymentAmount;//支付金额
  private BigDecimal price;
  private Integer isPayment;  //是否支付


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Long getNumber() {
    return number;
  }

  public void setNumber(Long number) {
    this.number = number;
  }

  public BigDecimal getRoomPrice() {
    return roomPrice;
  }

  public void setRoomPrice(BigDecimal roomPrice) {
    this.roomPrice = roomPrice;
  }

  public Integer getRoomId() {
    return roomId;
  }

  public void setRoomId(Integer roomId) {
    this.roomId = roomId;
  }

  public String getRoomType() {
    return roomType;
  }

  public void setRoomType(String roomType) {
    this.roomType = roomType;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
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

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getOperator() {
    return operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
  }

  public Integer getMain() {
    return main;
  }

  public void setMain(Integer main) {
    this.main = main;
  }

  public Integer getIsMember() {
    return isMember;
  }

  public void setIsMember(Integer isMember) {
    this.isMember = isMember;
  }

  public Integer getPerr() {
    return perr;
  }

  public void setPerr(Integer perr) {
    this.perr = perr;
  }

  public String getAgainstTime() {
    return againstTime;
  }

  public void setAgainstTime(String againstTime) {
    this.againstTime = againstTime;
  }

  public BigDecimal getPaymentAmount() {
    return paymentAmount;
  }

  public void setPaymentAmount(BigDecimal paymentAmount) {
    this.paymentAmount = paymentAmount;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Integer getIsPayment() {
    return isPayment;
  }

  public void setIsPayment(Integer isPayment) {
    this.isPayment = isPayment;
  }
}
