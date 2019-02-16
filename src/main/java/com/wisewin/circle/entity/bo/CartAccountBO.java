package com.wisewin.circle.entity.bo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yxw on 2018/11/22.
 */
public class CartAccountBO {
    private Integer id;
    private Date createTime;
    private String cart;
    private BigDecimal price;
    private Integer state;
    private  Integer cartLeave;

    public Integer getCartLeave() {
        return cartLeave;
    }

    public void setCartLeave(Integer cartLeave) {
        this.cartLeave = cartLeave;
    }

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

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
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
}
