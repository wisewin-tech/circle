package com.wisewin.circle.web.controller;

import com.wisewin.circle.entity.bo.AdminBO;
import com.wisewin.circle.entity.bo.InterestBO;
import com.wisewin.circle.entity.bo.InterestTypeBO;
import com.wisewin.circle.entity.bo.UserBO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.service.InterestService;
import com.wisewin.circle.service.InterestTypeService;
import com.wisewin.circle.service.PatternService;
import com.wisewin.circle.util.JsonUtils;
import com.wisewin.circle.web.controller.base.BaseCotroller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 二级兴趣管理
 */
@Controller
@RequestMapping("/Interest")
public class InterestController extends BaseCotroller {

    static final Logger log = LoggerFactory.getLogger(InterestController.class);

    @Resource
    private InterestService interestService;

    @Resource
    private InterestTypeService interestTypeService;

    @Resource
    private PatternService patternService;

    /**
     * 查询兴趣
     * return 兴趣分类 兴趣
     * */
    @RequestMapping("/getInterest")
    public void getInterest(HttpServletRequest request, HttpServletResponse response) {
        //查询兴趣分类
        List<InterestTypeBO> interestTypeBOS=interestTypeService.getInterestsType();
        //查询兴趣
        List<InterestBO> interestBOS=interestService.getInterestsByTypeId(null);

        Map<String,Object> map=new HashMap<String, Object>();
        map.put("interestTypeBOS",interestTypeBOS);
        map.put("interestBOS",interestBOS);
        String json= JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(map));
        super.safeJsonPrint(response,json);
    }




}
