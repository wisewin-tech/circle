package com.wisewin.circle.service;

import com.wisewin.circle.dao.FeedBackDAO;
import com.wisewin.circle.entity.bo.FeedBackBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service("feedbackService")
@Transactional
public class FeedbackService {
    @Resource
    private FeedBackDAO feedBackDAO;

    /**
     * 添加反馈信息
     * String content; //反馈内容
     * String contactWay//什么方式
     * String contactpattern; //用户联系方式
     */
    public Integer  addFeedBack(FeedBackBO feedBackBO){
        return feedBackDAO.addFeedBack(feedBackBO);
    }
}
