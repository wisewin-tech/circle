package com.wisewin.circle.entity.bo;


import com.wisewin.circle.common.base.BaseModel;

import java.util.Date;
import java.util.List;

public class NewbitHelpBO extends BaseModel {

    private Integer id;//id
    private Integer pId;//父id
    private String masterTitle; //主标题
    List<NewbitHelpBO> list;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getMasterTitle() {
        return masterTitle;
    }

    public void setMasterTitle(String masterTitle) {
        this.masterTitle = masterTitle;
    }

    public List<NewbitHelpBO> getList() {
        return list;
    }

    public void setList(List<NewbitHelpBO> list) {
        this.list = list;
    }
}
