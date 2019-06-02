package com.wisewin.circle.web.controller;

import com.wisewin.circle.entity.bo.AdminBO;
import com.wisewin.circle.entity.bo.InterestBO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.service.InterestService;
import com.wisewin.circle.util.JsonUtils;
import com.wisewin.circle.web.controller.base.BaseCotroller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 二级兴趣管理
 */
@Controller
@RequestMapping("/Interest")
public class InterestController extends BaseCotroller {

    static final Logger log = LoggerFactory.getLogger(InterestController.class);

    @Resource
    private InterestService interestService;

    /**
     * 查询一级兴趣
     * */
    @RequestMapping("/getInterest")
    public void getInterest(Integer typeId, HttpServletRequest request, HttpServletResponse response) {
        //参数异常
        if(typeId==null||typeId.equals("")||typeId==0){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, json);
        }

        //查询
        List<InterestBO> interestBOS=interestService.getInterestsByTypeId(typeId);
        String json= JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(interestBOS));
        super.safeJsonPrint(response,json);
    }



}
