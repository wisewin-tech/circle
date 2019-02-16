package com.wisewin.circle.entity.bo;

import com.wisewin.circle.common.base.BaseModel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2018-10-22.
 */
public class RoomBO extends BaseModel {

    private  Integer id;//房间主键id
    private  Integer floorId;//楼层数
    private  Integer roomId;//房间类型主键id
    private  Integer state;//房间状态
    private  Date createTime;//创建时间
    private  String imgUrl;//图片路径
    private  String roomFacility;//房间设施
    private  String roomFeatures;//房间特性
    private  String comment;//备注
    private  Integer freeRoomResult;//是否成为免费房间
    private  BigDecimal price;//钟点房价格
    private  Integer timeRoomResult;//是否是钟点房
    private  BigDecimal workdayPrice;//工作日价格
    private  BigDecimal weekendPrice;//周末价格
    private  Integer status;
    private  String roomNum;//房间号码
    private  String roomTypeName;//房间类型名字
    private  Integer state1;
    private  Integer lockState;//锁房状态

    public Integer getLockState() {
        return lockState;
    }

    public void setLockState(Integer lockState) {
        this.lockState = lockState;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTimeRoomResult() {
        return timeRoomResult;
    }

    public void setTimeRoomResult(Integer timeRoomResult) {
        this.timeRoomResult = timeRoomResult;
    }

    public BigDecimal getWorkdayPrice() {
        return workdayPrice;
    }

    public void setWorkdayPrice(BigDecimal workdayPrice) {
        this.workdayPrice = workdayPrice;
    }

    public BigDecimal getWeekendPrice() {
        return weekendPrice;
    }

    public void setWeekendPrice(BigDecimal weekendPrice) {
        this.weekendPrice = weekendPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getRoomFacility() {
        return roomFacility;
    }

    public void setRoomFacility(String roomFacility) {
        this.roomFacility = roomFacility;
    }

    public String getRoomFeatures() {
        return roomFeatures;
    }

    public void setRoomFeatures(String roomFeatures) {
        this.roomFeatures = roomFeatures;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getFreeRoomResult() {
        return freeRoomResult;
    }

    public void setFreeRoomResult(Integer freeRoomResult) {
        this.freeRoomResult = freeRoomResult;
    }
}
