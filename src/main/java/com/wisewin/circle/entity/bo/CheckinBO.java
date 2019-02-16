package com.wisewin.circle.entity.bo;


import com.wisewin.circle.common.base.BaseModel;

import java.math.BigDecimal;
import java.util.Date;

public class CheckinBO extends BaseModel {
  //入住小时数3-6
  public static final Integer MIN_HOURAGE=3;
  public static final Integer MAX_HOURAGE=6;
  public static final Integer ALL_DAY_ROOM=1;
  public static final Integer HOUR_ROOM=2;

  public static final Integer ON_PAYMENT=1;
  private Date  startTime;//入住时间
  private Integer id;     //主键
  private Integer roomId; //房间id
  private String teamName;//团队名
  private String expense;//公费方式
  private String name;//入住人名字
  private Integer idType;//证件类型
  private String idNumber;//证件号码
  private String phoneNumber;//手机号码
  private String special;//特殊要求
  private String expenseCalendar;//消费记录
  private String gender;//性别
  private Date birthday;//生日
  private String email;//邮箱
  private String nativePlace;//籍贯
  private String wechat;//微信
  private String qq;//QQ号
  private String nationality;//国籍
  private String hobby;//爱好
  private String nation;//民族
  private String site;//地址
  private String remark;//备注
  private String vehicleNumber;//车牌号
  private Integer cnId;//合作机构
  private Integer source;//客源
  private Integer channel;//渠道
  private Integer dayNumber;//天数
  private Date leaveDate;//离店时间
  private Integer inWay;//入住方式
  private String inStandard;//入住标准
  private String ordering;//接单员
  private Integer status;//状态
  private Date addDate;//添加时间
  private Long inNumber;//入住编号
  private Long orderNumber;//订单编号
  private BigDecimal price;//支付钱数
  private Integer payStaus;//支付状态
  private Integer hourage;//小时数
  private String orderNumberStr;//订单号字符串


  public String getOrderNumberStr() {
    return orderNumberStr;
  }

  public void setOrderNumberStr(String orderNumberStr) {
    this.orderNumberStr = orderNumberStr;
  }

  public Integer getHourage() {
    return hourage;
  }

  public void setHourage(Integer hourage) {
    this.hourage = hourage;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getRoomId() {
    return roomId;
  }

  public void setRoomId(Integer roomId) {
    this.roomId = roomId;
  }

  public String getTeamName() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

  public String getExpense() {
    return expense;
  }

  public void setExpense(String expense) {
    this.expense = expense;
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

  public String getSpecial() {
    return special;
  }

  public void setSpecial(String special) {
    this.special = special;
  }

  public String getExpenseCalendar() {
    return expenseCalendar;
  }

  public void setExpenseCalendar(String expenseCalendar) {
    this.expenseCalendar = expenseCalendar;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getNativePlace() {
    return nativePlace;
  }

  public void setNativePlace(String nativePlace) {
    this.nativePlace = nativePlace;
  }

  public String getWechat() {
    return wechat;
  }

  public void setWechat(String wechat) {
    this.wechat = wechat;
  }

  public String getQq() {
    return qq;
  }

  public void setQq(String qq) {
    this.qq = qq;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public String getHobby() {
    return hobby;
  }

  public void setHobby(String hobby) {
    this.hobby = hobby;
  }

  public String getNation() {
    return nation;
  }

  public void setNation(String nation) {
    this.nation = nation;
  }

  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getVehicleNumber() {
    return vehicleNumber;
  }

  public void setVehicleNumber(String vehicleNumber) {
    this.vehicleNumber = vehicleNumber;
  }

  public Integer getCnId() {
    return cnId;
  }

  public void setCnId(Integer cnId) {
    this.cnId = cnId;
  }

  public Integer getSource() {
    return source;
  }

  public void setSource(Integer source) {
    this.source = source;
  }

  public Integer getChannel() {
    return channel;
  }

  public void setChannel(Integer channel) {
    this.channel = channel;
  }

  public Integer getDayNumber() {
    return dayNumber;
  }

  public void setDayNumber(Integer dayNumber) {
    this.dayNumber = dayNumber;
  }

  public Date getLeaveDate() {
    return leaveDate;
  }

  public void setLeaveDate(Date leaveDate) {
    this.leaveDate = leaveDate;
  }

  public Integer getInWay() {
    return inWay;
  }

  public void setInWay(Integer inWay) {
    this.inWay = inWay;
  }

  public String getInStandard() {
    return inStandard;
  }

  public void setInStandard(String inStandard) {
    this.inStandard = inStandard;
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

  public Date getAddDate() {
    return addDate;
  }

  public void setAddDate(Date addDate) {
    this.addDate = addDate;
  }

  public Long getInNumber() {
    return inNumber;
  }

  public void setInNumber(Long inNumber) {
    this.inNumber = inNumber;
  }

  public Long getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(Long orderNumber) {
    this.orderNumber = orderNumber;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Integer getPayStaus() {
    return payStaus;
  }

  public void setPayStaus(Integer payStaus) {
    this.payStaus = payStaus;
  }
}
