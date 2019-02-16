package com.wisewin.circle.entity.bo;

import com.wisewin.circle.common.base.BaseModel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yxw on 2018/10/23.
 */
public class QueryMemberInfoBO extends BaseModel {
    private Integer id;
    private Integer cart;//卡号
    private  String name;
    private  String source;//来源
    private  String cartName;//卡类型
    private Date birthday;
    private String phoneNumber;
    private BigDecimal integral;//剩余积分
    private  BigDecimal payIntegral;//已支付积分
    private BigDecimal payCount;//消费合计
    private  BigDecimal integralCount;//积分总额度
    private String salesperson;//销售员
    private  Date createTime;//创建时间
    private String credentialNo;//证件号
    private  Date abateTime;//失效时间
    private  String cartStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCartStatus(String cartStatus) {
        this.cartStatus = cartStatus;
    }

    public String getCartStatus() {
        return cartStatus;
    }

    public Integer getCart() {
        return cart;
    }

    public void setCart(Integer cart) {
        this.cart = cart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCartName() {
        return cartName;
    }

    public void setCartName(String cartName) {
        this.cartName = cartName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public BigDecimal getIntegral() {
        return integral;
    }

    public void setIntegral(BigDecimal integral) {
        this.integral = integral;
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

    public String getSalesperson() {
        return salesperson;
    }

    public void setSalesperson(String salesperson) {
        this.salesperson = salesperson;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCredentialNo() {
        return credentialNo;
    }

    public void setCredentialNo(String credentialNo) {
        this.credentialNo = credentialNo;
    }

    public Date getAbateTime() {
        return abateTime;
    }

    public void setAbateTime(Date abateTime) {
        this.abateTime = abateTime;
    }
}
