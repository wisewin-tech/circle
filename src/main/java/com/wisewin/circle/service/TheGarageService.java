package com.wisewin.circle.service;

import com.wisewin.circle.dao.TheGarageDAO;
import com.wisewin.circle.entity.bo.TheGarageBO;
import com.wisewin.circle.entity.dto.param.TheGarageParam;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 车库
 */
@Service
@Transactional
public class TheGarageService {

    @Resource
    private TheGarageDAO theGarageDAO;


    /**
     * 添加车库认证
     * Integer userId; //用户id
     * String plateNumber; //车牌号
     * String brandModel; //品牌型号
     * String headingCode;  //车辆识别码
     * String certificationPictures; //认证图片
     * Integer status; //认证状态
     */
    public boolean getaddTheGarage(TheGarageParam param){
        TheGarageBO theGarageBO=new TheGarageBO(param.getUserId(),param.getPlateNumber(),param.getBrandModel(),param.getHeadingCode(),
                param.getCertificationPictures(),param.getStatus());
        return  theGarageDAO.addTheGarage(theGarageBO)>0;
    }

}
