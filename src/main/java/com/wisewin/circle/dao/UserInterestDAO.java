package com.wisewin.circle.dao;

import com.wisewin.circle.entity.bo.UserInterestBO;

/**
 * 用户兴趣
 * */
public interface UserInterestDAO {


    /**
    * 根据模式id查询兴趣的所有信息
     * *  */
    UserInterestBO selectInterestByPatternId(Integer pattern_id);



}
