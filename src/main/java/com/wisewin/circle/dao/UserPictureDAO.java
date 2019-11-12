package com.wisewin.circle.dao;

import com.wisewin.circle.entity.bo.UserPicture;
import com.wisewin.circle.entity.dto.param.UserPictureParam;
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

    /**
     * 根据模式id删除照片墙
     * @param modelId
     * @return
     */
    int deleteUserPicture(@Param("modelId")Integer modelId);

    /**
     * 插入新照片墙
     * @param list
     * @return
     */
    int insertUserPicture(List<UserPictureParam> list);
}
