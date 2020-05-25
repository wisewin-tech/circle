package com.wisewin.circle.web.controller;

import com.wisewin.circle.entity.bo.UserBO;
import com.wisewin.circle.entity.bo.UserInterestCustom;
import com.wisewin.circle.entity.bo.UserMsgBO;
import com.wisewin.circle.entity.dto.ConditionDTO;
import com.wisewin.circle.entity.dto.ResultDTO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.entity.dto.param.ModelParam;
import com.wisewin.circle.entity.dto.param.UserInterestParam;
import com.wisewin.circle.entity.dto.param.UserPictureParam;
import com.wisewin.circle.service.HomePageService;
import com.wisewin.circle.service.MateService;
import com.wisewin.circle.service.ModelService;
import com.wisewin.circle.service.UserService;
import com.wisewin.circle.util.JsonUtils;
import com.wisewin.circle.util.StringUtils;
import com.wisewin.circle.web.controller.base.BaseCotroller;
import io.swagger.client.model.User;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Author: Wang bin
 * @date: Created in 14:39 2019/11/11
 * 用户主页
 */
@Controller
@RequestMapping("/homepage")
public class HomePageController extends BaseCotroller {

    private static final Logger log = LoggerFactory.getLogger(HomePageController.class);

    @Resource
    private HomePageService homePageService;

    @Resource
    private ModelService modelService;

    @Autowired
    MateService mateService;

    @Autowired
    UserService userService;

    /**
     * 个人主页
     * @param request
     * @param response
     */
    @RequestMapping(value = "/information",method = RequestMethod.POST)
    public void information(HttpServletRequest request, HttpServletResponse response, String model){
        if (StringUtils.isEmpty(model)) {
            ResultDTOBuilder.failure("0000001");
        }
        String loginID = super.getLoginUser(request).getId()+"";
        log.info("model:{}",model);
        ResultDTO homepage = homePageService.homepage(model, Integer.parseInt(loginID));
        String jsonString4JavaPOJO = JsonUtils.getJsonString4JavaPOJO(homepage);
        super.safeJsonPrint(response, jsonString4JavaPOJO);
        return;
    }


    @RequestMapping("/othersInformation")
    public void othersInformation(HttpServletRequest  request, HttpServletResponse response,String model,Long userId,String phone){
        UserBO loginUser = super.getLoginUser(request);
        if(StringUtils.isEmpty(model) || loginUser==null){
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000000")) ;
            super.safeJsonPrint(response, result);
            return;
        }
        //不能获取位置信息不能进行匹配
        Map<String, Object> search =mateService.userConditionW(loginUser.getId(), model);
        if(search.get("place")==null){
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000014")) ;
            super.safeJsonPrint(response, result);
            return;
        }
        if(userId==null){
            UserBO userBO=userService.selectByPhone(phone);
            userId=userBO.getId();
        }
        UserMsgBO matching = mateService.getUserMsgW(userId,model,new BigDecimal(search.get("latitude").toString()),new BigDecimal(search.get("longitude").toString()));
        String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(matching)) ;
        super.safeJsonPrint(response, result);
        return;
    }

    /**
     * 修改主页个人信息
     * @param request
     * @param response
     * @param modelParam
     */
    @RequestMapping(value = "/modificationModel",method = RequestMethod.POST)
    public void modificationModel(HttpServletRequest request, HttpServletResponse response, ModelParam modelParam) throws IOException {
        if(modelParam.getUserId()==null){
            ResultDTOBuilder.failure("0000001");
        }
        if (org.springframework.util.StringUtils.isEmpty(modelParam)) {
            ResultDTOBuilder.failure("0000001");
        }

        ResultDTO resultDTO = homePageService.updateModel(modelParam,modelParam.getInterestBOList(),modelParam.getCustomInterestBOList());
        String jsonString4JavaPOJO = JsonUtils.getJsonString4JavaPOJO(resultDTO);
        super.safeJsonPrint(response, jsonString4JavaPOJO);
        return;
    }

    /**
     * 修改背景墙
     * @param request
     * @param response
     * @param userPictureParam
     */
    @RequestMapping(value = "/modificationUserPicture",method = RequestMethod.POST)
    public void modificationUserPicture(HttpServletRequest request, HttpServletResponse response,List<UserPictureParam> userPictureParam){
        ResultDTO resultDTO = homePageService.saveUserPircture(userPictureParam);
        String jsonString4JavaPOJO = JsonUtils.getJsonString4JavaPOJO(resultDTO);
        super.safeJsonPrint(response, jsonString4JavaPOJO);
        return;
    }

    /**
     * 修改兴趣
     * @param request
     * @param response
     * @param userInterestParams
     */
    @RequestMapping(value = "/modificationUserInterest",method = RequestMethod.POST)
    public void modificationUserInterest(HttpServletRequest request, HttpServletResponse response,List<UserInterestParam> userInterestParams){
        ResultDTO resultDTO = homePageService.saveUserInterest(userInterestParams);
        String jsonString4JavaPOJO = JsonUtils.getJsonString4JavaPOJO(resultDTO);
        super.safeJsonPrint(response, jsonString4JavaPOJO);
        return;
    }

    /**
     * 修改自定义标签
     * @param request
     * @param response
     */
    @RequestMapping(value = "/modificationUserInterestCustom",method = RequestMethod.POST)
    public void modificationUserInterestCustom(HttpServletRequest request, HttpServletResponse response,List<UserInterestCustom> list){
        ResultDTO resultDTO = homePageService.saveUserInterestCustom(list);
        String jsonString4JavaPOJO = JsonUtils.getJsonString4JavaPOJO(resultDTO);
        super.safeJsonPrint(response, jsonString4JavaPOJO);
        return;
    }


    /**
     * 添加自定义兴趣
     * @param request
     * @param response
     * @param userInterestCustom
     */
    @RequestMapping(value = "/insertUserInterestCustom",method = RequestMethod.POST)
    public void insertUserInterestCustom(HttpServletRequest request, HttpServletResponse response, UserInterestCustom userInterestCustom){
        ResultDTO resultDTO = homePageService.insertUserInterestCustom(userInterestCustom);
        String jsonString4JavaPOJO = JsonUtils.getJsonString4JavaPOJO(resultDTO);
        super.safeJsonPrint(response, jsonString4JavaPOJO);
        return;
    }

    /**
     * 模式切换
     * @param request
     * @param response
     */
    @RequestMapping("/handoverModel")
    public void handoverModel(HttpServletRequest request, HttpServletResponse response, Integer userId, String model){
        ResultDTO resultDTO = homePageService.handoverModel(userId, model);
        String result = JsonUtils.getJsonString4JavaPOJO(resultDTO) ;
        super.safeJsonPrint(response, result);
        return;
    }
}
