package com.wisewin.circle.entity.bo;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class DealShiftBO {

  private Integer id;
  private String name;     //交班操作员
  private Date startTime;  //上班时间
  private Date endTime;    //下班时间
  private Integer operator;  //操作员id
  private BigDecimal generalIncome;  //总收入
  private BigDecimal rental;          //房费总额
  private BigDecimal otherExpense;    //其他费用
  private BigDecimal thirdPartyPayment;  //第三方支付
  private BigDecimal internetPayment;    //网络支付
  private BigDecimal cashPayment;       //现金支付
  private BigDecimal petty;         //备用金
  private Integer cardNumber;           //制卡数
  private Integer roomNumber;        //总房间数
  private Integer hotelId;          //酒店id
  private List<TotalBO>  totalBOS;    //房间信息
  private List<TotalBO>  totalBOList;  //全天房钟点房免费房
  private BigDecimal   xwCash;
  private BigDecimal   xwPos;
  private BigDecimal   xwAll;


    public BigDecimal getXwCash() {
        return xwCash;
    }

    public void setXwCash(BigDecimal xwCash) {
        this.xwCash = xwCash;
    }

    public BigDecimal getXwPos() {
        return xwPos;
    }

    public void setXwPos(BigDecimal xwPos) {
        this.xwPos = xwPos;
    }

    public BigDecimal getXwAll() {
        return xwAll;
    }

    public void setXwAll(BigDecimal xwAll) {
        this.xwAll = xwAll;
    }

    public void setPetty(BigDecimal petty) {
        this.petty = petty;
    }

    public BigDecimal getPetty() {
        return petty;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public List<TotalBO> getTotalBOList() {
        return totalBOList;
    }

    public void setTotalBOList(List<TotalBO> totalBOList) {
        this.totalBOList = totalBOList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public List<TotalBO> getTotalBOS() {
        return totalBOS;
    }

    public void setTotalBOS(List<TotalBO> totalBOS) {
        this.totalBOS = totalBOS;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public BigDecimal getGeneralIncome() {
        return generalIncome;
    }

    public void setGeneralIncome(BigDecimal generalIncome) {
        this.generalIncome = generalIncome;
    }

    public BigDecimal getRental() {
        return rental;
    }

    public void setRental(BigDecimal rental) {
        this.rental = rental;
    }

    public BigDecimal getOtherExpense() {
        return otherExpense;
    }

    public void setOtherExpense(BigDecimal otherExpense) {
        this.otherExpense = otherExpense;
    }

    public BigDecimal getThirdPartyPayment() {
        return thirdPartyPayment;
    }

    public void setThirdPartyPayment(BigDecimal thirdPartyPayment) {
        this.thirdPartyPayment = thirdPartyPayment;
    }

    public BigDecimal getInternetPayment() {
        return internetPayment;
    }

    public void setInternetPayment(BigDecimal internetPayment) {
        this.internetPayment = internetPayment;
    }

    public BigDecimal getCashPayment() {
        return cashPayment;
    }

    public void setCashPayment(BigDecimal cashPayment) {
        this.cashPayment = cashPayment;
    }



    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }
}