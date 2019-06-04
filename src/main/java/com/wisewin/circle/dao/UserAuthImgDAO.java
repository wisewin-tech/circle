package com.wisewin.circle.dao;

import com.wisewin.circle.entity.bo.UserAuthImgBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//账号认证
public interface UserAuthImgDAO {

    //提交认证
    Integer addUserAuthImg(UserAuthImgBO userAuthImgBO);

    /*
     *查询用户认证信息
     */
    UserAuthImgBO getUserAuth(Integer userId);

}
