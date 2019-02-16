package com.wisewin.circle.entity.bo;

import java.util.Date;

/**
 * Created by Administrator on 2018-11-13.
 */
public class RoomLockBO {
    private Integer id; //锁房表的主键
    private Integer roomId;//房间的roomId
    private Date startTime;//开始时间
    private Date endTime;//结束时间
    private String updateUser;//修改者
    private Date updateTime;//修改时间
    private Integer lockState;//锁房的状态

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

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getLockState() {
        return lockState;
    }

    public void setLockState(Integer lockState) {
        this.lockState = lockState;
    }
}
