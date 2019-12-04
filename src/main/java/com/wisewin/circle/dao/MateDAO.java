package com.wisewin.circle.dao;


import com.wisewin.circle.entity.bo.IncidentMsgBO;
import com.wisewin.circle.entity.bo.UserMSgInterest;
import com.wisewin.circle.entity.bo.UserMsgBO;
import com.wisewin.circle.entity.dto.ConditionDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
     * 查询喜欢用户
     * @param search
     * @return
     */
    List<Long> queryLike(Map<String,Object> search);

    /**
     * 热度用户
     * @param search
     * @return
     */
    List<Long> heat(Map<String, Object> search);

    /**
     * 查询符合条件的用户 ID DATE+Fired模式
     * @param search
     * @return
     */
    List<Long> distance(Map<String, Object> search);

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

    List<UserMsgBO> getUserMsg2(Map<String, Object> paramMap);
}