package com.wisewin.circle.dao;

import com.wisewin.circle.entity.bo.CarCertificationBO;
import com.wisewin.circle.entity.bo.UserCertification;

import java.util.List;

/**
 * @Author: Wang bin
 * @date: Created in 13:58 2019/11/12
 */
public interface UserCertificationDAO {

    int insertUserCertification(UserCertification userCertification);

    List<CarCertificationBO> queryCarStatusW(Long userId);

    //获取用户认证状态
    UserCertification queryUserCertification(Long userId);

}
