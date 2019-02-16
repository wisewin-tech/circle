package com.wisewin.circle.entity.bo;


import com.wisewin.circle.common.base.BaseModel;

import java.math.BigDecimal;
import java.util.Date;

public class SubscribeBO extends BaseModel{
  public static final Integer IN_SUCCESS=2;//入住成功
  public static final Integer NOT_CHECK_IN=3;//未入住
  public static final Integer CANCEL=4;//取消预约

  private Integer id;
  private Integer roomType;  //房间类型
  private String roomNumber; //房间编号
  private Integer userId;    //用户id
  private String name;      //入住人名字
  private String phoneNumber;   //手机号码
  private Integer roomId;      //房间id
  private Date createTime;      //创建时间
  private Date checkinTime;     //入住时间
  private BigDecimal price;     //价格
  private Date leaveTime;        //离开时间
  private Integer inway;        //入住方式
  private Integer daycount;     //入住天数
  private Long orderNumber;     //订单编号
  private Integer isPayment;    //是否支付
  private Integer status;      //状态
  private String  typeName;    //房型名字
  private String certificateNumber;   //证件号码
  private Integer certificateType;//证件类型
  private String orderNumberStr;  //订单编号字符串
  private String arriveTime;  //抵离时间
  private String checkPersson;  //入住人
  private Integer  channel;//渠道
  private Integer isMember;//是否是会员  1是会员2不是会员
  private String remark;  //备注


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getRoomType() {
    return roomType;
  }

  public void setRoomType(Integer roomType) {
    this.roomType = roomType;
  }

  public String getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
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

  public Integer getRoomId() {
    return roomId;
  }

  public void setRoomId(Integer roomId) {
    this.roomId = roomId;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getCheckinTime() {
    return checkinTime;
  }

  public void setCheckinTime(Date checkinTime) {
    this.checkinTime = checkinTime;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Date getLeaveTime() {
    return leaveTime;
  }

  public void setLeaveTime(Date leaveTime) {
    this.leaveTime = leaveTime;
  }

  public Integer getInway() {
    return inway;
  }

  public void setInway(Integer inway) {
    this.inway = inway;
  }

  public Integer getDaycount() {
    return daycount;
  }

  public void setDaycount(Integer daycount) {
    this.daycount = daycount;
  }

  public Long getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(Long orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Integer getIsPayment() {
    return isPayment;
  }

  public void setIsPayment(Integer isPayment) {
    this.isPayment = isPayment;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  public String getCertificateNumber() {
    return certificateNumber;
  }

  public void setCertificateNumber(String certificateNumber) {
    this.certificateNumber = certificateNumber;
  }

  public Integer getCertificateType() {
    return certificateType;
  }

  public void setCertificateType(Integer certificateType) {
    this.certificateType = certificateType;
  }

  public String getOrderNumberStr() {
    return orderNumberStr;
  }

  public void setOrderNumberStr(String orderNumberStr) {
    this.orderNumberStr = orderNumberStr;
  }

  public String getArriveTime() {
    return arriveTime;
  }

  public void setArriveTime(String arriveTime) {
    this.arriveTime = arriveTime;
  }

  public String getCheckPersson() {
    return checkPersson;
  }

  public void setCheckPersson(String checkPersson) {
    this.checkPersson = checkPersson;
  }

  public Integer getChannel() {
    return channel;
  }

  public void setChannel(Integer channel) {
    this.channel = channel;
  }

  public Integer getIsMember() {
    return isMember;
  }

  public void setIsMember(Integer isMember) {
    this.isMember = isMember;
  }
}
