package com.wisewin.circle.service;

import com.wisewin.circle.dao.AdminDAO;
import com.wisewin.circle.entity.bo.AdminBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("adminService")
@Transactional
public class AdminService {
    @Resource
    private AdminDAO adminDAO;

    /**
     * 根据手机号查找管理员信息
     * 管理员登录
     * @param mobile
     * @return
     */
    public AdminBO queryAdminInfoByMobile(String mobile) {
        if("".equals(mobile) || mobile == null){
            return null;
        }
        return adminDAO.queryAdminInfoByMobile(mobile);
    }

    /**
     * 管理员注册
     * @param admin
     * @return
     */
    public int adminRegister(AdminBO admin){
        return adminDAO.adminRegister(admin);
    }

    /**
     * 查找手机号是否注册过
     * @param mobile
     * @return
     */
    public int selectCountByMobile(String mobile){
        return adminDAO.selectCountByMobile(mobile);
    }

}
