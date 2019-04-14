package com.wisewin.circle.web.controller;

import com.wisewin.circle.common.constants.CircleConstants;
import com.wisewin.circle.common.constants.SysConstants;
import com.wisewin.circle.entity.bo.*;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.entity.param.MenuParam;
import com.wisewin.circle.entity.param.RegisterParam;
import com.wisewin.circle.entity.param.RoleParam;
import com.wisewin.circle.service.AdminService;
import com.wisewin.circle.util.JsonUtils;
import com.wisewin.circle.util.MD5Util;
import com.wisewin.circle.util.StringUtils;
import com.wisewin.circle.web.controller.base.BaseCotroller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
        userInfo.setPassword("");
        // 登陆客户信息放入Redis缓存
        String uuid = UUID.randomUUID().toString();
        super.putLoginUser(uuid, userInfo);
        System.out.print(createKey(uuid, SysConstants.CURRENT_LOGIN_USER));
        super.setCookie(response, SysConstants.CURRENT_LOGIN_CLIENT_ID, uuid, 86400);
        String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(userInfo)) ;
        super.safeJsonPrint(response, result);
        //验证码登录
    }

    /**
     * 管理员注册
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("adminRegister")
    public void register(HttpServletRequest request,HttpServletResponse response,RegisterParam param){
        // 判断是否为空
        if(param == null || StringUtils.isEmpty(param.getPassword()) || StringUtils.isEmpty(param.getGender())
                || StringUtils.isEmpty(param.getMobile()) || StringUtils.isEmpty(param.getName()) || StringUtils.isEmpty(String.valueOf(param.getRoleId()))){
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001" , "参数异常")) ;
            super.safeJsonPrint(response , result);
            return ;
        }

        // 判断手机号是否注册过
        int count = adminService.selectCountByMobile(MD5Util.digest(param.getPassword()));
        if(count > 0 ){
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000002" , "手机号码已注册")) ;
            super.safeJsonPrint(response , result);
            return ;
        }
        AdminBO admin = new AdminBO();
        admin.setPassword(MD5Util.digest(param.getPassword()));
        admin.setName(param.getName());
        admin.setGender(param.getGender()); //
        admin.setPhoneNumber(param.getMobile());
        admin.setStatus(param.getStatus());// 状态 normal:正常  logout：注销
        admin.setCreateTime(new Date());
        admin.setRoleId(param.getRoleId());
        adminService.adminRegister(admin);
        String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("")) ;
        super.safeJsonPrint(response, result);
    }

    /**
     * 添加角色
     * @param request
     * @param response
     * @param roleName  角色名称
     */
    @RequestMapping("addRole")
    public void addRole(HttpServletRequest request,HttpServletResponse response,String roleName){
        // 非空判断
        if(StringUtils.isEmpty(roleName)){
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001" , "参数异常")) ;
            super.safeJsonPrint(response , result);
            return ;
        }
        RoleBO roleBO = new RoleBO();
        roleBO.setRoleName(roleName);
        roleBO.setCreateTime(new Date());
        roleBO.setUpdateTime(new Date());
        adminService.addRole(roleBO);
    }

    /**
     * 给角色赋予权限
     * 首先获取到给哪个角色赋予权限(获取到角色的id),准备赋予哪个权限(获取到权限id),然后将信息保存到角色权限表
     * @param request
     * @param response
     * @param roleId  角色id
     * @param menuId  权限id
     */
    @RequestMapping("grantAuthority")
    public void grantAuthority(HttpServletRequest request,HttpServletResponse response,int roleId,int menuId){
        // 非空判断
        if(StringUtils.isEmpty(String.valueOf(roleId)) || StringUtils.isEmpty(String.valueOf(menuId))){
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001" , "参数异常")) ;
            super.safeJsonPrint(response , result);
            return ;
        }
        RoleMenuBO roleMenuBO = new RoleMenuBO();
        roleMenuBO.setRoleId(roleId);
        roleMenuBO.setMenuId(menuId);
        roleMenuBO.setCreateTime(new Date());
        roleMenuBO.setUpdateTime(new Date());
        adminService.addRoleMenu(roleMenuBO);
        String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("")) ;
        super.safeJsonPrint(response, result);
    }

    /**
     * 查询所有角色
     * @return  所有角色信息
     */
    @RequestMapping("getRoleList")
    public void RoleList(HttpServletRequest request,HttpServletResponse response){
        List<RoleBO> roleList = adminService.getRoleList();
        String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(roleList)) ;
        super.safeJsonPrint(response, result);
    }

    /**
     * 查询所有权限(菜单)
     * @return 所有菜单
     */
    @RequestMapping("getMenuList")
    public void MenuList(HttpServletRequest request,HttpServletResponse response){
        List<MenuBO> menuList = adminService.getMenuList();
        // JsonUtils.getJONSArray4JavaList(roleList);
        String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(menuList)) ;
        super.safeJsonPrint(response, result);
    }

    /**
     * 根据父id向权限表中添加菜单
     * @param request
     * @param response
     * @param menuParam
     */
    @RequestMapping("addMenu")
    public void addMenuByPid(HttpServletRequest request,HttpServletResponse response,MenuParam menuParam){
        // 判断是否为空
        if(menuParam == null || StringUtils.isEmpty(menuParam.getMenuName()) || StringUtils.isEmpty(menuParam.getUrl())
                ){
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001" , "参数异常")) ;
            super.safeJsonPrint(response , result);
            return ;
        }
        if( StringUtils.isEmpty(String.valueOf(menuParam.getPid()))){
            menuParam.setPid(0);
        }
        MenuBO menuBO = new MenuBO();
        menuBO.setMenuName(menuParam.getMenuName());
        menuBO.setPid(menuParam.getPid());
        menuBO.setStatus(menuParam.getStatus());
        menuBO.setUrl(menuParam.getUrl());
        menuBO.setCreateTime(new Date());
        menuBO.setUpdateTime(new Date());
        adminService.addMenuByPid(menuBO);

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
        System.out.println(MD5Util.digest("456789"));
        System.out.println(MD5Util.digest("zhang"));
        System.out.println(MD5Util.digest("123456789"));
    }
}
