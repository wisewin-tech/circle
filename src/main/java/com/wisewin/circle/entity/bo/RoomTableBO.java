package com.wisewin.circle.entity.bo;

import java.util.Date;

/**
 * Created by Administrator on 2018-11-11.
 */
public class RoomTableBO {
    private Integer id; //操作表的主键
    private Integer roomId;//房间的roomId
    private Integer initialState;//原始状态
    private Integer updateState;//修改之后的状态
    private String updateUser;//修改者
    private Date updateTime;//修改时间

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

    public Integer getInitialState() {
        return initialState;
    }

    public void setInitialState(Integer initialState) {
        this.initialState = initialState;
    }

    public Integer getUpdateState() {
        return updateState;
    }

    public void setUpdateState(Integer updateState) {
        this.updateState = updateState;
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
}
