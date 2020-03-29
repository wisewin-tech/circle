package com.wisewin.circle.web.controller;

import com.wisewin.circle.entity.bo.UserBO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.service.TestService;
import com.wisewin.circle.service.UserService;
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
 * @author Shibo Sun
 * 主机controller
 */
@Controller
@RequestMapping("/car")
public class CarController extends BaseCotroller {

    static final Logger log = LoggerFactory.getLogger(CarController.class);

    @Resource
    private UserService userService;

    //获取座驾信息
    @RequestMapping("/getCarInfo")
    public void getCarInfo(HttpServletResponse response, HttpServletRequest request) {
        //获取当前用户
        UserBO loginUser = super.getLoginUser(request);
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(userService.getCarInfo(loginUser.getId())));
        super.safeJsonPrint(response, json);
        return;
    }

    //添加座驾照片
    @RequestMapping("/addCarPic")
    public void addCarPic(HttpServletResponse response, HttpServletRequest request,Long cerId,String carPic,String type) {
        //获取当前用户
        //UserBO loginUser = super.getLoginUser(request);
        if(type.equals("del")){
            userService.delCarPic(cerId,carPic);
        }else{
            userService.addCarPic(cerId,carPic);
        }

        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(null));
        super.safeJsonPrint(response, json);
        return;
    }

}
