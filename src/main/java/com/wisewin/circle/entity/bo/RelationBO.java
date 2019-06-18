package com.wisewin.circle.entity.bo;
import java.util.Date;

//关系
public class RelationBO {
    private Integer id;
    private Integer userIdMain;//发起人
    private Integer userId;//用户id
    private String status;//喜欢不喜欢 yes no
    private Date createTime;//创建时间
    private String type;//模式

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserIdMain() {
        return userIdMain;
    }

    public void setUserIdMain(Integer userIdMain) {
        this.userIdMain = userIdMain;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RelationBO{" +
                "id=" + id +
                ", userIdMain=" + userIdMain +
                ", userId=" + userId +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", type='" + type + '\'' +
                '}';
    }
}
