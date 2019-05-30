package com.wisewin.circle.web.controller;


import com.wisewin.circle.entity.bo.AboutUsBO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.service.AboutUsService;
import com.wisewin.circle.util.JsonUtils;
import com.wisewin.circle.web.controller.base.BaseCotroller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 关于我们
 */
@Controller
@RequestMapping("/aboutUs")
public class AboutUsController extends BaseCotroller {
    @Resource
    private AboutUsService aboutUsService ;

    //查询
    @RequestMapping("/selectAboutUs")
    public void selectAboutUs(HttpServletResponse response,HttpServletRequest request) {
        //通过查询信息,返回aboutUs对象
        AboutUsBO aboutUs=aboutUsService.selectContent();

        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(aboutUs));
        super.safeJsonPrint(response, json);
    }
}
