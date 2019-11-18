package com.wisewin.circle.dao;



import com.wisewin.circle.entity.bo.InterestType;
import com.wisewin.circle.entity.dto.param.UserInterestParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 兴趣分类
 * */
public interface InterestTypeDAO {




    /**
     * 获取系统兴趣
     * @return
     */
    List<InterestType> selectciInterestType();

    /**
     * 获取用户自定义兴趣
     * @return
     */
    List<InterestType> selectciUserInterestCustom(@Param("modelId")Integer modelId);

    /**
     * 获取用户选中兴趣
     * @param modelId
     * @return
     */
    List<InterestType> selectciUserInterest(@Param("modelId")Integer modelId);

    /**
     * 删除用户选中兴趣
     * @param modelId
     * @return
     */
    int deleteUserInterest(@Param("modelId")Integer modelId);

    /**
     * 插入用户新选中兴趣
     * @param list
     * @return
     */
    int insetUserInterest(List<UserInterestParam> list);

}
