package com.wisewin.circle.entity.bo;

/**
 * Created by Administrator on 2018-10-22.
 */
public class RoomViewBO {

    private String hotelName;//酒店名称
    private String floorName;//酒店层数
    private String roomNum;//房间号码
    private String houseName;//房型名字
    private Integer roomId;//房间id
    private Integer id;//room表主键id
    private Integer floorId;//酒店层数id
    private Integer houseTypeId;//房型id

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

    public Integer getHoteId() {
        return hoteId;
    }

    public void setHoteId(Integer hoteId) {
        this.hoteId = hoteId;
    }

    private Integer hoteId;//酒店主键id

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
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

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getHouseTypeId() {
        return houseTypeId;
    }

    public void setHouseTypeId(Integer houseTypeId) {
        this.houseTypeId = houseTypeId;
    }
}
