package com.wisewin.circle.dao;


import com.wisewin.circle.entity.bo.BackgroundBO;
import com.wisewin.circle.entity.bo.UserBO;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserDAO {



    /**
     * 添加用户信息
     * @param user
     */
    void addUser(UserBO user);

    /**
     * 设置密码
     * @param phone
     * @param password
     */
    void setUserPassword(String phone,String password);


    /**
     * 通过phone查询用户信息
     * @param phoneNumber
     * @return
     */
    UserBO selectByPhone(String phoneNumber);


    /**
     * 查询用户模式信息
     */

    String selectModelStatus(@Param("model")String model,@Param("userId")Long userId);

    /**
     *修改用户信息
     * @param userBO
     * @return
     */
    Integer updateUser(UserBO userBO);

    /**
     * 通过id 模式查找用户user
     * @param id
     * @return
     */
    UserBO selectAllById(Long id);

    /**
     * 查询用户修改性别的次数
     */
    Integer selectUpdSexCount(Integer id);


        /* 后面的功能留作备用*/
    /**
     * 手机号修改密码
     * @param phone
     * @param newPassword
     */
    void updatePassword(@Param("phone") String phone,
                        @Param("password") String newPassword);

    /**
     * 通过手机号发送验证码修改密码
     * @param phone
     * @param newpassword
     */
    void changePassword(String phone, String newpassword);

    /**
     *
     * 通过用户名查询用户信息
     * @param name
     * @return
     */
    UserBO  selectUserByUsername(String name);
    //修改正在学习的语言
    void updateLanguage(@Param("id") Integer id, @Param("studyingLanguageId") Integer studyingLanguageId);


    //添加默认模式图片
    Integer  addDatepattern(BackgroundBO backgroundBO);

    /**
     *
     *修改用户基本信息
     */
    Integer updateUserDate(Map<String,Object> map);


    //改为非第一次匹配
    void updateFirst(@Param("userId") Long userId,@Param("model") String model);
}
