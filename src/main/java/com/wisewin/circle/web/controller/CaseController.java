package com.wisewin.circle.web.controller;

import com.wisewin.circle.entity.bo.AdminBO;
import com.wisewin.circle.entity.bo.CaseBO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.service.CaseService;
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
 * @author Shibo Sun
 *         主机controller
 */
@Controller
@RequestMapping("/Case")
public class CaseController extends BaseCotroller {

    static final Logger log = LoggerFactory.getLogger(CaseController.class);

    @Resource
    private CaseService caseService;

    @RequestMapping("/getCases")
    public void getCases(HttpServletRequest request, HttpServletResponse response) {
        CaseBO caseBO=caseService.getCases();
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(caseBO));
        super.safeJsonPrint(response, json);

    }

}
