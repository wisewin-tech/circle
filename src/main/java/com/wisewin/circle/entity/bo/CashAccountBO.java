package com.wisewin.circle.entity.bo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yxw on 2018/11/19.
 */
public class CashAccountBO {
    private  Integer id;
    private Date createTime; //支付时间
    private  Integer state; //支付方式 1现金 2pos
    private BigDecimal price; //交易金额
    private String operator;  //操作员
    private  Integer operatorId;
    private  Integer hotelId;
    private  String info;  //消费详情
    private  Long orderNum; //订单号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }
}
