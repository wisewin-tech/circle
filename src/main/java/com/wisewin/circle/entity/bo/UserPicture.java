package com.wisewin.circle.entity.bo;

/**
 * @Author: Wang bin
 * @date: Created in 15:53 2019/11/11
 */
public class UserPicture {
    private Integer id;
    private Integer modelId;
    private String pictureUrl;
    private Integer sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        return "UserPicture{" +
                "id=" + id +
                ", modelId=" + modelId +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", sort=" + sort +
                '}';
    }
}
