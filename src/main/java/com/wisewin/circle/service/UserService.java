package com.wisewin.circle.service;


import com.wisewin.circle.common.constants.UserConstants;
import com.wisewin.circle.dao.StatisticalRecordsDAO;
import com.wisewin.circle.dao.UserDAO;

import com.wisewin.circle.entity.bo.CarCertificationBO;
import com.wisewin.circle.entity.bo.ChinaRegionBO;
import com.wisewin.circle.entity.bo.UserBO;

import com.wisewin.circle.util.DateUtils;
import com.wisewin.circle.util.MD5Util;
import com.wisewin.circle.util.RandomUtils;
import com.wisewin.circle.util.StringUtils;
import com.wisewin.circle.util.message.SendMessageUtil;
import com.wisewin.circle.util.redisUtils.RedissonHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
@Transactional
public class UserService {
    @Resource
    private UserDAO userDAO;


    @Resource
    StatisticalRecordsDAO statisticalRecordsDAO;

    /**
     * 发送验证码
     *
     * @param phone
     */
    public static void send(String phone) {
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
     * 登录判断用户是否第一次登录
     *
     * @param userId
     * @return
     */
    public Map<String, String> selectModelStatus(Long userId) {
        Map<String, String> resultMap = new HashMap<String, String>();
        resultMap.put("date", userDAO.selectModelStatus("date", userId));
        resultMap.put("friend", userDAO.selectModelStatus("friend", userId));
        resultMap.put("car", userDAO.selectModelStatus("car", userId));
        return resultMap;
    }

    //改为非第一次登录
    public void updateFirst(Long userId, String model) {
        userDAO.updateFirst(userId, model);
    }

    /**
     * 通过id查询用户信息
     */
    public UserBO selectById(Long id) {
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
     * 设置密码
     *
     * @param phone
     * @param password
     */
    public void setUserPassword(String phone, String password) {
        userDAO.setUserPassword(phone, password);
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


    //通过ids 找出用户信息
    private Date birthDate(Integer age) {
        if (age == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(Calendar.YEAR, age * -1);
        instance.set(Calendar.MONTH, 0);
        instance.set(Calendar.DAY_OF_MONTH, 1);
        instance.set(Calendar.HOUR_OF_DAY, 0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        return instance.getTime();
    }

    //添加活跃：过滤器中调用
    public void updStatisticalRecords(Long userId) {
        //判断用户今天是否已经活跃了
        //如果未活跃 返回true 并添加活跃
        Object object = RedissonHandler.getInstance().get(UserConstants.active.getValue() + userId);
        if (object != null) {
            return;
        }
        //获取现在到凌晨12点的毫秒数
        Integer expire = DateUtils.getRemainSecondsOneDay(new Date());
        RedissonHandler.getInstance().set(UserConstants.active.getValue() + userId, userId, new Long(expire));
        Integer count = statisticalRecordsDAO.getStatisticalRecordsCount();
        if (count > 0) {
            statisticalRecordsDAO.updStatisticalRecords(1);
        } else {
            statisticalRecordsDAO.addStatisticalRecords(1);
        }
    }

    /**
     * 实时更新位置
     *
     * @param latitude  纬度
     * @param longitude 经度
     */
    public void updateLocation(Long userId, Double latitude, Double longitude) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("latitude", latitude);
        paramMap.put("longitude", longitude);
        paramMap.put("userId", userId);
        userDAO.updateLongitudeAndLatitude(paramMap);
        userDAO.updateLocation(paramMap);
    }

    //查询所有地方
    public List<ChinaRegionBO> getChinaRegionBOList() {
        List<ChinaRegionBO> chinaRegionBOS = userDAO.getChinaRegionBOList(0L);
        for (ChinaRegionBO region : chinaRegionBOS) {
            region.setChinaRegionBOList(userDAO.getChinaRegionBOList(region.getId()));
        }
        return chinaRegionBOS;
    }

    //添加车辆认证
    public Integer addCarCertificationBO(CarCertificationBO carCertificationBO) {
        return userDAO.addCarCertificationBO(carCertificationBO);
    }
}
