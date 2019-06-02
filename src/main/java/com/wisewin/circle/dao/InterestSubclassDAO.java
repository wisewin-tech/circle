package com.wisewin.circle.dao;

import com.wisewin.circle.entity.bo.InterestSubclassBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 二级兴趣
 * */
public interface InterestSubclassDAO {

    /**
     * 通过一级兴趣的id 查询二级兴趣
     * @param interestId 一级兴趣的id
     */
    List<InterestSubclassBO> getInterestsSubclassByInterestId(Integer interestId);
}
