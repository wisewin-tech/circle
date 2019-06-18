package com.wisewin.circle.web.controller;

import com.wisewin.circle.entity.bo.AdminBO;
import com.wisewin.circle.entity.bo.RelationBO;
import com.wisewin.circle.entity.bo.UserBO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.service.RelationService;
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

/**
 * 关系
 */
@Controller
@RequestMapping("/Relation")
public class RelationController extends BaseCotroller {

    static final Logger log = LoggerFactory.getLogger(RelationController.class);

    @Resource
    private RelationService relationService;

    @RequestMapping("/addRelation")
    public void addRelation(RelationBO relationBO, HttpServletRequest request,HttpServletResponse response) {
        //获取当前用户
        UserBO loginUser = super.getLoginUser(request);
        //判断参数是否为空
        if (loginUser==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000000"));
            super.safeJsonPrint(response, json);
            return;
        }
        if (relationBO==null||relationBO.getUserId()==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, json);
            return;
        }
        relationBO.setUserIdMain(loginUser.getId());
        boolean bool=relationService.addRelation(relationBO);
        if(bool){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("添加成功"));
            super.safeJsonPrint(response, json);
        }else{
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("1111111"));
            super.safeJsonPrint(response, json);
        }

    }

}
