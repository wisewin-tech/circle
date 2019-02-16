package com.wisewin.circle.entity.bo;


import java.util.Date;

/**
 * Created by Administrator on 2018-11-02.
 */
public class RoomStateBO {
    private Integer id;//房间价格表中的主键
    private Integer roomId;//房间id 也就是room_type表中的主键id
    private Date startTime;//开始时间
    private Date endTime;//结束时间
    private Integer level;//删除字段
    private Integer state;//房间状态

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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
