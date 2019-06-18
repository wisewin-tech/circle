package com.wisewin.circle.dao;

import com.wisewin.circle.entity.bo.RelationBO;

/**
 * 关系
 * */
public interface RelationDAO {

    /**
     * 用户点击喜欢 或者不喜欢
     * */
    Integer addRelation(RelationBO relationBO);
}
