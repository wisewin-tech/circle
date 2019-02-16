package com.wisewin.circle.entity.bo;

import java.util.Date;

/**
 * Created by Administrator on 2018-10-23.
 */
public class RoomTypeSelfBO {
    private Integer id;//房间类型表的主键id
    private String name;//房间所在层数、房间号码
    private Integer pid;//上级类别id
    private Integer houseTypeId;//房间类型id
    private  Integer sort;//排序
    private Date createTime;//创建时间
    private String createUser;//创建人
    private Date updateTime;//修改时间
    private String updateUser;//修改人
    private String imgUrl;//图片路径
    private Integer hotelId;//酒店主键id
    private Integer roomId;



    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }
}
