package com.wisewin.circle.dao;


import com.wisewin.circle.entity.bo.IncidentMsgBO;
import com.wisewin.circle.entity.bo.UserMSgInterest;
import com.wisewin.circle.entity.bo.UserMsgBO;
import com.wisewin.circle.entity.dto.ConditionDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MateDAO {

    /**
     * 查询所有优质用户
     */
    List<Long> queryRobot(Map<String,Object> search);

    /**
     * 用户搜索条件
     * @param userId 用户id
     * @param model  模式
     * @return
     */
    ConditionDTO userCondition(@Param("userId") Long userId, @Param("model") String model);

    /**
     * 查询符合条件的用户 ID DATE+Fired模式
     * @param search
     * @return
     */
    List<Long> queryOtherUser(Map<String, Object> search);


    /**
     * 查询符合条件的用户 ID Car模式
     * @param search
     * @return
     */
    List<Long> queryCarUser(Map<String, Object> search);



    /**
     * 修改用户的匹配记录
     */
    void updateArise(Map<String,Object> map);

    /**
     * 获取基础信息
     * @param paramMap
     * @return
     */
    List<UserMsgBO> getUserMsg(Map<String, Object> paramMap);

    /**
     * 背景图片
     * @param modelId
     * @return
     */
    List<String> queyrPicture(Long modelId);

    /**
     * 查询兴趣
     * @param modelId
     * @return
     */
    List<UserMSgInterest> queryInterest(Long modelId);


    /**
     * 查询事件
     */
    IncidentMsgBO queryIncident(Long userId);


    /*  *//**
     * 查询喜欢该用户的Id
     * @param map 查询人id
     * @return
     *//*
    List<Integer> queryLikeId(Map<String,Object> map);

    *//**
     * 按条件匹配用户Id
     *//*
    List<Integer> queryUserIdCondition(Map<String,Object>  map);

    *//**
     * 取出用户信息
     *//*

    List<UserMsgBO>  selectUserMsgByUserIds(Map<String,Object>  map);

    *//**
     *  热度用户
     * @param map
     * @return
     *//*
    List<Integer> queryHeatUser(Map<String, Object> map);*/


}
