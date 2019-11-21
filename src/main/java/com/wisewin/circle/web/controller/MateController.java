package com.wisewin.circle.web.controller;

import com.wisewin.circle.common.constants.UserConstants;
import com.wisewin.circle.entity.bo.UserBO;
import com.wisewin.circle.entity.bo.UserMsgBO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.service.MateService;
import com.wisewin.circle.service.UserService;
import com.wisewin.circle.util.JsonUtils;
import com.wisewin.circle.util.StringUtils;
import com.wisewin.circle.util.redisUtils.RedissonHandler;
import com.wisewin.circle.web.controller.base.BaseCotroller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mate")
public class MateController extends BaseCotroller {

    static final Logger log = LoggerFactory.getLogger(MateController.class);

    @Resource
    private MateService mateService;
    @Resource
    private UserService userService;
    @RequestMapping("/queryUser")
    public void queryUser(HttpServletRequest  request, HttpServletResponse response,String model){
        UserBO loginUser = super.getLoginUser(request);
        if(StringUtils.isEmpty(model) || loginUser==null){
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000000")) ;
            super.safeJsonPrint(response, result);
            return;
        }
        //不能获取位置信息不能进行匹配
        Map<String, Object> search =mateService.userCondition(loginUser.getId(), model);
        if(search.get("place")==null){
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000014")) ;
            super.safeJsonPrint(response, result);
            return;
        }

        //验证首次匹配
        String status = loginUser.getFrist().get(model);
        boolean flag=false;
        if(!UserConstants.Yes.getValue().equals(status)){
            //修改数据库改为 非第一次匹配
            userService.updateFirst(loginUser.getId(),model);
            //更新缓存
            loginUser.getFrist().put(model,"yes");
            String loginID = super.getLoginID(request);
            RedissonHandler.getInstance().set(loginID , loginUser , (long)60*60*24*30);
            flag=true;
        }
        List<UserMsgBO> matching = mateService.matching(model, loginUser, flag,search);
        String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(matching)) ;
        super.safeJsonPrint(response, result);
        return;
    }


}