package com.wisewin.circle.service;

import com.wisewin.circle.common.constants.TheGarageConstants;
import com.wisewin.circle.dao.UserAuthImgDAO;
import com.wisewin.circle.entity.bo.UserAuthImgBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

//账号认证
@Service("UserAuthImgService")
@Transactional
public class UserAuthImgService {

    @Resource
    UserAuthImgDAO userAuthImgDAO;

    //提交认证
    public Integer addUserAuthImg(UserAuthImgBO userAuthImgBO){
        userAuthImgBO.setStatus(TheGarageConstants.UNREVIEWED.getValue());
        return userAuthImgDAO.addUserAuthImg(userAuthImgBO);
    }

    /*
     *查询用户认证信息
     */
    public UserAuthImgBO getUserAuth(Integer userId){
        return userAuthImgDAO.getUserAuth(userId);
    }

}
