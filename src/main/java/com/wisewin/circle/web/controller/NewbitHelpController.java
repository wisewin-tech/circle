package com.wisewin.circle.web.controller;


import com.wisewin.circle.entity.bo.NewbitHelpBO;
import com.wisewin.circle.entity.bo.NewbitHelpContentBO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.service.NewbitHelpService;
import com.wisewin.circle.util.JsonUtils;
import com.wisewin.circle.web.controller.base.BaseCotroller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 新手帮助控制器层
 */
@Controller
@RequestMapping("/newbitHelp")
public class NewbitHelpController extends BaseCotroller {
    @Resource
    private NewbitHelpService newbitHelpService;

    /**
     * 查询新手帮助标题
     * @param request
     * @param response
     */
    @RequestMapping("/selectNewbitHelp")
    public void newbitHelpList(HttpServletRequest request, HttpServletResponse response){
        List<NewbitHelpBO> newbitHelpBOList = newbitHelpService.selectNewbitHelp();
        String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(newbitHelpBOList)) ;
        super.safeJsonPrint(response, result);

    }

    /**
     * 查询新手帮助内容
     * @param id
     * @param request
     * @param response
     */
    @RequestMapping("getNewbitHelpContent")
    public void getNewbitHelpContent(Integer id,HttpServletRequest request,HttpServletResponse response){
        if (id==null){
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, result);
            return;
        }
        NewbitHelpContentBO newbitHelpContentBO = newbitHelpService.getNewbitHelpContent(id);
        String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(newbitHelpContentBO));
        super.safeJsonPrint(response, result);

    }
}
