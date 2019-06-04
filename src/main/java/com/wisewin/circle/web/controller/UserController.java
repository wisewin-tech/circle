package com.wisewin.circle.web.controller;

import com.wisewin.circle.common.constants.SysConstants;
import com.wisewin.circle.common.constants.UserConstants;
import com.wisewin.circle.entity.bo.PatternBO;
import com.wisewin.circle.entity.bo.UserBO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.entity.dto.param.DatepatternParam;
import com.wisewin.circle.service.UserService;
import com.wisewin.circle.util.AccountValidatorUtil;
import com.wisewin.circle.util.JsonUtils;
import com.wisewin.circle.util.MD5Util;
import com.wisewin.circle.util.StringUtils;
import com.wisewin.circle.util.redisUtils.RedissonHandler;
import com.wisewin.circle.web.controller.base.BaseCotroller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author Shibo Sun
 * 主机controller
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseCotroller {

    @Resource
    private UserService userService;


    /**
     * 发送验证码
     *
     * @param phone
     */
    @RequestMapping("/send")
    public void send(String phone, HttpServletResponse response) {
        //手机号非空+格式判断
        if (this.phoneFormt(phone, response)) {
            String time = RedissonHandler.getInstance().get(phone + UserConstants.VERIFY_LOSE.getValue());
            if(time!=null){
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000009"));
                super.safeJsonPrint(response, json);
                return;
            }
            String count = RedissonHandler.getInstance().get(phone + UserConstants.DEGREE.getValue());
            if (count != null) {
                int coun = Integer.valueOf(count);
                if (coun >= 20) {
                    String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000008"));
                    super.safeJsonPrint(response, json);
                    return;
                }
            }
            userService.send(phone);
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(ResultDTOBuilder.success));
            super.safeJsonPrint(response, json);

        }
    }


    /**
     * @param phone
     * @param verify 用户注册
     */
    @RequestMapping("/userRegister")
    public void register(String phone, String verify, HttpServletResponse response, HttpServletRequest request) {
        //手机号非空+格式判断
        if (!this.phoneFormt(phone, response)) {
            return;
        }
        UserBO userBO = userService.selectByPhone(phone);
        if (userBO != null) {
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000003"));
            super.safeJsonPrint(response, json);
            return;
        }
        //获取Redis中的用户验证码
        System.out.println(phone + UserConstants.VERIFY.getValue());
        String verificationCode = this.getVerificationCode(phone);
        //如果和用户收到的验证码相同
        if (verify.equals(verificationCode)) {
            UserBO user = new UserBO(phone);
            userService.addUser(user);
            //将只带有手机号的user对象存入cookie中
            this.putUser(response, user);
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(user));
            super.safeJsonPrint(response, json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000006"));
        super.safeJsonPrint(response, json);
        return;
    }


    /**
     * 登录 密码登录和验证码登录
     *
     * @param request
     * @param response
     * @param phone    手机号
     * @param type     验证码登录/密码登录   verificationCode / password
     * @param password 密码
     * @param code     验证码
     */
    @RequestMapping("/loginUser")
    public void loginUser(HttpServletRequest request, HttpServletResponse response, String phone, String password, String type, String code) {
        if (phone == null || type == null) {
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, json);
            return;
        }

        //验证用户是否存在
        UserBO userBO = userService.selectByPhone(phone);
        if (userBO == null) {
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000004"));
            super.safeJsonPrint(response, json);
            return;
        }

        if (UserConstants.PASSWORD.getValue().equals(type)) {
            //密码登录
            if (StringUtils.isEmpty(password)) {
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, json);
                return;
            }
            if (MD5Util.digest(password).equals(userBO.getPassword())) {
                this.putUser(response, userBO);
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(userBO));
                super.safeJsonPrint(response, json);
                return;
            }

        } else {
            //验证码登录
            if (code == null) {
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, json);
                return;
            }

            String verificationCode = this.getVerificationCode(phone);
            if (code.equals(verificationCode)) {
                this.putUser(response, userBO);
                String key = phone + UserConstants.VERIFY.getValue();
                RedissonHandler.getInstance().delete(key);
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(userBO));
                super.safeJsonPrint(response, json);
                return;
            }

        }

        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
        super.safeJsonPrint(response, json);
    }


    /**
     * 忘记密码
     * @param request
     * @param response
     * @param phone  手机号
     * @param code   验证码
     * @param password  密码
     */
    @RequestMapping("/forgetPassword")
    public void forgetPassword(HttpServletRequest  request,HttpServletResponse  response,String phone,String code,String password){
        if(StringUtils.isEmpty(phone) || StringUtils.isEmpty(code) || StringUtils.isEmpty(password)){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, json);
            return;
        }

        //用户是否存在
        UserBO userBO = userService.selectByPhone(phone);
        if(userBO==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000004"));
            super.safeJsonPrint(response, json);
            return;
        }

        String verificationCode = this.getVerificationCode(phone);
        if(code.equals(verificationCode)){   //修改密码
            userBO.setPassword(MD5Util.digest(password));
            userService.updateUser(userBO);
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(ResultDTOBuilder.success));
            super.safeJsonPrint(response, json);
            return;
        }
        //不能修改
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000006"));
        super.safeJsonPrint(response, json);
        return;

    }



    /**
     * 获取验证码
     */
    private String getVerificationCode(String phoneNumnber) {
        String key = phoneNumnber + UserConstants.VERIFY.getValue();
        String mobileAuthCode = RedissonHandler.getInstance().get(key);
        return mobileAuthCode;
    }


    /**
     * 将user对象存入到Cookie
     *
     * @param response
     * @param userBO
     */
    private void putUser(HttpServletResponse response, UserBO userBO) {
        String uuid = UUID.randomUUID().toString();
        super.putLoginUser(uuid, userBO);
        super.setCookie(response, SysConstants.CURRENT_LOGIN_CLIENT_ID, uuid, 24 * 60 * 60 * 30);
        //TODO  小汶 未完成
      /*  Object oldKey = RedissonHandler.getInstance().get(userBO.getId() + SysConstants.LOGIN_IDENTIFICATION);
        if (oldKey != null) {
            RedissonHandler.getInstance().delete((String) oldKey);
        }
        RedissonHandler.getInstance().set(userBO.getId() + SysConstants.LOGIN_IDENTIFICATION,
                super.createKey(uuid, com.wisewin.circle.common.constants.SysConstants.CURRENT_LOGIN_USER), (long) 24 * 60 * 60 * 30);
*/

    }


    /**
     * 查询用户信息
     *
     * @param response
     * @param request
     * @throws Exception
     */
    @RequestMapping("/queryUser")
    public void queryUser(HttpServletResponse response, HttpServletRequest request) throws Exception {
        //从cookie中获取他的user对象的id
        UserBO loginUser = super.getLoginUser(request);
        //如果获取不到,参数异常
        if (loginUser.getId() == null) {
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(loginUser));
        super.safeJsonPrint(response, json);
    }


    /**
     * 手机号格式判断
     */
    private boolean phoneFormt(String phone, HttpServletResponse response) {
        if (!(AccountValidatorUtil.isMobile(phone))) {
            //如果手机号格式不正确,提示.返回false
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000002"));
            super.safeJsonPrint(response, json);

            return false;
        }
        //手机号格式通过,返回true
        return true;
    }

    /**
     * 添加默认模式图片和基本资料
     * Integer userId;//用户id
     * String nameurl; //图片地址
     * Double  rank; //排序
     */
    @RequestMapping("/addDatepattern")
    public void addDatepattern(HttpServletRequest request, HttpServletResponse response, DatepatternParam param){

        //获取当前用户
        UserBO loginUser = super.getLoginUser(request);
        Integer id = loginUser.getId();

        //如果为空将结束
        if (id==null || StringUtils.isEmpty(param.getNameurl()) || StringUtils.isEmpty(param.getName())
                || StringUtils.isEmpty(param.getGender())){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, json);
            return;
        }
        //查询是否有数据
        int countPatternjoin=userService.countPattern(id);
        if (countPatternjoin>0){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000007"));
            super.safeJsonPrint(response, json);
            return;
        }


        boolean addDatepatternjoin=userService.addDatepattern(id,param);
        if (addDatepatternjoin){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
            super.safeJsonPrint(response, json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
        super.safeJsonPrint(response, json);
        return;


    }

    /**
     * 修改用户信息
     */
    @RequestMapping("/updateUser")
    public void updateUser(HttpServletRequest request, HttpServletResponse response,UserBO userBO){
        if(userBO==null||userBO.getId()==null||userBO.getId().equals("")||userBO.getPattern()==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, json);
            return;
        }
        if(userService.updateUser(userBO)){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("修改成功"));
            super.safeJsonPrint(response, json);
            return;
        }else{
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("1111111"));
            super.safeJsonPrint(response, json);
            return;

        }

    }

    /**
     * 获取用户信息
     */
    @RequestMapping("/getUserInfo")
    public void getUserInfo(HttpServletRequest request, HttpServletResponse response,Integer id) throws Exception {
        if(id==null||id.equals("")){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, json);
            return;
        }

        UserBO userBO=userService.selectById(id);
        String json = JsonUtils.getJsonString4JavaPOJO(userBO);
        super.safeJsonPrint(response, json);
    }
}
