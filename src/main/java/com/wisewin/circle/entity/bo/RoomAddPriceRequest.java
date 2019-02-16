package com.wisewin.circle.entity.bo;


import net.sf.json.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yxw on 2018/10/29.
 */
public class RoomAddPriceRequest {
    private Integer id;//房间类型表的主键id
    private String name;//房间所在层数、房间号码
    private Integer pid;//上级类别id
    private Integer houseTypeId;//房间类型id
    private  Integer sort;//排序
    private String createUser;//创建人
    private Date updateTime;//修改时间
    private String updateUser;//修改人
    private Integer hotelId;//酒店主键id
    private  Integer floorId;//楼层数
    private  Integer roomId;//房间类型主键id
    private  Integer state;//房间状态
    private  Date createTime;//创建时间
    private  String imgUrl;//图片路径
    private  String roomFacility;//房间设施
    private  String roomFeatures;//房间特性
    private  String comment;//备注
    private  Integer freeRoomResult;//是否成为免费房间
    private BigDecimal price;//钟点房价格
    private  Integer timeRoomResult;//是否是钟点房
    private  BigDecimal workdayPrice;//工作日价格
    private  BigDecimal weekendPrice;//周末价格
    private JSONArray roomPriceBO;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getHouseTypeId() {
        return houseTypeId;
    }

    public void setHouseTypeId(Integer houseTypeId) {
        this.houseTypeId = houseTypeId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public JSONArray getRoomPriceBO() {
        return roomPriceBO;
    }

    public void setRoomPriceBO(JSONArray roomPriceBO) {
        this.roomPriceBO = roomPriceBO;
    }
}
