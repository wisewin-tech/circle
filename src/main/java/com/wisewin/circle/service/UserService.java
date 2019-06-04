package com.wisewin.circle.service;


import com.wisewin.circle.common.constants.PatternConstants;
import com.wisewin.circle.common.constants.UserConstants;
import com.wisewin.circle.dao.UserDAO;
import com.wisewin.circle.entity.bo.BackgroundBO;
import com.wisewin.circle.entity.bo.PatternBO;
import com.wisewin.circle.entity.bo.UserBO;
import com.wisewin.circle.entity.dto.param.DatepatternParam;
import com.wisewin.circle.util.MD5Util;
import com.wisewin.circle.util.RandomUtils;
import com.wisewin.circle.util.StringUtils;
import com.wisewin.circle.util.message.SendMessageUtil;
import com.wisewin.circle.util.redisUtils.RedissonHandler;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
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
    public UserBO selectById(Integer id) throws Exception {
        UserBO userBO=userDAO.selectAllById(id);
        userBO.setAge(getAge(userBO.getBirthday()));
        return userBO;
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
    public boolean updateUser(UserBO userParam) {
        //如果用户有修改密码,对密码进行加密
        if (!StringUtils.isEmpty(userParam.getPassword())) {
            userParam.setPassword(MD5Util.digest(userParam.getPassword()));
        }
        //如果有性别 判断第几次修改性别
        if(userParam.getGender()!=null&&userParam.getGender().length()!=0){
            if(userDAO.selectUpdSexCount(userParam.getId())>1){
                return false;
            }
        }
        return userDAO.updateUser(userParam)>0;
    }

    //通过日期过去年龄
    public static  int getAge(Date birthDay) throws Exception {
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;
            }else{
                age--;
            }
        }
        return age;
    }

    //查询数据的总条数
    public int countPattern(Integer id){
        return  userDAO.countPattern(id);
    }

    //添加基本资料
    public boolean   addDatepattern(Integer id, DatepatternParam param){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("id",id);
        map.put("name",param.getName());
        map.put("gender",param.getGender());
        map.put("birthday",param.getBirthday());
        //添加用户信息
        userDAO.updateUserDate(map);

        PatternBO patternBO=new PatternBO(id, PatternConstants.DATE);
        //添加模式
        userDAO.addPattern(patternBO);

        //添加背景图PatternBO
        BackgroundBO backgroundBO=new BackgroundBO(param.getNameurl(),param.getRank(),patternBO.getId());
        return userDAO.addDatepattern(backgroundBO)>0;


    }



}
