package com.wisewin.circle.entity.bo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yxw on 2018/11/1.
 */
public class OrderManageBO {
    private Integer id;
    private Integer childOrderId;
    private  String houseName;//房型
    private String userName;//入住名字
    private Date startTime;//开始时间
    private  Date createTime;//消费时间
    private String project;//项目
    private  String info; //详情
    private  String operator;//操作人
    private  String number;//数量
    private BigDecimal price;//价格
    private Integer payStatu;//支付方式
    private  Integer payStatus;//支付方式  1 pos  2现金
    private BigDecimal payCount;   //付款总额(总消费)
    private BigDecimal cash;       //押金
    private BigDecimal payCash;    //现金
    private BigDecimal posPay;    //pos支付
    private BigDecimal roomCharge; //房费
    private BigDecimal ortherPrice; //其他费用
    private BigDecimal refundprice;  //已退金额
    private BigDecimal refund;      //退款（可以是负）
    private  BigDecimal  exemption; //免单
    private Integer operatorId;

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getPayStatu() {
        return payStatu;
    }

    public void setPayStatu(Integer payStatu) {
        this.payStatu = payStatu;
    }

    public BigDecimal getPayCount() {
        return payCount;
    }

    public void setPayCount(BigDecimal payCount) {
        this.payCount = payCount;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public BigDecimal getPayCash() {
        return payCash;
    }

    public void setPayCash(BigDecimal payCash) {
        this.payCash = payCash;
    }

    public BigDecimal getPosPay() {
        return posPay;
    }

    public void setPosPay(BigDecimal posPay) {
        this.posPay = posPay;
    }

    public BigDecimal getRoomCharge() {
        return roomCharge;
    }

    public void setRoomCharge(BigDecimal roomCharge) {
        this.roomCharge = roomCharge;
    }

    public BigDecimal getOrtherPrice() {
        return ortherPrice;
    }

    public void setOrtherPrice(BigDecimal ortherPrice) {
        this.ortherPrice = ortherPrice;
    }

    public BigDecimal getRefundprice() {
        return refundprice;
    }

    public void setRefundprice(BigDecimal refundprice) {
        this.refundprice = refundprice;
    }

    public BigDecimal getRefund() {
        return refund;
    }

    public void setRefund(BigDecimal refund) {
        this.refund = refund;
    }

    public BigDecimal getExemption() {
        return exemption;
    }

    public void setExemption(BigDecimal exemption) {
        this.exemption = exemption;
    }

    public Integer getChildOrderId() {
        return childOrderId;
    }

    public void setChildOrderId(Integer childOrderId) {
        this.childOrderId = childOrderId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }
}
