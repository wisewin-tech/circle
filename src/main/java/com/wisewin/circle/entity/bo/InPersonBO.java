package com.wisewin.circle.entity.bo;


import com.wisewin.circle.common.base.BaseModel;

import java.util.Date;

public class InPersonBO extends BaseModel {

  private Integer id;
  private String name;//名字
  private Integer idType;//证件类型
  private String idNumber;//证件号码
  private String phoneNumber;//手机号码
  private String site;//地址
  private String remark;//备注
  private Integer status;//转态
  private Integer roomId;//房间id
  private Long number;//入住编号
  private Date addtime;//添加时间

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getRoomId() {
    return roomId;
  }

  public void setRoomId(Integer roomId) {
    this.roomId = roomId;
  }

  public Long getNumber() {
    return number;
  }

  public void setNumber(Long number) {
    this.number = number;
  }

  public Date getAddtime() {
    return addtime;
  }

  public void setAddtime(Date addtime) {
    this.addtime = addtime;
  }
}
