package com.wisewin.circle.entity.bo;

import java.math.BigDecimal;

/**
 * Created by yxw on 2018/11/7.
 */
public class CooperativePriceBO {
    private Integer id;
    private String roomTypeName;
    private BigDecimal price;
    private BigDecimal discount;
    private Integer roomTypeId;
    private  Integer CooperativeRankId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Integer getCooperativeRankId() {
        return CooperativeRankId;
    }

    public void setCooperativeRankId(Integer cooperativeRankId) {
        CooperativeRankId = cooperativeRankId;
    }
}
