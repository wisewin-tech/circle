package com.wisewin.circle.entity.bo;


import java.math.BigDecimal;
import java.util.Date;

public class ChildOrderBO {

  private Integer id;
  private Long number;  //订单号
  private BigDecimal roomPrice=new BigDecimal(0); //房间价格
  private Integer roomId;      //房间id
  private  String roomName;
  private String roomType;    //房间类型
  private String name;       //入住人
  private String address;     //地址
  private String remark;      //备注
  private Date startTime;     //开始时间
  private Date endTime;       //结束时间
  private Integer status;     //状态
  private String operator;    //操作员
  private Integer operatorId;   //操作员id
  private Integer checkIn;      //入住方式
  private BigDecimal payCount=new BigDecimal(0);
  private BigDecimal cash=new BigDecimal(0);       //押金
  private BigDecimal payCash=new BigDecimal(0);    //现金
  private BigDecimal posPay=new BigDecimal(0);    //pos支付
  private BigDecimal roomCharge=new BigDecimal(0); //房费
  private BigDecimal ortherPrice=new BigDecimal(0); //其他费用
  private Integer payStatus;      //订单状态
  private BigDecimal refundprice=new BigDecimal(0);  //已退金额
  private BigDecimal refund=new BigDecimal(0);      //退款（可以是负）
  private  BigDecimal  exemption=new BigDecimal(0); //免单
  private  Date date;
  private Integer  quantity;//数量
  private Integer relation;   //1是会员2是合作机构
  private Integer relationId; //会员id或者合作机构id
  private BigDecimal timeOutPrice=new BigDecimal(0);
  private Date payTime; //结账时间
  private  Integer timeOutState;
  private  Date endTimeRemake;


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

  public String getRoomName() {
    return roomName;
  }

  public void setRoomName(String roomName) {
    this.roomName = roomName;
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

  public Integer getOperatorId() {
    return operatorId;
  }

  public void setOperatorId(Integer operatorId) {
    this.operatorId = operatorId;
  }

  public Integer getCheckIn() {
    return checkIn;
  }

  public void setCheckIn(Integer checkIn) {
    this.checkIn = checkIn;
  }

  public BigDecimal getPayCount() {
    return payCount;
  }

  public void setPayCount(BigDecimal payCount) {
    this.payCount = payCount;
  }

  public BigDecimal getCash() {
    return cash;
  }

  public void setCash(BigDecimal cash) {
    this.cash = cash;
  }

  public BigDecimal getPayCash() {
    return payCash;
  }

  public void setPayCash(BigDecimal payCash) {
    this.payCash = payCash;
  }

  public BigDecimal getPosPay() {
    return posPay;
  }

  public void setPosPay(BigDecimal posPay) {
    this.posPay = posPay;
  }

  public BigDecimal getRoomCharge() {
    return roomCharge;
  }

  public void setRoomCharge(BigDecimal roomCharge) {
    this.roomCharge = roomCharge;
  }

  public BigDecimal getOrtherPrice() {
    return ortherPrice;
  }

  public void setOrtherPrice(BigDecimal ortherPrice) {
    this.ortherPrice = ortherPrice;
  }

  public Integer getPayStatus() {
    return payStatus;
  }

  public void setPayStatus(Integer payStatus) {
    this.payStatus = payStatus;
  }

  public BigDecimal getRefundprice() {
    return refundprice;
  }

  public void setRefundprice(BigDecimal refundprice) {
    this.refundprice = refundprice;
  }

  public BigDecimal getRefund() {
    return refund;
  }

  public void setRefund(BigDecimal refund) {
    this.refund = refund;
  }

  public BigDecimal getExemption() {
    return exemption;
  }

  public void setExemption(BigDecimal exemption) {
    this.exemption = exemption;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Integer getRelation() {
    if(relation==null){
      return  0;
    }
    return relation;
  }

  public void setRelation(Integer relation) {
    this.relation = relation;
  }

  public Integer getRelationId() {
    if(this.relationId==null){
      return 0;
    }
    return relationId;
  }

  public void setRelationId(Integer relationId) {
    this.relationId = relationId;
  }

  public BigDecimal getTimeOutPrice() {
    return timeOutPrice;
  }

  public void setTimeOutPrice(BigDecimal timeOutPrice) {
    this.timeOutPrice = timeOutPrice;
  }

  public Date getPayTime() {
    return payTime;
  }

  public void setPayTime(Date payTime) {
    this.payTime = payTime;
  }

  public Integer getTimeOutState() {
    return timeOutState;
  }

  public void setTimeOutState(Integer timeOutState) {
    this.timeOutState = timeOutState;
  }

  public Date getEndTimeRemake() {
    return endTimeRemake;
  }

  public void setEndTimeRemake(Date endTimeRemake) {
    this.endTimeRemake = endTimeRemake;
  }
}
