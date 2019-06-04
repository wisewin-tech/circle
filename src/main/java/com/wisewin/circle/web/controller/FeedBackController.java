package com.wisewin.circle.web.controller;

import com.wisewin.circle.entity.bo.FeedBackBO;
import com.wisewin.circle.entity.bo.UserBO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.service.FeedbackService;
import com.wisewin.circle.util.JsonUtils;
import com.wisewin.circle.util.StringUtils;
import com.wisewin.circle.web.controller.base.BaseCotroller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/feedback")
public class FeedBackController extends BaseCotroller{
    @Resource
    private FeedbackService feedbackService;

    @RequestMapping("/addFeedBack")
    public void addFeedBack(FeedBackBO feedBackBO, HttpServletRequest request, HttpServletResponse response){
        //参数验证
        if (StringUtils.isEmpty(feedBackBO.getContent())||StringUtils.isEmpty(feedBackBO.getContactWay())
                ||StringUtils.isEmpty(feedBackBO.getContactNumber())){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, json);
            return;
        }
        //获取当前登录用户
        UserBO userBO = super.getLoginUser(request);
        //获取当前登录用户id
        Integer userId = userBO.getId();
        feedBackBO.setUserId(userId);
        Integer i = feedbackService.addFeedBack(feedBackBO);
        if (i>0){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("添加意见反馈成功！"));
            super.safeJsonPrint(response, json);
        }

    }
}
