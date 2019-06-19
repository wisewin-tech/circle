package com.wisewin.circle.common.constants;

public enum FriendConstants {

    /*默认状态*/ DEFAULT("default"),
    /*已成为好友*/ FRIEND("friend"),
    /*已失效*/ FAILURE("failure");

    private FriendConstants(String value) {
        this.value = value;
    }

    private FriendConstants(Integer num) {
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
