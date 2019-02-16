package com.wisewin.circle.entity.bo;

import java.math.BigDecimal;

public class TotalBO {

    private String roomType;//房间类型
    private BigDecimal price;//所收价格
    private Integer number;//次数
    private Integer dId; //主键
    private Integer dsId; //交班表主键


    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Integer getDsId() {
        return dsId;
    }

    public void setDsId(Integer dsId) {
        this.dsId = dsId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
