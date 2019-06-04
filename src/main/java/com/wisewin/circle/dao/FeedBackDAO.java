package com.wisewin.circle.dao;


import com.wisewin.circle.entity.bo.FeedBackBO;

/**
 * 反馈信息
 */
public interface FeedBackDAO {

    /**
     * 添加反馈信息
     * String content; //反馈内容
     * String contactWay//什么方式
     * String contactpattern; //用户联系方式
     */
    Integer  addFeedBack(FeedBackBO feedBackBO);


}
