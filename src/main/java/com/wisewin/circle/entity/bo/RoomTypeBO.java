package com.wisewin.circle.entity.bo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018-10-23.
 */
public class RoomTypeBO {

    private Integer id;//room_type表的主键id
    private Integer roomId;//房间id
    private String roomNum;//房间号码
    private Integer hotelId;//酒店主键id
    private String hotelName;//酒店名称
    private String floorName;//楼层
    private Integer floorId;//楼层id
    private Integer houseTypeId;//房型主键id
    private String roomTypeName;//房型名称
    private BigDecimal price;//标准价格
    private Integer state;//房间状态
    private String comment;//备注
    private  String roomFacility;//房间设施
    private  String roomFeatures;//房间特性
    private Date startTime;//开始时间
    private Date endTime;//结束时间
    private BigDecimal timePrice;//钟点房价格
    private Integer freeId;//是否是免费的房
    private  Integer timeRoomResult;//是否是钟点房
    private  BigDecimal workdayPrice;//工作日价格
    private  BigDecimal weekendPrice;//周末价格
    private List<RoomBO> roomBOList;
    private Integer lockState;//锁房的状态
    private Date lockStartTime;//锁房开始时间
    private Date lockEndTime;//锁房结束时间

    public Date getLockStartTime() {
        return lockStartTime;
    }

    public void setLockStartTime(Date lockStartTime) {
        this.lockStartTime = lockStartTime;
    }

    public Date getLockEndTime() {
        return lockEndTime;
    }

    public void setLockEndTime(Date lockEndTime) {
        this.lockEndTime = lockEndTime;
    }

    public Integer getLockState() {
        return lockState;
    }

    public void setLockState(Integer lockState) {
        this.lockState = lockState;
    }

    public List<RoomBO> getRoomBOList() {
        return roomBOList;
    }

    public void setRoomBOList(List<RoomBO> roomBOList) {
        this.roomBOList = roomBOList;
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

    public BigDecimal getTimePrice() {
        return timePrice;
    }

    public void setTimePrice(BigDecimal timePrice) {
        this.timePrice = timePrice;
    }

    public Integer getFreeId() {
        return freeId;
    }

    public void setFreeId(Integer freeId) {
        this.freeId = freeId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
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

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public Integer getHouseTypeId() {
        return houseTypeId;
    }

    public void setHouseTypeId(Integer houseTypeId) {
        this.houseTypeId = houseTypeId;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
