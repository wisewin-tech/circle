package com.wisewin.circle.dao;


import com.wisewin.circle.entity.bo.UserMsgBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MateDAO {


    /**
     * 查询喜欢该用户的Id
     * @param map 查询人id
     * @return
     */
    List<Integer> queryLikeId(Map<String,Object> map);


    /**
     * 按条件匹配用户Id
     */
    List<Integer> queryUserIdCondition(Map<String,Object>  map);

    /**
     * 取出用户信息
     */

    List<UserMsgBO>  selectUserMsgByUserIds(@Param("list")List<Integer>  list);
}
