package com.wisewin.circle.web.controller;

import com.wisewin.circle.entity.bo.UserBO;
import com.wisewin.circle.entity.bo.UserCertification;
import com.wisewin.circle.entity.dto.ResultDTO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.service.UserCertificationService;
import com.wisewin.circle.util.JsonUtils;
import com.wisewin.circle.web.controller.base.BaseCotroller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Wang bin
 * @date: Created in 14:22 2019/11/12
 */
@Controller
@RequestMapping("/certification")
public class UserCertificationController extends BaseCotroller {

    @Resource
    private UserCertificationService userCertificationService;

    /**
     * 添加信息认证
     * @param request
     * @param response
     */
    @RequestMapping(value = "/insertUserCertification")
    public void insertUserCertification(HttpServletRequest request, HttpServletResponse response, UserCertification userCertification){
        UserBO userBO=super.getLoginUser(request);
        ResultDTO resultDTO = userCertificationService.insertUserCertification(userCertification, userBO.getId());
        String jsonString4JavaPOJO = JsonUtils.getJsonString4JavaPOJO(resultDTO);
        super.safeJsonPrint(response, jsonString4JavaPOJO);
        return;
    }

    @RequestMapping("/addUserCertification")
    public void addCarPic(HttpServletResponse response, HttpServletRequest request,UserCertification userCertification) {
        UserBO userBO=super.getLoginUser(request);
        ResultDTO resultDTO = userCertificationService.insertUserCertification(userCertification, userBO.getId());
        String jsonString4JavaPOJO = JsonUtils.getJsonString4JavaPOJO(resultDTO);
        super.safeJsonPrint(response, jsonString4JavaPOJO);
        return;
    }
}
