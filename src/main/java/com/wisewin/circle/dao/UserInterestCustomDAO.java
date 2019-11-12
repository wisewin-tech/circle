package com.wisewin.circle.dao;

import com.wisewin.circle.entity.bo.UserInterestCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Wang bin
 * @date: Created in 14:50 2019/11/12
 */
public interface UserInterestCustomDAO {

    /**
     * 根据模式id删除自定义兴趣
     * @param modelId
     * @return
     */
    int deleteUserInterestCuston(@Param("modelId")Long modelId);

    /**
     * 添加用户自定义兴趣
     * @param list
     * @return
     */
    int insertUserInterestCuston(List<UserInterestCustom> list);
}
