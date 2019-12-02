package com.wisewin.circle.web.controller;

import com.wisewin.circle.common.constants.UserConstants;
import com.wisewin.circle.entity.bo.ModelBO;
import com.wisewin.circle.entity.bo.UserBO;
import com.wisewin.circle.entity.dto.ResultDTO;
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


}
