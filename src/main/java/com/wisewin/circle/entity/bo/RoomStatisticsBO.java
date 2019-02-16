package com.wisewin.circle.entity.bo;

import com.wisewin.circle.common.base.BaseModel;

public class RoomStatisticsBO extends BaseModel{

    public RoomStatisticsBO() {}

    public RoomStatisticsBO(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    private String  name;
    private Integer number;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
