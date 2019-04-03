package com.wisewin.circle.web.controller;

import com.wisewin.circle.common.constants.CircleConstants;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 用戶信息控制类
 */
@Controller
@RequestMapping("/admin")
public class AdminController  extends BaseCotroller {
    @Resource
    private AdminService adminService ;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
        //手机号和密码登录
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

    /**
     * 管理员注册
     * @param request
     * @param response
     * @param mobile  手机号
     * @param name   名称
     * @param password 密码
     * @param gender 性别
     */
    @RequestMapping("adminRegister")
    public void register(HttpServletRequest request,HttpServletResponse response,String mobile,String name,
        String password,String gender){
        // 判断手机号是否注册过
        int count = adminService.selectCountByMobile(mobile);
        if(count > 0 ){
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000002" , "手机号码已注册")) ;
            super.safeJsonPrint(response , result);
            return ;
        }
        AdminBO admin = new AdminBO();
        admin.setPassword(MD5Util.digest(password));
        admin.setName(name);
        admin.setGender(gender);
        admin.setPhoneNumber(mobile);
        admin.setStatus(CircleConstants.NORMAL);// 状态 normal:正常  logout：注销
        admin.setCreateTime(new Date());
        adminService.adminRegister(admin);
        String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("")) ;
        super.safeJsonPrint(response, result);
    }

    @RequestMapping("test")
    public void getPublicSession(HttpServletRequest request, HttpServletResponse response,String key){
        System.out.println(super.getLoginUser(request));
        AdminBO result = (AdminBO) super.getLoginUser(request);
        String re = JsonUtils.getJsonString4JavaPOJO(result);
        super.safeJsonPrint(response, re);
    }


    public static void main(String[] args) {
        System.out.println(MD5Util.digest("123456"));
    }
}
