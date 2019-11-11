package com.wisewin.circle.entity.bo;


import com.wisewin.circle.common.base.BaseModel;

/**
 * 键-值关联表
 */
public class KeyValuesBO extends BaseModel {
    private Integer id;         //用户id
    private String  key;        //键
    private String  values;    //值
    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
