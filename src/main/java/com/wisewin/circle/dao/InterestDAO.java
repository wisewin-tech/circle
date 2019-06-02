package com.wisewin.circle.dao;

import com.wisewin.circle.entity.bo.InterestBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 兴趣分类下的一级兴趣
 * */
public interface InterestDAO {


    //通过兴趣分类id查询分类下的兴趣
    List<InterestBO> getInterestsByTypeId(Integer interestTypeId);
}
