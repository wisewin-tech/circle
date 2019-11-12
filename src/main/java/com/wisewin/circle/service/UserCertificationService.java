package com.wisewin.circle.service;

import com.wisewin.circle.dao.UserCertificationDAO;
import com.wisewin.circle.entity.bo.UserCertification;
import com.wisewin.circle.entity.dto.ResultDTO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Author: Wang bin
 * @date: Created in 14:07 2019/11/12
 */
@Service
@Transactional
public class UserCertificationService {

    @Resource
    private UserCertificationDAO userCertificationDAO;

    /**
     * 添加认证信息到审核
     * @return
     */
    public ResultDTO insertUserCertification(UserCertification userCertification, Integer userId){
        if(org.springframework.util.StringUtils.isEmpty(userCertification)){
            return ResultDTOBuilder.failure("0000001");
        }
        userCertification.setUserId(userId);
        userCertification.setStatus("not");
        int i = userCertificationDAO.insertUserCertification(userCertification);
        if(i > 0){
            return ResultDTOBuilder.success("","1000000");
        }
        return ResultDTOBuilder.failure("1111111");
    }
}
