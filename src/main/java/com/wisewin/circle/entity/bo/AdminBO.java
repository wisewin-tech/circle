package com.wisewin.circle.entity.bo;

import java.util.Date;

/**
 * Created by yxw on 2018/11/5.
 */
public class AdminBO {
    private Integer id;
    private  String phoneNumber; //电话
    private  String password;//密码
    private String name;//名字
    private Date createTime;
    private String hotelId;//酒店id
    private Integer orderPermissions;//订单权限
    private String uuid ; // 用户登录的UUID
    private  Integer homePermissions;//首页权限
    private Integer status;//0 正常  1 失效
    private  Integer checkInPermissions;//入住中心权限
    private  Integer memberPermissions;//会员权限
    private  Integer hotelPermissions;//酒店管理权限
    private  Integer formsPermissions;//报表权限
    private  Integer setPermissions;//设置权限
    private  Integer handPermissions;//交班权限
    private  Integer productPermissions;//商品交易权限
    private  Integer admin;//超级账户
    private Integer hotelIdRemake;//登录酒店id备注

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getOrderPermissions() {
        return orderPermissions;
    }

    public void setOrderPermissions(Integer orderPermissions) {
        this.orderPermissions = orderPermissions;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getHomePermissions() {
        return homePermissions;
    }

    public void setHomePermissions(Integer homePermissions) {
        this.homePermissions = homePermissions;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCheckInPermissions() {
        return checkInPermissions;
    }

    public void setCheckInPermissions(Integer checkInPermissions) {
        this.checkInPermissions = checkInPermissions;
    }

    public Integer getMemberPermissions() {
        return memberPermissions;
    }

    public void setMemberPermissions(Integer memberPermissions) {
        this.memberPermissions = memberPermissions;
    }

    public Integer getHotelPermissions() {
        return hotelPermissions;
    }

    public void setHotelPermissions(Integer hotelPermissions) {
        this.hotelPermissions = hotelPermissions;
    }

    public Integer getFormsPermissions() {
        return formsPermissions;
    }

    public void setFormsPermissions(Integer formsPermissions) {
        this.formsPermissions = formsPermissions;
    }

    public Integer getSetPermissions() {
        return setPermissions;
    }

    public void setSetPermissions(Integer setPermissions) {
        this.setPermissions = setPermissions;
    }

    public Integer getHandPermissions() {
        return handPermissions;
    }

    public void setHandPermissions(Integer handPermissions) {
        this.handPermissions = handPermissions;
    }

    public Integer getProductPermissions() {
        return productPermissions;
    }

    public void setProductPermissions(Integer productPermissions) {
        this.productPermissions = productPermissions;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public Integer getHotelIdRemake() {
        return hotelIdRemake;
    }

    public void setHotelIdRemake(Integer hotelIdRemake) {
        this.hotelIdRemake = hotelIdRemake;
    }
}
