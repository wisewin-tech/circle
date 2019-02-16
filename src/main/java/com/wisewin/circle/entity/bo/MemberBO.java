package com.wisewin.circle.entity.bo;

import com.wisewin.circle.common.base.BaseModel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yxw on 2018/10/23.
 */
public class MemberBO extends BaseModel {

    private Integer id;		// ID
    private String name;		// 姓名
    private Date birthday;	// 生日
    private String phoneNumber;
    private String address;
    private Date abateTime;
    private String salesperson;
    private String remark;
    private String gender;		// 性别：1-男；2-女
    private  String cartStatus;
    private Integer leaveId;
    private  String credentialNo;
    private  Date createTime;
    private  Integer certificateId;
    private  String cart;
    private BigDecimal price;
    private  Integer status;
    private Integer state;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

    public Integer getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Integer certificateId) {
        this.certificateId = certificateId;
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

    public Integer getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Integer leaveId) {
        this.leaveId = leaveId;
    }

    public String getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(String cartStatus) {
        this.cartStatus = cartStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getAbateTime() {
        return abateTime;
    }

    public void setAbateTime(Date abateTime) {
        this.abateTime = abateTime;
    }

    public String getSalesperson() {
        return salesperson;
    }

    public void setSalesperson(String salesperson) {
        this.salesperson = salesperson;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
