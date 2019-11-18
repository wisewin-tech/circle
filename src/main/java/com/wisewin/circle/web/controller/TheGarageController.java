package com.wisewin.circle.web.controller;

import com.wisewin.circle.common.constants.TheGarageConstants;
import com.wisewin.circle.entity.bo.UserBO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.entity.dto.param.TheGarageParam;
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
@RequestMapping("/theGarage")
public class TheGarageController extends BaseCotroller {

    @Resource
    private TheGarageService theGarageService;
    /**
     * 添加车库认证
     * Integer userId; //用户id
     * String plateNumber; //车牌号
     * String brandModel; //品牌型号
     * String headingCode;  //车辆识别码
     * String certificationPictures; //认证图片
     * String status; //认证状态
     */
    @RequestMapping("/addTheGarage")
    public void addTheGarage(HttpServletRequest request, HttpServletResponse response, TheGarageParam param){
        //获取当前用户
        UserBO loginUser = super.getLoginUser(request);
        Integer id = loginUser.getId();

        //判断参数是否为空
        if (id.equals("")  || StringUtils.isEmpty(param.getPlateNumber()) || StringUtils.isEmpty(param.getBrandModel()) || StringUtils.isEmpty(param.getHeadingCode())){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, json);
            return;
        }
        //查询车库是否存在车牌
        int findTheGaragejoin=theGarageService.getfindTheGarage(param.getPlateNumber());
        if (findTheGaragejoin>0){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000010"));
            super.safeJsonPrint(response, json);
            return;
        }

        //添加车库信息
        boolean addTheGaragejoin=theGarageService.getaddTheGarage(id,param.getPlateNumber(),param.getBrandModel(),param.getHeadingCode(),param.getCertificationPictures(),TheGarageConstants.UNREVIEWED.getValue());
        if (addTheGaragejoin){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(" "));
            super.safeJsonPrint(response, json);
            return;
        }
    }
}
