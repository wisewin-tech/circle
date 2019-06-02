package com.wisewin.circle.web.controller;

import com.wisewin.circle.entity.bo.AdminBO;
import com.wisewin.circle.entity.bo.InterestTypeBO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.service.InterestTypeService;
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
 * 兴趣分类管理
 */
@Controller
@RequestMapping("/InterestType")
public class InterestTypeController extends BaseCotroller {

    static final Logger log = LoggerFactory.getLogger(InterestTypeController.class);

    @Resource
    private InterestTypeService interestTypeService;

    /**
     * 查询兴趣分类
     * */
    @RequestMapping("/getInterestType")
    public void getInterestType(HttpServletRequest request, HttpServletResponse response) {
        //查询
        List<InterestTypeBO> interestSubclassBOS=interestTypeService.getInterestsType();
        String json= JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(interestSubclassBOS));
        super.safeJsonPrint(response,json);
    }



}
