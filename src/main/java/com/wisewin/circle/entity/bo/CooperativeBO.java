package com.wisewin.circle.entity.bo;

import java.util.Date;

/**
 * Created by yxw on 2018/11/7.
 */
public class CooperativeBO {
    private Integer id;
    private String name;
    private Date createTime;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
