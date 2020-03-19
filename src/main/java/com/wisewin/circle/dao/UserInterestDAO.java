package com.wisewin.circle.dao;

import com.wisewin.circle.entity.bo.UserInterestBO;
import com.wisewin.circle.entity.bo.UserInterestBOV2;

import java.util.List;

/**
 * 用户兴趣
 * */
public interface UserInterestDAO {


    /**
    * 根据模式id查询兴趣的所有信息
     * *  */
    List<UserInterestBOV2> selectInterestByPatternId(Long modelId);

    /**
     * 根据模式id查询兴趣的所有信息
     * *  */
    List<UserInterestBOV2> selectInterestAll();

}
