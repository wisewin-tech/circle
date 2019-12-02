package com.wisewin.circle.web.controller;

import com.wisewin.circle.common.constants.SysConstants;
import com.wisewin.circle.common.constants.UserConstants;
import com.wisewin.circle.entity.bo.CarCertificationBO;
import com.wisewin.circle.entity.bo.ChinaRegionBO;
import com.wisewin.circle.entity.bo.ScreenParamBO;
import com.wisewin.circle.entity.bo.UserBO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.entity.dto.param.DatepatternParam;
import com.wisewin.circle.service.CarIncidentService;
import com.wisewin.circle.service.ModelService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    @Resource
    private ModelService modelService;
    @Resource
    private CarIncidentService carIncidentService;


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
                if (coun > 20) {
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
            UserBO user = new UserBO();
            user.setPhone(phone);
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
        UserBO userBO = userService.selectByPhone(phone);

        if (UserConstants.PASSWORD.getValue().equals(type)) {
            if (userBO==null){
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000004"));
                super.safeJsonPrint(response, json);
                return;
            }
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

            //获取Redis中的用户验证码
            System.out.println(phone + UserConstants.VERIFY.getValue());

            String verificationCode = this.getVerificationCode(phone);
            //如果和用户收到的验证码相同
            if (code.equals(verificationCode)) {
                //查询用户是否设置过密码
                //验证用户是否存在 不存在注册并设置密码
                if (userBO == null) {
                    String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000012"));
                    super.safeJsonPrint(response, json);
                    return;
                }

                //没有设置过需要设置之后才可以登录
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
     * 设置密码
     * @param phone
     * @param password
     * @param request
     * @param response
     */
    @RequestMapping("/setPassword")
    public void setUserPassword(String phone,String password,HttpServletRequest request,HttpServletResponse response){
        if (StringUtils.isEmpty(phone)||StringUtils.isEmpty(password)){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, json);
            return;
        }
        UserBO user = new UserBO();
        user.setPhone(phone);
        user.setPassword(MD5Util.digest(password));
        //初始化用户
        user.setLatitude("");//纬度
        user.setLongitude("");//经度
        user.setCertificationStatus("no");//认证状态（yes为已经认证|no为未认证|not未审核|audit审核中）
        user.setCarStatus("no");//汽车认证状态（yes为已经认证|no为未认证|not未审核|audit审核中）
        user.setUserStatus("no");//yes为被拉黑|no为未拉黑
        user.setRobotStatus("no");//yes为被拉黑|no为未拉黑
        userService.addUser(user);
        UserBO userBO = userService.selectByPhone(phone);
        //三种模式下的初始化用户资料
        modelService.addDefault(userBO.getId(),phone);

        //将只带有手机号的user对象存入cookie中
        this.putUser(response, user);
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("设置成功！"));
        super.safeJsonPrint(response, json);
        return;

    }

    /**
     * 查询用户汽车认证状态
     * @param request
     * @param response
     * carCertificationStatus----yes为已经认证|no为未认证|not未审核|audit审核中
     */
        @RequestMapping("/getUserCarStatus")
        public void getUserCarStatus(HttpServletRequest request,HttpServletResponse response){
            //获取当前用户
            UserBO loginUser = super.getLoginUser(request);
            //如果为空将结束
            if (loginUser==null){
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000000"));
                super.safeJsonPrint(response, json);
                return;
            }
            int incidentNum = carIncidentService.selectIncidentNumByUserId(loginUser.getId());
            String carIncident;
            //已经存在兜风事件
            if (incidentNum>0){
                carIncident="yes";//存在兜风事件
            }else {
                carIncident="no";//不存在兜风事件
            }
            UserBO userBO = userService.selectById(loginUser.getId());
            Map map = new HashMap();
            map.put("carIncident",carIncident);
            map.put("carCertificationStatus",userBO.getCarStatus());
            map.put("userCertificationStatus",userBO.getCertificationStatus());
            map.put("driver",userBO.getDriver());
            map.put("userId",userBO.getId());
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(map));
            super.safeJsonPrint(response, json);
            return;
        }

    /**
     * 查询用户筛选条件
     * @param model 模式
     * @param request
     * @param response
     */
    @RequestMapping("/selectScreen")
    public void selectScreen(String model,HttpServletRequest request,HttpServletResponse response){
            //获取当前用户
            UserBO loginUser = super.getLoginUser(request);
            //如果为空将结束
            if (loginUser==null){
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000000"));
                super.safeJsonPrint(response, json);
                return;
            }
            //参数验证
            if (StringUtils.isEmpty(model)){
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, json);
                return;
            }
            ScreenParamBO screenParamBO = modelService.selectScreen(model,loginUser.getId());
            UserBO userBO = userService.selectById(loginUser.getId());
            Map map = new HashMap();
            map.put("screenBO",screenParamBO);
            map.put("certificationStatus",userBO.getCertificationStatus());
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(map));
            super.safeJsonPrint(response, json);
            return;

        }
    /**
     * 修改用户筛选条件
     * @param model 模式名称
     * @param searchDistance 搜索距离
     * @param searchAge 搜索性别
     * @param searchSex 搜索年龄
     * @param sexStatus 真实性认证
     * @param carCertificationStatus 车辆认证状态
     * @param request
     * @param response
     */
        @RequestMapping("/updateScreen")
        public void updateScreen(String model,String searchDistance,String searchAge,String searchSex,String sexStatus,String carCertificationStatus,HttpServletRequest request,HttpServletResponse response){
            //获取当前用户
            UserBO loginUser = super.getLoginUser(request);
            //如果为空将结束
            if (loginUser==null){
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000000"));
                super.safeJsonPrint(response, json);
                return;
            }
            //参数验证
            if (StringUtils.isEmpty(model)){
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, json);
                return;
            }
            modelService.updateScreen(loginUser.getId(),model,searchDistance,searchAge,searchSex,sexStatus,carCertificationStatus);
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("筛选条件更新成功！"));
            super.safeJsonPrint(response, json);
            return;

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
        super.setCookie(response, SysConstants.CURRENT_LOGIN_CLIENT_ID, uuid, 60*60*24*30);
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
     * 修改用户信息
     */
    @RequestMapping("/updateUser")
    public void updateUser(HttpServletRequest request, HttpServletResponse response,UserBO userBO){
        //获取当前用户
        UserBO loginUser = super.getLoginUser(request);
        //如果为空将结束
        if (loginUser==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000000"));
            super.safeJsonPrint(response, json);
            return;
        }
        if(userBO==null||userBO.getId()==null||userBO.getId().equals("")){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, json);
            return;
        }
        Long id = loginUser.getId();
        userBO.setId(id);
        userService.updateUser(userBO);
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("修改成功"));
        super.safeJsonPrint(response, json);
        return;

    }

    /**
     * 获取用户信息
     */
    @RequestMapping("/getUserInfo")
    public void getUserInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取当前用户
        UserBO loginUser = super.getLoginUser(request);
        //如果为空将结束
        if (loginUser==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000000"));
            super.safeJsonPrint(response, json);
            return;
        }
        Long id = loginUser.getId();
        UserBO userBO=userService.selectById(id);
        String json = JsonUtils.getJsonString4JavaPOJO(userBO);
        super.safeJsonPrint(response, json);
    }


    /**
     *
     * @param request
     * @param response
     * @param latitude  纬度
     * @param longitude 经度
     */
    @RequestMapping("/updateLocation")
    public void updateLocation(HttpServletRequest request, HttpServletResponse response,Double latitude,Double longitude) {
        //获取当前用户
        UserBO loginUser = super.getLoginUser(request);
        //如果为空将结束
        if (loginUser==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000000"));
            super.safeJsonPrint(response, json);
            return;
        }
        if (latitude==null || longitude==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, json);
            return;
        }
        userService.updateLocation(loginUser.getId(),latitude,longitude);
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        super.safeJsonPrint(response, json);
    }


    //查询地区列表
    @RequestMapping("/getChinaRegionBOList")
    public void getChinaRegionBOList(HttpServletResponse response, HttpServletRequest request) throws InterruptedException {
        List<ChinaRegionBO> list= userService.getChinaRegionBOList();
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(list));
        super.safeJsonPrint(response, json);
    }

    //添加车辆认证
    @RequestMapping("/addCarCertificationBO")
    public void addCarCertificationBO(CarCertificationBO carCertificationBO, HttpServletResponse response, HttpServletRequest request) throws InterruptedException {
        UserBO userBO=super.getLoginUser(request);
        carCertificationBO.setUserId(userBO.getId());
        carCertificationBO.setPhone(userBO.getPhone());
        userService.addCarCertificationBO(carCertificationBO);
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(""));
        super.safeJsonPrint(response, json);
    }
}
