package com.wisewin.circle.common.constants;

public enum TheGarageConstants {


    /*未认证*/ UNVERIFIED("unverified"),
    /*已认证*/ AUTHENTICATED("authenticated"),
    /*未审核*/  UNREVIEWED("unreviewed");



    private TheGarageConstants(String value) {
        this.value = value;
    }

    private TheGarageConstants(Integer num) {
        this.num = num;
    }

    private String value;
    private Integer num;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }




}