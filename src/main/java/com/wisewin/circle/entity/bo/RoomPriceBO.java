package com.wisewin.circle.entity.bo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2018-10-25.
 */
public class RoomPriceBO {

    private Integer id;//房间价格表中的主键
    private Integer roomId;//房间id 也就是room_type表中的主键id
    private Integer houseTypeId;//房型主键id
    private Date startTime;//开始时间
    private Date endTime;//结束时间
    private BigDecimal price;//房间价格
    private Integer level;//删除字段
    private Integer state;

    public Integer getHouseTypeId() {
        return houseTypeId;
    }

    public void setHouseTypeId(Integer houseTypeId) {
        this.houseTypeId = houseTypeId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }




}
