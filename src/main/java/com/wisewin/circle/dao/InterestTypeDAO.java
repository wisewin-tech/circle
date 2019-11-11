package com.wisewin.circle.dao;



import com.wisewin.circle.entity.bo.InterestType;
import com.wisewin.circle.entity.bo.InterestTypeBO;
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

}
