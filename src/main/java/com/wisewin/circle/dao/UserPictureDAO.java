package com.wisewin.circle.dao;

import com.wisewin.circle.entity.bo.UserPicture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Wang bin
 * @date: Created in 15:55 2019/11/11
 */
public interface UserPictureDAO {

    /**
     * 获取用户背景图
     * @param modelId
     * @return
     */
    List<UserPicture> selectUserPicture(@Param("modelId") Integer modelId);
}
