package com.wisewin.circle.dao;

import com.wisewin.circle.entity.bo.RelationBO;
import org.apache.ibatis.annotations.Param;

/**
 * 关系
 * */
public interface RelationDAO {

    /**
     * 用户点击喜欢 或者不喜欢
     * */
    Integer addRelation(RelationBO relationBO);

    /**
     * 判断用户点击的用户，是否喜欢过自己了
     * @Param userIdMain 发起人，当前登录的用户
     * @Param userId 喜欢的用户id
     * */
    Integer checkUserLike(@Param("userIdMain")Integer userIdMain,@Param("userId") Integer userId);



}
