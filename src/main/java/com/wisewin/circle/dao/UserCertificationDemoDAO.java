package com.wisewin.circle.dao;

import com.wisewin.circle.entity.bo.UserCertificationDemo;

import java.util.List;

/**
 * @Author: Wang bin
 * @date: Created in 13:24 2019/11/12
 */
public interface UserCertificationDemoDAO {
    /**
     * 查询所有姿势图
     * @return
     */
    List<UserCertificationDemo> selectUserCertificationDemo();
}
