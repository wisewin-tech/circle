package com.wisewin.circle.web.controller;

import com.wisewin.circle.entity.bo.Matching;
import com.wisewin.circle.entity.dto.ResultDTO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.service.MatchingService;
import com.wisewin.circle.util.JsonUtils;
import com.wisewin.circle.util.StringUtils;
import com.wisewin.circle.web.controller.base.BaseCotroller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Wang bin
 * @date: Created in 13:26 2019/11/19
 */
@RequestMapping("/matching")
@Controller
public class MatchingController extends BaseCotroller {

    @Resource
    private MatchingService matchingService;

    @RequestMapping(value = "/accouplement",method = RequestMethod.POST)
    public void matching(HttpServletRequest request, HttpServletResponse response,String model, String forUser, String status){
        String loginID = super.getLoginID(request);
        Matching matching = new Matching();
        if(StringUtils.isEmpty(loginID)){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000000"));
            super.safeJsonPrint(response, json);
            return;
        }
        matching.setUserId(Long.parseLong(loginID));
        if(StringUtils.isEmpty(model)){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, json);
            return;
        }

        if(StringUtils.isEmpty(forUser)){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, json);
            return;
        }
        matching.setForUser(Long.parseLong(forUser));
        if(StringUtils.isEmpty(status)){
            String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, json);
            return;
        }
        ResultDTO resultDTO = null;
        matching.setOperationStatus(status);
        if("date".equals(model)){
             resultDTO = matchingService.dateMatching(matching);
        }
        if("car".equals(model)){
             resultDTO = matchingService.dateMatching(matching);
        }
        if("friend".equals(model)){
             resultDTO = matchingService.dateMatching(matching);
        }
        String jsonString4JavaPOJO = JsonUtils.getJsonString4JavaPOJO(resultDTO);
        super.safeJsonPrint(response, jsonString4JavaPOJO);
        return;
    }

}
