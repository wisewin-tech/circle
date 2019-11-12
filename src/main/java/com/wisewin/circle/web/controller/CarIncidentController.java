package com.wisewin.circle.web.controller;

import com.wisewin.circle.entity.bo.UserBO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.service.CarIncidentService;
import com.wisewin.circle.util.DateUtils;
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
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping("/carIncident")
public class CarIncidentController extends BaseCotroller {

    static final Logger log = LoggerFactory.getLogger(CarIncidentController.class);

    @Resource
    private CarIncidentService carIncidentService;

    /**
     * 兜风模式添加事件
     * @param origin 起点
     * @param destination 终点
     * @param incident 事件
     * @param incidentTime 事件时间 几点：20:00
     *  status 状态 yes/no 有效状态/无效状态
     * @param response
     * @param request
     */
    @RequestMapping("/addCarIncident")
    public void addCarIncident(String origin, String destination, String incident, String incidentTime,HttpServletResponse response, HttpServletRequest request) {
        //获取当前用户
        UserBO loginUser = super.getLoginUser(request);
        //如果为空将结束
        if (loginUser==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000000"));
            super.safeJsonPrint(response, json);
            return;
        }
        //参数验证
        if (StringUtils.isEmpty(origin)||StringUtils.isEmpty(destination)||(StringUtils.isEmpty(incident)&&StringUtils.isEmpty(incidentTime))){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, json);
            return;
        }

        int incidentNum = carIncidentService.selectIncidentNumByUserId(loginUser.getId());
        if (incidentNum>0){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000013"));
            super.safeJsonPrint(response, json);
            return;
        }
        String datearr = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
        String incidentTimes = datearr+" "+incidentTime+":00";
        carIncidentService.addCarIncident(loginUser.getId(),origin,destination,incident,incidentTimes,"yes");
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("兜风事件添加成功！"));
        super.safeJsonPrint(response, json);
        return;


    }

    /**
     * 取消兜风事件
     * @param response
     * @param request
     */
    @RequestMapping("/cancelCarIncident")
    public void cancelCarIncident(HttpServletResponse response, HttpServletRequest request) {
        //获取当前用户
        UserBO loginUser = super.getLoginUser(request);
        //如果为空将结束
        if (loginUser==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000000"));
            super.safeJsonPrint(response, json);
            return;
        }
        carIncidentService.cancelCarIncident(loginUser.getId(),"no");

        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("兜风事件取消成功！"));
        super.safeJsonPrint(response, json);
        return;


    }


}
