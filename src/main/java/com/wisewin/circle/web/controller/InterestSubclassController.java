package com.wisewin.circle.web.controller;

import com.wisewin.circle.entity.bo.AdminBO;
import com.wisewin.circle.entity.bo.InterestSubclassBO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.service.InterestSubclassService;
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
@RequestMapping("/InterestSubclass")
public class InterestSubclassController extends BaseCotroller {

    static final Logger log = LoggerFactory.getLogger(InterestSubclassController.class);

    @Resource
    private InterestSubclassService interestSubclassService;

    /**
     * 查询二级兴趣
     * */
    @RequestMapping("/getInterestSubclass")
    public void getInterestSubclass(Integer interestId, HttpServletRequest request, HttpServletResponse response) {
        //参数异常
        if(interestId==null||interestId.equals("")||interestId==0){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, json);
        }

        //查询
        List<InterestSubclassBO> interestSubclassBOS=interestSubclassService.getInterestsSubclassByInterestId(interestId);
        String json= JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(interestSubclassBOS));
        super.safeJsonPrint(response,json);
    }



}
