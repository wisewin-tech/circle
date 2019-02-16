package com.wisewin.circle.entity.bo;

import java.util.Date;

/**
 * Created by yxw on 2018/10/29.
 */
public class CartBO {
    private  Integer id;
    private  Integer cart;
    private Date createTime;
    private  Date abateTime;
    private Integer leaveId;
    private String remark;
    private String salesperson;
    private  String source;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCart() {
        return cart;
    }

    public void setCart(Integer cart) {
        this.cart = cart;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getAbateTime() {
        return abateTime;
    }

    public void setAbateTime(Date abateTime) {
        this.abateTime = abateTime;
    }

    public Integer getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Integer leaveId) {
        this.leaveId = leaveId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSalesperson() {
        return salesperson;
    }

    public void setSalesperson(String salesperson) {
        this.salesperson = salesperson;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
