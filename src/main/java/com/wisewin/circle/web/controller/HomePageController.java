package com.wisewin.circle.web.controller;

import com.wisewin.circle.entity.dto.ResultDTO;
import com.wisewin.circle.service.HomePageService;
import com.wisewin.circle.util.JsonUtils;
import com.wisewin.circle.web.controller.base.BaseCotroller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Wang bin
 * @date: Created in 14:39 2019/11/11
 * 用户主页
 */
@Controller
@RequestMapping("/homepage")
public class HomePageController extends BaseCotroller {

    private static final Logger log = LoggerFactory.getLogger(HomePageController.class);

    @Resource
    private HomePageService homePageService;

    /**
     * 个人主页
     * @param request
     * @param response
     */
    @RequestMapping(value = "/information",method = RequestMethod.POST)
    public void information(HttpServletRequest request, HttpServletResponse response, String model){
        String loginID = super.getLoginID(request);
        log.info("model:{}",model);
        ResultDTO homepage = homePageService.homepage(model, Integer.parseInt(loginID));
        String jsonString4JavaPOJO = JsonUtils.getJsonString4JavaPOJO(homepage);
        super.safeJsonPrint(response, jsonString4JavaPOJO);
        return;
    }

    @RequestMapping("/test")
    public void test(HttpServletRequest request, HttpServletResponse response){
        log.info("test");
    }
}
