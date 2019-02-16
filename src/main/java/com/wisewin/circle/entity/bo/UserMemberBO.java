package com.wisewin.circle.entity.bo;

import java.util.Date;

/**
 * Created by yxw on 2018/10/26.
 */
public class UserMemberBO {
    private String name;		// 姓名
    private String phoneNumber;
    private Date birthday;	// 生日
    private  Integer certificateId;//证件类型id
    private  String CredentialNo;
    private String gender;		// 性别：1-男；2-女
    private String address;
    private String salesperson;
    private  Date createTime;
    private String cart;
    private String remark;
    private Integer id;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Integer certificateId) {
        this.certificateId = certificateId;
    }

    public String getCredentialNo() {
        return CredentialNo;
    }

    public void setCredentialNo(String credentialNo) {
        CredentialNo = credentialNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
