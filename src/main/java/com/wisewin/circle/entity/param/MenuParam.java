package com.wisewin.circle.entity.param;

import com.wisewin.circle.entity.bo.common.base.BaseModel;

public class MenuParam extends BaseModel{
    private String menuName; // 菜单名称
    private String status; // 状态
    private Integer pid; // 父id
    private String url; // 路径

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
