package com.wisewin.circle.entity.bo;

import java.util.List;

/**
 * Created by Administrator on 2018-11-07.
 */
public class MainRoomBO {
    private String name;//房间所在层数
    private Integer hotelId;//酒店主键id
    private List<RoomBO> roomBOList;

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RoomBO> getRoomBOList() {
        return roomBOList;
    }

    public void setRoomBOList(List<RoomBO> roomBOList) {
        this.roomBOList = roomBOList;
    }
}
