package com.wisewin.circle.dao;



import com.wisewin.circle.entity.bo.InterestTypeBO;

import java.util.List;

/**
 * 兴趣分类
 * */
public interface InterestTypeDAO {

    /**
     * 查询所有兴趣分类
     */
    List<InterestTypeBO> getInterestsType();
}
