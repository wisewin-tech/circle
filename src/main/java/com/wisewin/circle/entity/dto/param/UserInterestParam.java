package com.wisewin.circle.entity.dto.param;

/**
 * @Author: Wang bin
 * @date: Created in 12:30 2019/11/12
 */
public class UserInterestParam {
    private Integer modelId;
    private Integer typeId;
    private String interestName;

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getInterestName() {
        return interestName;
    }

    public void setInterestName(String interestName) {
        this.interestName = interestName;
    }

    @Override
    public String toString() {
        return "UserInterestParam{" +
                "modelId=" + modelId +
                ", typeId=" + typeId +
                ", interestName='" + interestName + '\'' +
                '}';
    }
}
