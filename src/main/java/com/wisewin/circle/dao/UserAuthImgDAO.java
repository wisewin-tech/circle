package com.wisewin.circle.dao;

import com.wisewin.circle.entity.bo.UserAuthImgBO;

//账号认证
public interface UserAuthImgDAO {

    //提交认证
    Integer addUserAuthImg(UserAuthImgBO userAuthImgBO);

}
