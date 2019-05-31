package com.wisewin.circle.web.controller;


import com.wisewin.circle.entity.bo.TheGarageBO;
import com.wisewin.circle.entity.bo.UserBO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.entity.dto.param.TheGarageImgParam;
import com.wisewin.circle.service.TheGarageImgService;
import com.wisewin.circle.service.TheGarageService;
import com.wisewin.circle.util.JsonUtils;
import com.wisewin.circle.util.StringUtils;
import com.wisewin.circle.web.controller.base.BaseCotroller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 车库
 */
@Controller
@RequestMapping("/theGarageImg")
public class TheGarageImgController extends BaseCotroller{

    @Resource
    private TheGarageService theGarageService;

    @Resource
    private TheGarageImgService theGarageImgService;

    /**
     * 查询当前用户是否审核通过或者是否有数据
     */
    @RequestMapping("/queryTheGarage")
    public void queryTheGarage(HttpServletRequest request, HttpServletResponse response, TheGarageImgParam param){

        //获取当前用户
        UserBO loginUser = super.getLoginUser(request);
        Integer id = loginUser.getId();

        if (id==null  || StringUtils.isObjEmpty(param.getImgUrl()) ) {
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, json);
            return;
        }

        //通过用户id来查询车库id
        TheGarageBO findIdTheGaragejoin=theGarageService.findIdTheGarage(id);

        //询当前用户是否审核通过或者是否有数据
        int queryTheGaragejoin=theGarageService.queryTheGarage(id);
        if (queryTheGaragejoin>0){
            //添加车库管理
            boolean addTheGarageImgjoin=theGarageImgService.addTheGarageImg(findIdTheGaragejoin.getId(),param);
            if (addTheGarageImgjoin){
                String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(" "));
                super.safeJsonPrint(response, json);
                return;
            }
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000011"));
        super.safeJsonPrint(response, json);
        return;

    }

}
