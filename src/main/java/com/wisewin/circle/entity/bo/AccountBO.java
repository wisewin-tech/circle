package com.wisewin.circle.entity.bo;

import com.wisewin.circle.common.base.BaseModel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yxw on 2018/10/23.
 */
public class AccountBO extends BaseModel {
    private  Integer id;
    private  Integer userId;
    private BigDecimal integral;//积分剩余
    private String paymentPassword;//支付密码
    private Date createTime;
    private Integer cartId;
    private  BigDecimal payIntegral;//已支付积分
    private BigDecimal payCount;//消费合计
    private  BigDecimal integralCount;//积分总额度

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getIntegral() {
        return integral;
    }

    public void setIntegral(BigDecimal integral) {
        this.integral = integral;
    }

    public String getPaymentPassword() {
        return paymentPassword;
    }

    public void setPaymentPassword(String paymentPassword) {
        this.paymentPassword = paymentPassword;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public BigDecimal getPayIntegral() {
        return payIntegral;
    }

    public void setPayIntegral(BigDecimal payIntegral) {
        this.payIntegral = payIntegral;
    }

    public BigDecimal getPayCount() {
        return payCount;
    }

    public void setPayCount(BigDecimal payCount) {
        this.payCount = payCount;
    }

    public BigDecimal getIntegralCount() {
        return integralCount;
    }

    public void setIntegralCount(BigDecimal integralCount) {
        this.integralCount = integralCount;
    }
}
