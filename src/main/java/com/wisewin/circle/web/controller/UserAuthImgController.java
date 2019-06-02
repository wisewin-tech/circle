package com.wisewin.circle.web.controller;

import com.wisewin.circle.entity.bo.AdminBO;
import com.wisewin.circle.entity.bo.UserAuthImgBO;
import com.wisewin.circle.entity.bo.UserBO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.service.TestService;
import com.wisewin.circle.service.UserAuthImgService;
import com.wisewin.circle.util.JsonUtils;
import com.wisewin.circle.util.StringUtils;
import com.wisewin.circle.web.controller.base.BaseCotroller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 认证
 */
@Controller
@RequestMapping("/UserAuthImg")
public class UserAuthImgController extends BaseCotroller {

    static final Logger log = LoggerFactory.getLogger(UserAuthImgController.class);

    @Resource
    private UserAuthImgService userAuthImgService;

    //提交认证信息
    @RequestMapping("/addUserAuthImg")
    public void addUserAuthImg(UserAuthImgBO userAuthImgBO, HttpServletRequest request, HttpServletResponse response) {
        //获取当前用户
        UserBO loginUser = super.getLoginUser(request);
        //判断参数是否为空
        if (loginUser==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000000"));
            super.safeJsonPrint(response, json);
            return;
        }
        if(userAuthImgBO==null||userAuthImgBO.getImgUrl()==null||userAuthImgBO.getImgUrl().length()==0){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, json);
            return;
        }
        userAuthImgBO.setUserId(loginUser.getId());

        Integer result = userAuthImgService.addUserAuthImg(userAuthImgBO);

    }

}
