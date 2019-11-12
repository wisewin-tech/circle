package com.wisewin.circle.entity.bo;

import java.util.Date;

/**
 * @Author: Wang bin
 * @date: Created in 15:01 2019/11/11
 */
public class InterestType {

    private Integer typeId;
    private String typeName;
    private String interestName;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getInterestName() {
        return interestName;
    }

    public void setInterestName(String interestName) {
        this.interestName = interestName;
    }

    @Override
    public String toString() {
        return "InterestType{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", interestName='" + interestName + '\'' +
                '}';
    }
}
