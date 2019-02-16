package com.wisewin.circle.entity.bo;

import java.util.Date;

/**
 * Created by Administrator on 2018-11-19.
 */
public class HouseTypeViewBO {
   private Date startTime;//开始时间
   private  Date endTime;//结束时间
   private Integer count1;//可用房的数量
   private  Integer count2;//预约房的数量
   private  Integer count3;//入住房的数量
    private  String  name;//房型名称

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

    public Integer getCount1() {
        return count1;
    }

    public void setCount1(Integer count1) {
        this.count1 = count1;
    }

    public Integer getCount2() {
        return count2;
    }

    public void setCount2(Integer count2) {
        this.count2 = count2;
    }

    public Integer getCount3() {
        return count3;
    }

    public void setCount3(Integer count3) {
        this.count3 = count3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
