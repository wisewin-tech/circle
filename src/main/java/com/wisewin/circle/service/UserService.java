package com.wisewin.circle.service;




import com.wisewin.circle.common.constants.UserConstants;
import com.wisewin.circle.dao.UserDAO;
import com.wisewin.circle.entity.bo.UserBO;
import com.wisewin.circle.util.MD5Util;
import com.wisewin.circle.util.RandomUtils;
import com.wisewin.circle.util.StringUtils;
import com.wisewin.circle.util.message.SendMessageUtil;
import com.wisewin.circle.util.redisUtils.RedissonHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserDAO userDAO;

    /**
     * 发送验证码
     *
     * @param phone
     */
    public void send(String phone) {
        //验证手机号格式
        String number = RandomUtils.getRandomNumber(6);
        //发送验证码
        SendMessageUtil.sendSignInCodeMessage(phone, number);
        // 保存验证码信息到Redis
        RedissonHandler.getInstance().set(phone + UserConstants.VERIFY.getValue(), number, 300L);
        //缓存验证码失效标识
        RedissonHandler.getInstance().set(phone + UserConstants.VERIFY_LOSE.getValue(), number, 60L);
        //次数
        String count = RedissonHandler.getInstance().get(phone + UserConstants.DEGREE.getValue());
        if(count!=null){
            //累加
            Integer coun=Integer.parseInt(count);
            coun=coun+1;
            RedissonHandler.getInstance().set(phone + UserConstants.DEGREE.getValue(), coun.toString(), 86400L);
        }else{
            //添加
            RedissonHandler.getInstance().set(phone + UserConstants.DEGREE.getValue(), "1", 86400L);
        }

        //获取缓存中验证码
        String mobileAuthCode = RedissonHandler.getInstance().get(phone + UserConstants.VERIFY.getValue());
        System.out.println("send方法缓存中的验证码为" + mobileAuthCode);
    }


    /**
     * 通过手机号查询用户信息
     */
    public UserBO selectByPhone(String phone) {
        return userDAO.selectByPhone(phone);

    }
    /**
     * 通过id查询用户信息
     */
    public UserBO selectById(Integer id) {
        return userDAO.selectAllById(id);

    }

    /**
     * 添加用户信息
     *
     * @param userBO
     */
    public void insertUser(UserBO userBO) {
        userDAO.insertUser(userBO);
}

    /**
     * 修改用户信息
     * @param userParam
     */
    public void updateUser(UserBO userParam) {
        //如果用户有修改密码,对密码进行加密
        if (!StringUtils.isEmpty(userParam.getPassword())){
            userParam.setPassword(MD5Util.digest(userParam.getPassword()));
        }
        userDAO.updateUser(userParam);
    }



}
