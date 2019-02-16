package com.wisewin.circle.entity.bo;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018-10-26.
 */
public class QueryRoomBO {
    private Integer id;//酒店表主键id
    private String name;//酒店名称
    private String address;//酒店地址
    private String coordinate;//酒店坐标
    private String image;//酒店图片
    private Date createTime;//创建时间
    private List<RoomTypeSelfBO> roomTypeSelf;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<RoomTypeSelfBO> getRoomTypeSelf() {
        return roomTypeSelf;
    }

    public void setRoomTypeSelf(List<RoomTypeSelfBO> roomTypeSelf) {
        this.roomTypeSelf = roomTypeSelf;
    }
}
