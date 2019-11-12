package com.wisewin.circle.entity.bo;

/**
 * @Author: Wang bin
 * @date: Created in 14:45 2019/11/12
 */
public class UserInterestCustom {
    private Long id;
    private Long modelId;
    private Long typeId;
    private String custonName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getCustonName() {
        return custonName;
    }

    public void setCustonName(String custonName) {
        this.custonName = custonName;
    }

    @Override
    public String toString() {
        return "UserInterestCustomDAO{" +
                "id=" + id +
                ", modelId=" + modelId +
                ", typeId=" + typeId +
                ", custonName='" + custonName + '\'' +
                '}';
    }
}
