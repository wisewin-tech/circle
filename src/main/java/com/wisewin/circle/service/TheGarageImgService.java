package com.wisewin.circle.service;


import com.wisewin.circle.dao.TheGarageDAO;
import com.wisewin.circle.dao.TheGarageImgDAO;
import com.wisewin.circle.entity.bo.TheGarageImgBO;
import com.wisewin.circle.entity.dto.param.TheGarageImgParam;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 我的车库
 */
@Service
@Transactional
public class TheGarageImgService {

    @Resource
    private TheGarageImgDAO theGarageImgDAO;


    /**
     * 添加车库
     */
    public boolean addTheGarageImg(Integer id,TheGarageImgParam param){

        TheGarageImgBO theGarageImgBO=new TheGarageImgBO(id,param.getImgUrl(),param.getSort());
        return  theGarageImgDAO.addTheGarageImg(theGarageImgBO)>0;
    }


}
