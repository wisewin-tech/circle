package com.wisewin.circle.service;

import com.wisewin.circle.dao.UserCertificationDemoDAO;
import com.wisewin.circle.entity.bo.UserCertificationDemo;
import com.wisewin.circle.entity.dto.ResultDTO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * @Author: Wang bin
 * @date: Created in 13:33 2019/11/12
 */
@Service
@Transactional
public class UserCertificationDemoService {

    @Resource
    private UserCertificationDemoDAO userCertificationDemoDAO;

    /**
     * 随机返回一张姿势图
     * @return
     */
    public ResultDTO queryUserCertificationDemo(){
        List<UserCertificationDemo> list = userCertificationDemoDAO.selectUserCertificationDemo();
        Random random = new Random();
        int i = random.nextInt(list.size());
        UserCertificationDemo userCertificationDemo =  list.get(i);
        return ResultDTOBuilder.success(userCertificationDemo);
    }
}
