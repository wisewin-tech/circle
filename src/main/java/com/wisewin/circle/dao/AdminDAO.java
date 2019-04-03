package com.wisewin.circle.dao;

import com.wisewin.circle.entity.bo.AdminBO;
import com.wisewin.circle.entity.bo.UserBO;

public interface AdminDAO {
    /**
     * 通过手机号查找管理员信息
     * @param mobile
     * @return UserDO
     */
    AdminBO queryAdminInfoByMobile(String mobile);
}
