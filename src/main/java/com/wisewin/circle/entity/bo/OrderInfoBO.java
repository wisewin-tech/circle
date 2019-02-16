package com.wisewin.circle.entity.bo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yxw on 2018/10/31.
 */
public class OrderInfoBO {
    private Integer id;
    private Integer userId;//用户id
    private Date startTime;//开始时间
    private Date endTime;//结束时间
    private Integer roomId;//房间号
    private String roomName;//房号
    private  String houseName;//房型
    private String userName;//下单人名字
    private String idNumber;//证件号
    private String idType;//证件类型
    private String phoneNumber;
    private Integer memberType;
    private Integer checkIn;//入住方式
    private BigDecimal payCount;
    private Integer payStatus;
    private Integer status;
    private Long snumber;
    private  String number;

    public Long getSnumber() {
        return snumber;
    }

    public void setSnumber(Long snumber) {
        this.snumber = snumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

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

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
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
}
