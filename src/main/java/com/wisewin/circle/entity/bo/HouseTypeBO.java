package com.wisewin.circle.entity.bo;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2018-10-23.
 */
public class HouseTypeBO {
    private  Integer id; //房型主键id
    private  String  name;//房型名称
    private  BigDecimal typePrice;//房型价格
    private BigDecimal timePrice;//钟点房价格
    private  Integer hotelId;
    private  Integer count;//房型所剩空房的数量
    private Integer countOrderRoom;//预约房的数量
    private Integer countChinkRoom;//入住数量
    private  String ratio;//入住率
    private Integer sumCount;//房型总数
    private Integer times;//入住次数
    private String date;//日期

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Integer getSumCount() {
        return sumCount;
    }

    public void setSumCount(Integer sumCount) {
        this.sumCount = sumCount;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public Integer getCountOrderRoom() {
        return countOrderRoom;
    }

    public void setCountOrderRoom(Integer countOrderRoom) {
        this.countOrderRoom = countOrderRoom;
    }

    public Integer getCountChinkRoom() {
        return countChinkRoom;
    }

    public void setCountChinkRoom(Integer countChinkRoom) {
        this.countChinkRoom = countChinkRoom;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getTimePrice() {
        return timePrice;
    }

    public void setTimePrice(BigDecimal timePrice) {
        this.timePrice = timePrice;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public BigDecimal getTypePrice() {
        return typePrice;
    }

    public void setTypePrice(BigDecimal typePrice) {
        this.typePrice = typePrice;
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


}
