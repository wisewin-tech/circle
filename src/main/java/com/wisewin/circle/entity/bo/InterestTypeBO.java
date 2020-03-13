package com.wisewin.circle.entity.bo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 兴趣分类
 */
public class InterestTypeBO {

    private int id;//兴趣分类id
    private String typeName; //分类名称
    private Date  createTime; //创建时间
    private Date updateTime; //修改时间
    private Integer updateUserId; //修改人
    private Integer createUserId; //修改人

    public InterestTypeBO(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getCreateTime() {
        if(this.createTime==null||this.createTime.equals("")){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = sdf.format(this.createTime);
        return timeStr;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        if(this.updateTime==null||this.updateTime.equals("")){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = sdf.format(this.updateTime);
        return timeStr;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }
}
