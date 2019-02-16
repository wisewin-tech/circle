package com.wisewin.circle.entity.bo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by yxw on 2018/11/5.
 */
public class StampResponseBO {
    private Integer childOrderId;
    private  String roomName;//房型
    private String userName;//入住名字
    private Date startTime;//开始时间
    private List<OrderManageBO> orderManageBOs;
    private  BigDecimal payCount;
    private  Long number;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public BigDecimal getPayCount() {
        return payCount;
    }

    public void setPayCount(BigDecimal payCount) {
        this.payCount = payCount;
    }

    public Integer getChildOrderId() {
        return childOrderId;
    }

    public void setChildOrderId(Integer childOrderId) {
        this.childOrderId = childOrderId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public List<OrderManageBO> getOrderManageBOs() {
        return orderManageBOs;
    }

    public void setOrderManageBOs(List<OrderManageBO> orderManageBOs) {
        this.orderManageBOs = orderManageBOs;
    }
}
