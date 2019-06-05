package com.wisewin.circle.web.controller;

import com.wisewin.circle.entity.bo.AdminBO;
import com.wisewin.circle.entity.bo.PatternBO;
import com.wisewin.circle.entity.bo.UserBO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.service.PatternService;
import com.wisewin.circle.service.TestService;
import com.wisewin.circle.util.JsonUtils;
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
import java.util.List;

/**
 * @author Shibo Sun
 *         主机controller
 */
@Controller
@RequestMapping("/Pattern")
public class PatternController extends BaseCotroller {

    static final Logger log = LoggerFactory.getLogger(PatternController.class);

    @Resource
    private PatternService patternService;

    //查询模式信息
    @RequestMapping("/getPattern")
    public void getPattern(HttpServletResponse response, HttpServletRequest request,String type) {
        //获取当前用户
        UserBO loginUser = super.getLoginUser(request);
        //如果为空将结束
        if (loginUser==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000000"));
            super.safeJsonPrint(response, json);
            return;
        }
        //参数异常
        if(type==null||type.equals("")){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, json);
            return;
        }
        Integer id = loginUser.getId();
        PatternBO patternBO=patternService.getPatternBO(type,id);
        String json = JsonUtils.getJsonString4JavaPOJO(patternBO);
        super.safeJsonPrint(response, json);
    }

    //修改筛选条件
    @RequestMapping("/updatePattern")
    public void updatePattern(HttpServletResponse response, HttpServletRequest request, PatternBO patternBO) {
        //获取当前用户
        UserBO loginUser = super.getLoginUser(request);
        //如果为空将结束
        if (loginUser==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000000"));
            super.safeJsonPrint(response, json);
            return;
        }
        //参数异常
        if(patternBO==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, json);
            return;
        }
        Integer id = loginUser.getId();
        patternBO.setUserId(id);
        if(patternService.updatePattern(patternBO)){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("修改成功"));
            super.safeJsonPrint(response, json);
        }else{
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("1111111"));
            super.safeJsonPrint(response, json);
        }



    }

    //查询用户所选的兴趣
    @RequestMapping("/getUserInterest")
    public void getUserInterest(HttpServletRequest request, HttpServletResponse response,String type) {
        //获取当前用户
        UserBO loginUser = super.getLoginUser(request);
        //判断参数是否为空
        if (loginUser==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000000"));
            super.safeJsonPrint(response, json);
            return;
        }
        if (type==null||type.length()==0){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, json);
            return;
        }
        List<String> result=patternService.getInterest(type,loginUser.getId());
        String json= JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(result));
        super.safeJsonPrint(response,json);
    }

    //修改用户兴趣
    @RequestMapping("/updateUserInterest")
    public void getUserInterest(HttpServletRequest request, HttpServletResponse response,String type,String interestJson) {
        //获取当前用户
        UserBO loginUser = super.getLoginUser(request);
        //判断参数是否为空
        if (loginUser==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000000"));
            super.safeJsonPrint(response, json);
            return;
        }
        if (type==null||type.length()==0||interestJson==null||interestJson.length()==0){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, json);
            return;
        }
        boolean bool=patternService.updateInterest(type,loginUser.getId(),interestJson);
        if(bool){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("修改成功"));
            super.safeJsonPrint(response, json);
        }else{
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("1111111"));
            super.safeJsonPrint(response, json);
        }
    }

}
