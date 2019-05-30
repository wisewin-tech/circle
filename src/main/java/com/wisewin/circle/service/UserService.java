package com.wisewin.circle.service;


import com.wisewin.circle.common.constants.UserConstants;
import com.wisewin.circle.dao.UserDAO;
import com.wisewin.circle.entity.bo.BackgroundBO;
import com.wisewin.circle.entity.bo.PatternBO;
import com.wisewin.circle.entity.bo.UserBO;
import com.wisewin.circle.util.MD5Util;
import com.wisewin.circle.util.RandomUtils;
import com.wisewin.circle.util.StringUtils;
import com.wisewin.circle.util.message.SendMessageUtil;
import com.wisewin.circle.util.redisUtils.RedissonHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
        if (count != null) {
            //累加
            Integer coun = Integer.parseInt(count);
            coun = coun + 1;
            RedissonHandler.getInstance().set(phone + UserConstants.DEGREE.getValue(), coun.toString(), 86400L);
        } else {
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
    public void addUser(UserBO userBO) {
        userDAO.addUser(userBO);
    }

    /**
     * 修改用户信息
     *
     * @param userParam
     */
    public void updateUser(UserBO userParam) {
        //如果用户有修改密码,对密码进行加密
        if (!StringUtils.isEmpty(userParam.getPassword())) {
            userParam.setPassword(MD5Util.digest(userParam.getPassword()));
        }
        userDAO.updateUser(userParam);
    }

    /**
     * 添加默认模式图片
     * Integer userId;//用户id
     * String nameurl; //图片地址
     * Double  rank; //排序
     */
    public boolean getaddDatepattern( String nameurl, Double rank,Integer patternid) {
        BackgroundBO backgroundBO = new BackgroundBO(nameurl, rank,patternid);
        return userDAO.addDatepattern(backgroundBO) > 0;
    }

    /**
     * 修改用户基本信息
     * 根据用户id进行修改
     * 名字
     * 密码
     * 性别
     * 生日
     *
     * @param
     * @return
     */
    public boolean getupdateUserDate(Integer id, String name, String password, String gender, Date birthday) {
        Map<String, Object> map = new HashMap<String, Object>();
        //用户id
        map.put("id", id);
        map.put("name", name);
        map.put("password", password);
        map.put("gender", gender);
        map.put("birthday", birthday);
        return userDAO.updateUserDate(map) > 0;
    }

    /**
     * 添加用户模式以用户的关系模式
     * Integer userid; //用户id
     * String  type; //模式  DATE/BFF模式
     */
    public boolean getaddPattern(Integer userId,String  type){
        PatternBO patternBO=new PatternBO(userId,type);
        return  userDAO.addPattern(patternBO)>0;
    }

    /**
     * 通过用户id查询模式id
     */
    public PatternBO getqueryPattern(Integer id){
        return  userDAO.queryPattern(id);
    }

    /**
     * 查询模式总数
     */
    public int getcountPattern(Integer id){
        return  userDAO.countPattern(id);
    }

}
