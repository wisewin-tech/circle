package com.wisewin.circle.entity.bo;

import java.util.Date;

/**
 * @Author: Wang bin
 * @date: Created in 14:10 2019/11/19
 */
public class MatchingFriended {
    private Long id;
    private Long userId;
    private Long friendsId;
    private String model;
    private Date createTime;
    private Date closeTime;
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFriendsId() {
        return friendsId;
    }

    public void setFriendsId(Long friendsId) {
        this.friendsId = friendsId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "MatchingFriended{" +
                "id=" + id +
                ", userId=" + userId +
                ", friendsId=" + friendsId +
                ", model='" + model + '\'' +
                ", createTime=" + createTime +
                ", closeTime=" + closeTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}
