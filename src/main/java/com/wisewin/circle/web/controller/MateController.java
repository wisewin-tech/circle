package com.wisewin.circle.web.controller;

import com.wisewin.circle.entity.bo.UserBO;
import com.wisewin.circle.entity.bo.UserMsgBO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.service.MateService;
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

@Controller
@RequestMapping("/mate")
public class MateController extends BaseCotroller {

    static final Logger log = LoggerFactory.getLogger(MateController.class);

    @Resource
    private MateService mateService;

    @RequestMapping("/queryUser")
    public void queryUser(HttpServletRequest  request, HttpServletResponse response,String type){
        UserBO loginUser = super.getLoginUser(request);
        if(loginUser==null || type==null){
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000000")) ;
            super.safeJsonPrint(response, result);
            return;
        }
        List<UserMsgBO> matching = mateService.matching(type, loginUser.getId());
        String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(matching)) ;
        super.safeJsonPrint(response, result);
        return;
    }





}
