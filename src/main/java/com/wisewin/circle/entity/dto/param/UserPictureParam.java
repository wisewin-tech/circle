package com.wisewin.circle.entity.dto.param;

/**
 * @Author: Wang bin
 * @date: Created in 12:15 2019/11/12
 */
public class UserPictureParam {
    private Integer modelId;
    private String pictureUrl;
    private Integer sort;

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "UserPictureParam{" +
                "modelId=" + modelId +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", sort=" + sort +
                '}';
    }
}
