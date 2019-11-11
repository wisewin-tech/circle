package com.wisewin.circle.service;


import com.wisewin.circle.common.constants.PatternConstants;
import com.wisewin.circle.common.constants.UserConstants;
import com.wisewin.circle.dao.StatisticalRecordsDAO;
import com.wisewin.circle.dao.UserDAO;
import com.wisewin.circle.entity.bo.BackgroundBO;
import com.wisewin.circle.entity.bo.PatternBO;
import com.wisewin.circle.entity.bo.StatisticalRecords;
import com.wisewin.circle.entity.bo.UserBO;
import com.wisewin.circle.entity.dto.param.DatepatternParam;
import com.wisewin.circle.util.DateUtils;
import com.wisewin.circle.util.MD5Util;
import com.wisewin.circle.util.RandomUtils;
import com.wisewin.circle.util.StringUtils;
import com.wisewin.circle.util.message.SendMessageUtil;
import com.wisewin.circle.util.redisUtils.RedissonHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
     * 设置密码
     * @param phone
     * @param password
     */
    public void setUserPassword(String phone,String password){
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


    /**
     * 查询用户筛选条件
     * @param type  模式 DATE/BFF
     * @param userId 用户id
     */
    public Map<String,Object> queryCondition(String type,Integer userId){
        PatternBO patternBO = userDAO.queryCondition(type, userId);
        Map<String,Object>  queryMap=new HashMap<String, Object>();
        queryMap.put("startAge",this.birthDate(patternBO.getInquireAge())); //开始年龄
        queryMap.put("endAge",this.birthDate(patternBO.getInquireAgeOver())); //结束年龄
        queryMap.put("gender",patternBO.getInquireSex());                   //查询性别
        queryMap.put("distance",patternBO.getQueryLocation());              //查询距离
        queryMap.put("location",patternBO.getGeom());                       //当前所在位置
        return queryMap;
    }

    //通过ids 找出用户信息
    private  Date  birthDate(Integer age){
        if(age==null){
            return null;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(Calendar.YEAR,age*-1);
        instance.set(Calendar.MONTH,0);
        instance.set(Calendar.DAY_OF_MONTH,1);
        instance.set(Calendar.HOUR_OF_DAY,0);
        instance.set(Calendar.MINUTE,0);
        instance.set(Calendar.SECOND,0);
        return  instance.getTime();
    }

    //在用户注册，配对，活跃的时候调用
    //userId只有在活跃的时候传入
    public void updStatisticalRecords(String type,Integer userId){
        StatisticalRecords statisticalRecords=new StatisticalRecords();
        if(UserConstants.registration.getValue().equals(type)){
            statisticalRecords.setRegistrationCount(1);
            Integer count=statisticalRecordsDAO.getStatisticalRecordsCount();
            if(count>0){
                statisticalRecordsDAO.updStatisticalRecords(statisticalRecords);
            }else{
                statisticalRecordsDAO.addStatisticalRecords(statisticalRecords);
            }
        }else if(UserConstants.pairing.getValue().equals(type)){
            statisticalRecords.setPairingCount(1);
            Integer count=statisticalRecordsDAO.getStatisticalRecordsCount();
            if(count>0){
                statisticalRecordsDAO.updStatisticalRecords(statisticalRecords);
            }else{
                statisticalRecordsDAO.addStatisticalRecords(statisticalRecords);
            }
        }else if(UserConstants.active.getValue().equals(type)){
            if(this.updActiveByUserId(userId)){
                statisticalRecords.setActiveCount(1);
                Integer count=statisticalRecordsDAO.getStatisticalRecordsCount();
                if(count>0){
                    statisticalRecordsDAO.updStatisticalRecords(statisticalRecords);
                }else{
                    statisticalRecordsDAO.addStatisticalRecords(statisticalRecords);
                }
            }
        }

    }

    //判断用户今天是否已经活跃了
    //如果未活跃 返回true 并添加活跃
    public boolean updActiveByUserId(Integer userId){
        Object object=RedissonHandler.getInstance().get(UserConstants.active.getValue()+userId);
        if(object!=null){
            return false;
        }
        //获取现在到凌晨12点的毫秒数
        Integer expire= DateUtils.getRemainSecondsOneDay(new Date());
        RedissonHandler.getInstance().set(UserConstants.active.getValue()+userId,userId,new Long(expire));
        return true;
    }

    public static void main(String[] args) {
    		send("18631323023");
    }
}
