package com.wisewin.circle.entity.bo;

import com.wisewin.circle.common.base.BaseModel;

import java.util.List;

public class UserMSgInterest extends BaseModel {

    private Long id;
    private String name;
    List<String> tag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTag() {
        return tag;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }
}
