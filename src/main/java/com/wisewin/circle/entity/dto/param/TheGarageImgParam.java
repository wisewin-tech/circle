package com.wisewin.circle.entity.dto.param;

public class TheGarageImgParam {
    private Integer id; //车库图片
    private Integer theGarageId; //车库主键
    private String imgUrl; //图片路径
    private Integer sort; //排序



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTheGarageId() {
        return theGarageId;
    }

    public void setTheGarageId(Integer theGarageId) {
        this.theGarageId = theGarageId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
