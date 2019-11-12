package com.wisewin.circle.web.controller;

import com.wisewin.circle.entity.dto.ResultDTO;
import com.wisewin.circle.service.UserCertificationDemoService;
import com.wisewin.circle.util.JsonUtils;
import com.wisewin.circle.web.controller.base.BaseCotroller;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Wang bin
 * @date: Created in 13:36 2019/11/12
 */
@Controller
@RequestMapping("/userCertification")
public class UserCertificationDemoController extends BaseCotroller {

    @Resource
    private UserCertificationDemoService userCertificationDemoService;

    /**
     * 随机返回一张姿势图
     * @param request
     * @param response
     */
    @RequestMapping(value = "queryOnePicture",method = RequestMethod.POST)
    public void queryOnePicture(HttpServletRequest request, HttpServletResponse response){
        ResultDTO resultDTO = userCertificationDemoService.queryUserCertificationDemo();
        String jsonString4JavaPOJO = JsonUtils.getJsonString4JavaPOJO(resultDTO);
        super.safeJsonPrint(response, jsonString4JavaPOJO);
        return;
    }
}
