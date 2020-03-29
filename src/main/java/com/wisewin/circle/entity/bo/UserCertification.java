package com.wisewin.circle.entity.bo;

import java.util.Date;

/**
 * @Author: Wang bin
 * @date: Created in 13:47 2019/11/12
 */
public class UserCertification {
    private Integer id;
    private Long userId;
    private Integer demoId;
    private Integer userPicture;
    private Date createDate;
    private Date updateTime;
    private String remark;
    private String status;
    private Integer adminId;
    private String demoPicture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getDemoId() {
        return demoId;
    }

    public void setDemoId(Integer demoId) {
        this.demoId = demoId;
    }

    public Integer getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(Integer userPicture) {
        this.userPicture = userPicture;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getDemoPicture() {
        return demoPicture;
    }

    public void setDemoPicture(String demoPicture) {
        this.demoPicture = demoPicture;
    }

    @Override
    public String toString() {
        return "UserCertification{" +
                "id=" + id +
                ", userId=" + userId +
                ", demoId=" + demoId +
                ", userPicture=" + userPicture +
                ", createDate=" + createDate +
                ", updateTime=" + updateTime +
                ", remark='" + remark + '\'' +
                ", status='" + status + '\'' +
                ", adminId=" + adminId +
                ", demoPicture='" + demoPicture + '\'' +
                '}';
    }
}
