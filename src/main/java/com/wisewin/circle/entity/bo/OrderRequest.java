package com.wisewin.circle.entity.bo;

import java.util.Date;

/**
 * Created by yxw on 2018/10/31.
 */
public class OrderRequest {
    private Integer orderType;  //订单类型
    private Date outTimeStart;
    private  Date outTimeEnd;
    private  Date timeStart;
    private  Date timeEnd;
    private  Integer checkIn; //入住方式
    private  String userName;  //用户名
    private  String roomName;  //房名
    private  String credentialNo;  //卡号

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getCredentialNo() {
        return credentialNo;
    }

    public void setCredentialNo(String credentialNo) {
        this.credentialNo = credentialNo;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Date getOutTimeStart() {
        return outTimeStart;
    }

    public void setOutTimeStart(Date outTimeStart) {
        this.outTimeStart = outTimeStart;
    }

    public Date getOutTimeEnd() {
        return outTimeEnd;
    }

    public void setOutTimeEnd(Date outTimeEnd) {
        this.outTimeEnd = outTimeEnd;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Integer getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Integer checkIn) {
        this.checkIn = checkIn;
    }
}
