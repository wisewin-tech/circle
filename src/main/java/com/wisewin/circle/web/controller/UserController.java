package com.wisewin.circle.web.controller;

import com.wisewin.circle.common.constants.SysConstants;
import com.wisewin.circle.entity.bo.AdminBO;
import com.wisewin.circle.entity.bo.UserBO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.service.AdminService;
import com.wisewin.circle.util.JsonUtils;
import com.wisewin.circle.util.MD5Util;
import com.wisewin.circle.util.StringUtils;
import com.wisewin.circle.web.controller.base.BaseCotroller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 用戶信息控制类
 */
@Controller
@RequestMapping("/user")
public class UserController  extends BaseCotroller {
    @Resource
    private AdminService adminService ;

    /**
     * 管理员登录
     * @param request
     * @param response
     * @param mobile 手机号
     * @param password 密码
     */
    @RequestMapping("adminLogin")
    public void Login(HttpServletRequest request, HttpServletResponse response,String mobile,String password){
        /* 1. 验证参数是否完整 */
        if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)){
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001", "参数异常！")) ;
            super.safeJsonPrint(response, result);
            return ;
        }
        //密码登录
        AdminBO userInfo = adminService.queryAdminInfoByMobile(mobile);

        if(userInfo == null){
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000004" , "用户不存在！")) ;
            super.safeJsonPrint(response, result);
            return ;
        }

        // 判断密码是否正确
        if(!MD5Util.digest(password).equals(userInfo.getPassword())){
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001" , "密码输入不正确！")) ;
            super.safeJsonPrint(response, result);
            return ;
        }
        // 登陆客户信息放入Redis缓存
        String uuid = UUID.randomUUID().toString();
        super.putLoginUser(uuid, userInfo);
        System.out.print(createKey(uuid, SysConstants.CURRENT_LOGIN_USER));
        super.setCookie(response, SysConstants.CURRENT_LOGIN_CLIENT_ID, uuid, 86400);

        userInfo.setPassword("");
        String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(userInfo)) ;
        super.safeJsonPrint(response, result);
        //验证码登录
    }

    @RequestMapping("test")
    public void getPublicSession(HttpServletRequest request, HttpServletResponse response,String key){
        System.out.println(super.getLoginUser(request));
        AdminBO result = (AdminBO) super.getLoginUser(request);
        String re = JsonUtils.getJsonString4JavaPOJO(result);
        super.safeJsonPrint(response, re);
    }


    /*public static void main(String[] args) {
        System.out.println(MD5Util.digest("123456"));
        super.getPublicSession("");
    }*/
}
