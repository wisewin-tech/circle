package com.wisewin.circle.web.controller;

import com.wisewin.circle.common.constants.UserConstants;
import com.wisewin.circle.entity.bo.ModelBO;
import com.wisewin.circle.entity.bo.UserBO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.service.ModelService;
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
@RequestMapping("/model")
public class ModelController extends BaseCotroller {

    static final Logger log = LoggerFactory.getLogger(ModelController.class);

    @Resource
    private ModelService modelService;

    /**
     *修改某个用户某个模式的筛选条件
     * @param modelBO
     * @param response
     * @param request
     */
    @RequestMapping("/updateModel")
    public void updateModel(ModelBO modelBO,HttpServletResponse response, HttpServletRequest request) {
        //获取当前用户
        UserBO loginUser = super.getLoginUser(request);
        //如果为空将结束
        if (loginUser==null){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000000"));
            super.safeJsonPrint(response, json);
            return;
        }
        //参数验证
        if (modelBO.getUserId()==null|| StringUtils.isEmpty(modelBO.getModel())){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, json);
            return;
        }
        modelService.updateModel(modelBO);
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("筛选条件更新成功！"));
        super.safeJsonPrint(response, json);
        return;



    }


}
